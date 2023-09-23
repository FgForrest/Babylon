package one.edee.babylon.imp0rt;

import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;
import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.db.SnapshotManager;
import one.edee.babylon.db.SnapshotUtils;
import one.edee.babylon.entity.MessageFileContent;
import one.edee.babylon.entity.PropertiesMap;
import one.edee.babylon.enums.Action;
import one.edee.babylon.git.GitAdd;
import one.edee.babylon.git.RuntimeExecGitAdd;
import one.edee.babylon.msgfile.TranslationFileUtils;
import one.edee.babylon.properties.*;
import one.edee.babylon.sheets.SheetConstants;
import one.edee.babylon.sheets.gsheets.LightGSheetService;
import one.edee.babylon.snapshot.Snapshot;
import one.edee.babylon.statistics.ImportFileStatistic;
import one.edee.babylon.statistics.TranslationStatisticsOfImport;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Processor for {@link Action#IMPORT} action.
 *
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class ImportProcessor {

    private final SnapshotManager snapshotManager;
    private final List<FileLoader> propertyFileLoaders;
    private final LightGSheetService lightGSheetService;

    private final TranslationConfiguration configuration;

    private final GitAdd gitAdd;
    private final ImportSheetProcessor importSheetProcessor;

    public ImportProcessor(LightGSheetService lightGSheetService,
                           SnapshotManager snapshotManager,
                           List<FileLoader> propertyFileLoaders,
                           TranslationConfiguration configuration) {
        this.snapshotManager = snapshotManager;
        this.propertyFileLoaders = propertyFileLoaders;
        this.lightGSheetService = lightGSheetService;
        this.configuration = configuration;
        this.gitAdd = new RuntimeExecGitAdd();
        importSheetProcessor = new ImportSheetProcessor();
    }

    public void doImport(String googleSheetId) throws IOException, GeneralSecurityException, InterruptedException {
        log.info("Started translation IMPORT with Google sheet id: '" + googleSheetId + "'");
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
     *
     * @throws IOException some exception derived from {@link IOException}
     */
    private void saveDataFile(Snapshot snapshot, String dbFileName) throws IOException {
        if (!snapshot.getDataPropFiles().isEmpty()) {
            File toFile = new File(dbFileName);
            SnapshotUtils.writeSnapshot(snapshot, toFile);
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
     * Save all translated properties into target mutation file. Uses {@link FileActiveRecord} to ensure to that
     * file is stored in same format and keys is placed on same row numbers.
     *
     * @param mutation           mutation to save
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

        final FileLoader propertyFileLoader = propertyFileLoaders
                .stream()
                .filter(i -> i.canBeLoaded(mutationPropFilePath))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(mutationPropFilePath + " cannot be loaded by any file loader!"));

        final ImportFileStatistic fileStatistic = fs;
        // Load target properties file to get formatting and row numbers of all its properties.
        FileActiveRecord originalMutationFileProps = Optional.ofNullable(propertyFileLoader.loadPropertiesFromFile(mutationPropFilePath)).orElse(propertyFileLoader.createFileActiveRecord());
        // Load also properties of primary mutation file to get format from it.
        FileActiveRecord updatedFileProps = propertyFileLoader.loadPropertiesFromFile(primaryPropFilePath);
        // Clears all keys values in loaded primaryFileProps to create template for making of mutation properties file.
        // In this point we have clear format, this means each key and value on correct row,
        // empty rows and comments from primary mutation file is also on correct rows.
        updatedFileProps.values().forEach(property -> {
            if (property.isPropValue() || property.isPropValueMultiLine()) {
                property.setValue(SheetConstants.EMPTY_VAL);
            }
        });
        FileActiveRecord propsOnlyInMutation = propertyFileLoader.createFileActiveRecord();
        // Sets values of all keys from mutation properties file into updatedFileProps. Properties which exists only
        // in secondary mutation file is added to another map and append at end of mutation property file.
        originalMutationFileProps.forEach((key, sourceProp) -> {
            // Process only this values
            if (!sourceProp.isPropValue() && !sourceProp.isPropValueMultiLine()) {
                return;
            }
            AbstractProperty targetProp = updatedFileProps.get(key);
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
            AbstractProperty property = updatedFileProps.get(key);
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
            updatedFileProps.putAll(propsOnlyInMutation);
            log.info("Property keys only in mutation file \"" + String.join(",", propsOnlyInMutation.keySet()) + "\"");
        }

        PropertiesMap primaryProperties = messageFileContent.getProperties();
        // Removes all properties, that does not occur in sheet and was not in mutation properties file before - e.g. loaded from original props..
        List<String> propsToRemove = updatedFileProps
                .entrySet()
                .stream()
                .filter(k -> k.getValue().getValue().equals(SheetConstants.EMPTY_VAL) && !primaryProperties.containsKey(k.getKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        propsToRemove.forEach(updatedFileProps::remove);

        // Save changes into target file on disk.
        savePropertiesToFile(updatedFileProps, mutationPropFilePath, primaryPropFilePath);
    }

    private void savePropertiesToFile(FileActiveRecord propertyFileActiveRecord, String pathFileName, String primaryPropFilePath) {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(Paths.get(pathFileName)), StandardCharsets.UTF_8)) {
            propertyFileActiveRecord.save(outputStreamWriter, primaryPropFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Could not close the file " + pathFileName, e);
        }

        gitAdd.gitAddFile(pathFileName);
    }

}
