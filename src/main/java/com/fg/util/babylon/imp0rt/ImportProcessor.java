package com.fg.util.babylon.imp0rt;

import com.fg.util.babylon.config.TranslationConfiguration;
import com.fg.util.babylon.git.GitAdd;
import com.fg.util.babylon.git.RuntimeExecGitAdd;
import com.fg.util.babylon.sheets.SheetConstants;
import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.entity.*;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.properties.*;
import com.fg.util.babylon.sheets.SheetsException;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import com.fg.util.babylon.sheets.gsheets.model.ASheet;
import com.fg.util.babylon.snapshot.Snapshot;
import com.fg.util.babylon.statistics.ImportFileStatistic;
import com.fg.util.babylon.statistics.TranslationStatisticsOfImport;
import com.fg.util.babylon.msgfile.TranslationFileUtils;
import com.fg.util.babylon.util.JsonUtils;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Processor for {@link Action#IMPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class ImportProcessor {

    private final SnapshotManager snapshotManager;
    private final PropertyFileLoader propertyFileLoader;
    private final LightGSheetService lightGSheetService;

    private final TranslationConfiguration configuration;

    private final GitAdd gitAdd;
    private final ImportSheetProcessor importSheetProcessor;

    public ImportProcessor(LightGSheetService lightGSheetService,
                           SnapshotManager snapshotManager,
                           PropertyFileLoader propertyFileLoader,
                           TranslationConfiguration configuration) {
        this.snapshotManager = snapshotManager;
        this.propertyFileLoader = propertyFileLoader;
        this.lightGSheetService = lightGSheetService;
        this.configuration = configuration;
        this.gitAdd = new RuntimeExecGitAdd();
        importSheetProcessor = new ImportSheetProcessor();
    }

    public void doImport(String googleSheetId) throws IOException, GeneralSecurityException, InterruptedException {
        log.info("Started translation IMPORT with Google sheet id: '" + googleSheetId +"'");
        TranslationStatisticsOfImport statistics = new TranslationStatisticsOfImport();
        statistics.setAction(Action.IMPORT);

        Snapshot snapshot = snapshotManager.getOrCreateDataFile();
        List<Sheet> sheets = lightGSheetService.listSheetsEagerly(googleSheetId);
        if (sheets == null || sheets.isEmpty()) {
            throw new IllegalArgumentException("Source spreadsheet " + googleSheetId + " not contains any sheets.");
        }
        // Using "for" loop to propagating of IOException.
        for (Sheet sheet : sheets) {
            importSheetProcessor.processSheet(sheet, snapshot);
        }

        Map<String, MessageFileContent> dataPropFiles = snapshotManager.getOrCreateDataFile().getDataPropFiles();
        saveTranslations(statistics, configuration.getMutations(), dataPropFiles);

        saveDataFile(snapshot, configuration.getDataFileName());

        log.info(statistics);
    }

    /**
     * Saves BaseProcessor#dataFile with all set primary mutation properties values into file on disk.
     * @throws IOException some exception derived from {@link IOException}
     */
    private void saveDataFile(Snapshot snapshot, String dbFileName) throws IOException {
        if (!snapshot.getDataPropFiles().isEmpty()) {
            JsonUtils.objToJsonFile(new File(dbFileName), snapshot, true);
        } else {
            throw new IllegalArgumentException("Cannot save empty DataFile object to file \"" + dbFileName + "\"");
        }
    }

    /**
     * Saves all translated secondary mutations properties into target properties files.
     */
    private void saveTranslations(TranslationStatisticsOfImport statistics, List<String> translationLangs, Map<String, MessageFileContent> dataPropFiles) throws IOException, InterruptedException {
        for (Map.Entry<String, MessageFileContent> entry : dataPropFiles.entrySet()) {
            String primaryPropFilePath = entry.getKey();
            MessageFileContent messageFileContent = entry.getValue();
            // Save all translated properties into all mutation files defined by configuration.
            for (String mutation : translationLangs) {
                saveMutationPropertiesToFile(primaryPropFilePath, mutation, messageFileContent, statistics);
            }
        }
    }

    /**
     * Save all translated properties into target mutation file. Uses {@link PropertyFileActiveRecord} to ensure to that
     * file is stored in same format and keys is placed on same row numbers.
     * @param mutation mutation to save
     * @param messageFileContent {@link MessageFileContent} object with data for target properties file
     * @throws IOException some exception derived from {@link IOException}
    */
    private void saveMutationPropertiesToFile(String primaryPropFilePath, String mutation, MessageFileContent messageFileContent, TranslationStatisticsOfImport statistics) throws IOException, InterruptedException {
        PropertiesMap mutationProperties = messageFileContent.getMutationProperties(mutation);
        String mutationPropFilePath = TranslationFileUtils.getFileNameForTranslation(primaryPropFilePath, mutation);
        if (mutationProperties == null || mutationProperties.isEmpty()) {
            String msg = "No properties found in source google sheet for import data into \"" + mutationPropFilePath + "\"";
            log.info(msg);
            return;
        }
        log.info("Saving translations into \"" + mutationPropFilePath + "\"...");
        ImportFileStatistic fs = statistics.getFileStatistic(mutationPropFilePath);
        if (fs == null) {
            fs = new ImportFileStatistic();
            statistics.putFileStatistic(mutationPropFilePath, fs);
        }
        final ImportFileStatistic fileStatistic = fs;
        // Load target properties file to get formatting and row numbers of all its properties.
        PFActiveRecord originalMutationFileProps = Optional.ofNullable(propertyFileLoader.loadPropertiesFromFile(mutationPropFilePath)).orElse(new PropertyFileActiveRecord());
        // Load also properties of primary mutation file to get format from it.
        PFActiveRecord updatedFileProps = propertyFileLoader.loadPropertiesFromFile(primaryPropFilePath);
        // Clears all keys values in loaded primaryFileProps to create template for making of mutation properties file.
        // In this point we have clear format, this means each key and value on correct row,
        // empty rows and comments from primary mutation file is also on correct rows.
        updatedFileProps.values().forEach(property -> {
            if (property.isPropValue() || property.isPropValueMultiLine()) {
                property.setValue(SheetConstants.EMPTY_VAL);
            }
        });
        PFActiveRecord propsOnlyInMutation = new PropertyFileActiveRecord();
        // Sets values of all keys from mutation properties file into updatedFileProps. Properties which exists only
        // in secondary mutation file is added to another map and append at end of mutation property file.
        originalMutationFileProps.forEach((key, sourceProp) -> {
            // Process only this values
            if (!sourceProp.isPropValue() && !sourceProp.isPropValueMultiLine()) {
                return;
            }
            IProperty targetProp = updatedFileProps.get(key);
            // Set values only for keys existing in primary mutation file.
            if (targetProp != null) {
                targetProp.setValue(sourceProp.getValue());
            } else {
                // Values which exists only in mutation properties file put into separate map
                // to add it at end of target mutation properties file. Row must be updated to value
                // after last row in updatedFileProps.
                propsOnlyInMutation.put(key, sourceProp);
            }
        });
        // Sets all values for keys from properties map (data from google sheet filled up by translation agency).
        mutationProperties.forEach((key, value) -> {
            IProperty property = updatedFileProps.get(key);
            if (property != null && !Objects.equals(value, property.getValue())) {
                property.setValue(value);
                updatedFileProps.put(key, property);
                fileStatistic.incUpdatedCnt();
                statistics.incTotalUpdatedCnt();
            }
        });
        // Add possible keys and values present only in mutation file to the end of the file.
        if (!propsOnlyInMutation.isEmpty()) {
            fileStatistic.setNotFoundInPrimaryFile(propsOnlyInMutation.size());
            statistics.incTotalNotFoundInPrimaryFile(propsOnlyInMutation.size());
            propsOnlyInMutation.forEach(updatedFileProps::put);
            log.info("Property keys only in mutation file \"" + String.join(",", propsOnlyInMutation.keySet()) + "\"");
        }
        // Removes all properties, that does not occur in sheet and was not in mutation properties file before - e.g. loaded from original props..
        List<String> propsToRemove = updatedFileProps
                .entrySet()
                .stream()
                .filter(k -> k.getValue().getValue().equals(SheetConstants.EMPTY_VAL) && !mutationProperties.containsKey(k.getKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        propsToRemove.forEach(updatedFileProps::remove);

        // Save changes into target file on disk.
        savePropertiesToFile(updatedFileProps, mutationPropFilePath);
    }

    private void savePropertiesToFile(PFActiveRecord propertyFileActiveRecord, String pathFileName) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(pathFileName), StandardCharsets.UTF_8);
        propertyFileActiveRecord.save(outputStreamWriter);

        gitAdd.gitAddFile(pathFileName);
    }

    /**
     * Defines sheet operations required by {@link ImportProcessor}.
     */
    public interface SheetContract {

        /**
         * Lists all sheets of spreadsheet {@code spreadsheetId}. Also fetches cell data of the sheets.
         *
         * @param spreadsheetId id of spreadsheet
         * @return sheets from {@code spreadsheetId}
         * @throws SheetsException when unable to list sheets
         */
        List<ASheet> loadSheets(String spreadsheetId) throws SheetsException;

    }

}
