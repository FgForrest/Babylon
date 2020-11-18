package com.fg.util.babylon.processor;

import com.fg.util.babylon.SheetConstants;
import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.*;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.exception.EmptyDataFileException;
import com.fg.util.babylon.exception.NoSheetsException;
import com.fg.util.babylon.exception.ParsePropIdException;
import com.fg.util.babylon.exception.PropIdNotFoundException;
import com.fg.util.babylon.propfiles.PropertyFileActiveRecord;
import com.fg.util.babylon.propfiles.Property;
import com.fg.util.babylon.service.GoogleSheetService;
import com.fg.util.babylon.statistics.ImportFileStatistic;
import com.fg.util.babylon.statistics.TranslationStatisticsOfImport;
import com.fg.util.babylon.todo.TranslationFileUtils;
import com.fg.util.babylon.util.JsonUtils;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.GridData;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

/**
 * Processor for {@link Action#IMPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class ImportProcessor {

    private final DataFileManager dataFileManager;
    private final I18nFileManager i18nFileManager;
    private final GoogleSheetService googleSheetService;

    private final String googleSheetId;
    private final TranslationConfiguration configuration;

    public ImportProcessor(GoogleSheetService googleSheetService,
                           DataFileManager dataFileManager,
                           I18nFileManager i18nFileManager,
                           String googleSheetId,
                           TranslationConfiguration configuration) {
        this.dataFileManager = dataFileManager;
        this.i18nFileManager =  i18nFileManager;
        this.googleSheetService = googleSheetService;
        this.googleSheetId = googleSheetId;
        this.configuration = configuration;
    }

    public void doImport() throws IOException, GeneralSecurityException, InterruptedException {
        log.info("Started translation IMPORT with Google sheet id: '" + googleSheetId +"'");
        TranslationStatisticsOfImport statistics = new TranslationStatisticsOfImport();
        statistics.setAction(Action.IMPORT);
        List<Sheet> sheets = googleSheetService.getAllSheetsWithData(googleSheetId);
        if (sheets == null || sheets.isEmpty()) {
            throw new NoSheetsException("Source spreadsheet " + googleSheetId + " not contains any sheets.");
        }
        // Using "for" loop to propagating of IOException.
        for (Sheet sheet : sheets) {
            processSheet(sheet);
        }
        saveTranslations(statistics);
        saveDataFile();
        log.info(statistics);
    }

    /**
     * Saves BaseProcessor#dataFile with all set primary mutation properties values into file on disk.
     * @throws IOException some exception derived from {@link IOException}
     */
    private void saveDataFile() throws IOException {
        Snapshot snapshot = dataFileManager.getOrCreateDataFile();
        if (!snapshot.getDataPropFiles().isEmpty()) {
            JsonUtils.objToJsonFile(new File(configuration.getDataFileName()), snapshot, true);
        } else {
            throw new EmptyDataFileException("Cannot save empty DataFile object to file \"" + configuration.getDataFileName() + "\"");
        }
    }

    private void processSheet(Sheet sheet) throws IOException {
        String sheetTitle = sheet.getProperties().getTitle();
        log.info("Processing sheet \"" + sheetTitle + "\"...");
        Integer fileId = parseFileIdFromSheetTitle(sheetTitle);
        MessageFileContent propFile = getPropFileById(fileId);

        List<GridData> sheetData = sheet.getData();
        if (sheetData == null || sheetData.isEmpty()) {
            log.warn("Sheet " + sheetTitle + " not contains any data in grid.");
            return;
        }
        for (GridData gridData : sheetData) {
            processGridDataOfSheet(sheetTitle, gridData, propFile);
        }
    }

    private void processGridDataOfSheet(String sheetTitle, GridData gridData, MessageFileContent propFile) throws IOException {
        List<RowData> rowsData = gridData.getRowData();
        if (rowsData == null) {
            log.warn("Sheet \"" + sheetTitle + " \" is empty");
            return;
        }
        // First row is header
        Map<Integer,String> header = createHeader(rowsData.get(0));
        for (RowData rowData : rowsData.subList(1, rowsData.size())) {
            if (rowData.getValues().stream().anyMatch(i-> i.getFormattedValue() != null && !Objects.equals(i.getFormattedValue(), "null"))){
                processRowData(sheetTitle, header, rowData, propFile);
            }
        }
    }

    private Map<Integer,String> createHeader(RowData headerData) {
        int col = 0;
        Map<Integer,String> header = new LinkedHashMap<>();
        for (CellData cellData : headerData.getValues()) {
            String cellValue = cellData.getFormattedValue();
            header.put(col++, cellValue);
        }
        return header;
    }

    /**
     * Processes data of the one row in google sheet.
     * @param sheetTitle Sheet title for target file identification
     * @param header header values with column numbers as keys
     * @param rowData data of the one row
     * @throws IOException some exception derived from {@link IOException}
     */
    private void processRowData(String sheetTitle, Map<Integer,String> header, RowData rowData, MessageFileContent propFile) throws IOException {
        int col = 0;
        List<CellData> values = rowData.getValues();
        String propKey = "";
        for (CellData cellData : values) {
            String colTitle = header.get(col);
            String propValue = cellData.getFormattedValue();

            // Double quotes in case of variable in property
            if (propValue != null && propValue.matches(".*\\{.}.*")){
                propValue = propValue.replace("'","''");
            }
            if (col == 0) {
                // First column contains properties keys.
                propKey = propValue;
            } else if (col == 1) {
                // Second column contains text value of primary mutation.
                propFile.putProperty(propKey, propValue);
            } else {
                // Next columns contains text values of secondary mutations. Column title contains name of the mutation.
                String mutation = colTitle;
                propFile.putMutationProperty(mutation, propKey, propValue);
            }
            col++;
        }
    }

    /**
     * Gets {@link MessageFileContent} object for one properties file by your unique id in json DataFile.
     * @param fileId unique file ID
     * @return Found {@link MessageFileContent} object or null if not found.
     * @throws IOException some exception derived from {@link IOException}
     */
    private MessageFileContent getPropFileById(Integer fileId) throws IOException {
        MessageFileContent propFile = dataFileManager.getOrCreateDataFile().getPropFileById(fileId);
        if (propFile == null) {
            String msg = "No record found by id=\"" + fileId + "\" in \"" + configuration.getDataFileName() + "\"";
            throw new PropIdNotFoundException(msg);
        }
        return propFile;
    }

    /**
     * Parse unique id of the target properties file from sheet title (title format is "FileName" + "#" + "UniqueId")
     * @param sheetTitle title of the sheet.
     * @return File ID parsed from sheet title.
     * @throws ParsePropIdException If unique id cannot be parse from title.
     */
    private Integer parseFileIdFromSheetTitle(String sheetTitle) throws ParsePropIdException {
        try {
            String[] split = sheetTitle.split("#");
            if (split.length != 2) {
                throw new ParsePropIdException("Cannot parse unique id from string \"" + sheetTitle + "\"");
            }
            return Integer.parseInt(split[1]);
        } catch (PatternSyntaxException | NumberFormatException e) {
            throw new ParsePropIdException(e.getMessage());
        }
    }

    /**
     * Saves all translated secondary mutations properties into target properties files.
     */
    private void saveTranslations(TranslationStatisticsOfImport statistics) throws IOException, InterruptedException {
        Map<String, MessageFileContent> dataPropFiles = dataFileManager.getOrCreateDataFile().getDataPropFiles();
        for (Map.Entry<String, MessageFileContent> entry : dataPropFiles.entrySet()) {
            String primaryPropFilePath = entry.getKey();
            MessageFileContent messageFileContent = entry.getValue();
            // Save all translated properties into all mutation files defined by configuration.
            for (String mutation : configuration.getMutations()) {
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
        PropertyFileActiveRecord originalMutationFileProps = Optional.ofNullable(i18nFileManager.loadPropertiesFromFile(mutationPropFilePath)).orElse(new PropertyFileActiveRecord());
        // Load also properties of primary mutation file to get format from it.
        PropertyFileActiveRecord updatedFileProps = i18nFileManager.loadPropertiesFromFile(primaryPropFilePath);
        // Clears all keys values in loaded primaryFileProps to create template for making of mutation properties file.
        // In this point we have clear format, this means each key and value on correct row,
        // empty rows and comments from primary mutation file is also on correct rows.
        updatedFileProps.values().forEach(property -> {
            if (property.isPropValue() || property.isPropValueMultiLine()) {
                property.setValue(SheetConstants.EMPTY_VAL);
            }
        });
        PropertyFileActiveRecord propsOnlyInMutation = new PropertyFileActiveRecord();
        // Sets values of all keys from mutation properties file into updatedFileProps. Properties which exists only
        // in secondary mutation file is added to another map and append at end of mutation property file.
        originalMutationFileProps.forEach((key, sourceProp) -> {
            // Process only this values
            if (!sourceProp.isPropValue() && !sourceProp.isPropValueMultiLine()) {
                return;
            }
            Property targetProp = updatedFileProps.get(key);
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
            Property property = updatedFileProps.get(key);
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

    private void savePropertiesToFile(PropertyFileActiveRecord propertyFileActiveRecord, String pathFileName) throws IOException, InterruptedException {

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(pathFileName), StandardCharsets.UTF_8);
        propertyFileActiveRecord.save(outputStreamWriter);

        gitAddFile(pathFileName);

    }

    private void gitAddFile(String pathFileName) throws IOException, InterruptedException {
        /* Doesn't matter whether it is already added or existing */
        log.info(FileSystems.getDefault().getPath(".").toAbsolutePath());
        int exdCode = Runtime.getRuntime().exec("git add " + pathFileName).waitFor();
        log.info("file git add ended with code : " + exdCode + " for file : " + pathFileName);
        // Try it again
        if (exdCode != 0){
            Process p  = Runtime.getRuntime().exec("git add " + pathFileName);
            exdCode=p.waitFor();
            if (exdCode != 0){
                log.info("Process exit code: " + exdCode);
                log.info("Result:");
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

                String line = "";
                while ((line = reader.readLine()) != null) {
                    log.warn(line);
                }
            }
        }
    }

}
