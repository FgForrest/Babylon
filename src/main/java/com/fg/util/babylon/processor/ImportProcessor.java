package com.fg.util.babylon.processor;

import com.fg.util.babylon.entity.DataFile;
import com.fg.util.babylon.entity.DataPropFile;
import com.fg.util.babylon.entity.PropertiesMap;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.exception.EmptyDataFileException;
import com.fg.util.babylon.exception.NoSheetsException;
import com.fg.util.babylon.exception.ParsePropIdException;
import com.fg.util.babylon.exception.PropIdNotFoundException;
import com.fg.util.babylon.properties.FileProperties;
import com.fg.util.babylon.properties.Property;
import com.fg.util.babylon.statistics.ImportFileStatistic;
import com.fg.util.babylon.statistics.TranslationStatisticsOfImport;
import com.fg.util.babylon.util.JsonUtils;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.GridData;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.PatternSyntaxException;

/**
 * Processor for {@link Action#IMPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Component
@CommonsLog
public class ImportProcessor extends BaseProcessor {

    protected TranslationStatisticsOfImport statistics;

    @Override
    protected void processTranslation() throws IOException, GeneralSecurityException {
        statistics = new TranslationStatisticsOfImport();
        statistics.setAction(Action.IMPORT);
        List<Sheet> sheets = googleSheetService.getAllSheetsWithData(arguments.getGoogleSheetId());
        if (sheets == null || sheets.isEmpty()) {
            throw new NoSheetsException("Source spreadsheet " + arguments.getGoogleSheetId() + " not contains any sheets.");
        }
        // Processes data from google spreadsheet into internal BaseProcessor#dataFile object
        // accessible by BaseProcessor#getOrCreateDataFile() method.
        // Using "for" loop to propagating of IOException.
        for (Sheet sheet : sheets) {
            processSheet(sheet);
        }
        saveTranslations();
        saveDataFile();
        log.info(statistics);
    }

    /**
     * Saves BaseProcessor#dataFile with all set primary mutation properties values into file on disk.
     * @throws IOException some exception derived from {@link IOException}
     */
    private void saveDataFile() throws IOException {
        DataFile dataFile = getOrCreateDataFile();
        if (!dataFile.getDataPropFiles().isEmpty()) {
            JsonUtils.objToJsonFile(new File(configuration.getDataFileName()), dataFile, true);
        } else {
            throw new EmptyDataFileException("Cannot save empty DataFile object to file \"" + configuration.getDataFileName() + "\"");
        }
    }

    private void processSheet(Sheet sheet) throws IOException {
        log.info("Processing sheet \"" + sheet.getProperties().getTitle() + "\"...");
        List<GridData> sheetData = sheet.getData();
        if (sheetData == null || sheetData.isEmpty()) {
            log.warn("Sheet " + sheet.getProperties().getTitle() + " not contains any data in grid.");
            return;
        }
        for (GridData gridData : sheetData) {
            processGridDataOfSheet(sheet.getProperties().getTitle(), gridData);
        }
    }

    private void processGridDataOfSheet(String sheetTitle, GridData gridData) throws IOException {
        List<RowData> rowsData = gridData.getRowData();
        if (rowsData == null) {
            log.warn("Sheet \"" + sheetTitle + " \" is empty");
            return;
        }
        // First row is header
        Map<Integer,String> header = createHeader(rowsData.get(0));
        for (RowData rowData : rowsData.subList(1, rowsData.size())) {
            processRowData(sheetTitle, header, rowData);
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
    private void processRowData(String sheetTitle, Map<Integer,String> header, RowData rowData) throws IOException {
        int col = 0;
        List<CellData> values = rowData.getValues();
        Integer fileId = parseFileIdFromSheetTitle(sheetTitle);
        String propKey = "";
        for (CellData cellData : values) {
            String colTitle = header.get(col);
            String propValue = cellData.getFormattedValue();
            if (col == 0) {
                // First column contains properties keys.
                propKey = propValue;
            } else if (col == 1) {
                // Second column contains text value of primary mutation.
                addPrimaryMutation(fileId, propKey, propValue);
            } else {
                // Next columns contains text values of secondary mutations. Column title contains name of the mutation.
                addSecondaryMutation(colTitle, fileId, propKey, propValue);
            }
            col++;
        }
    }

    private void addPrimaryMutation(Integer fileId, String propKey, String propValue) throws IOException {
        DataPropFile propFile = getPropFileById(fileId);
        propFile.putProperty(propKey, propValue);
    }

    private void addSecondaryMutation(String mutation, Integer fileId, String propKey, String propValue) throws IOException {
        DataPropFile propFile = getPropFileById(fileId);
        propFile.putMutationProperty(mutation, propKey, propValue);
    }

    /**
     * Gets {@link DataPropFile} object for one properties file by your unique id in json DataFile.
     * @param fileId unique file ID
     * @return Found {@link DataPropFile} object or null if not found.
     * @throws IOException some exception derived from {@link IOException}
     */
    private DataPropFile getPropFileById(Integer fileId) throws IOException {
        DataPropFile propFile = getOrCreateDataFile().getPropFileById(fileId);
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
    private void saveTranslations() throws IOException {
        Map<String, DataPropFile> dataPropFiles = getOrCreateDataFile().getDataPropFiles();
        for (Map.Entry<String, DataPropFile> entry : dataPropFiles.entrySet()) {
            String primaryPropFilePath = entry.getKey();
            DataPropFile dataPropFile = entry.getValue();
            // Save all translated properties into all mutation files defined by configuration.
            for (String mutation : configuration.getMutations()) {
                saveMutationPropertiesToFile(primaryPropFilePath, mutation, dataPropFile);
            }
        }
    }

    /**
     * Save all translated properties into target mutation file. Uses {@link FileProperties} to ensure to that
     * file is stored in same format and keys is placed on same row numbers.
     * @param mutation mutation to save
     * @param dataPropFile {@link DataPropFile} object with data for target properties file
     * @throws IOException some exception derived from {@link IOException}
    */
    private void saveMutationPropertiesToFile(String primaryPropFilePath, String mutation, DataPropFile dataPropFile) throws IOException {
        PropertiesMap mutationProperties = dataPropFile.getMutationProperties(mutation);
        String mutationPropFilePath = getFileNameForMutation(primaryPropFilePath, mutation);
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
        FileProperties originalMutationFileProps = Optional.ofNullable(loadPropertiesFromFile(mutationPropFilePath)).orElse(new FileProperties());
        // Load also properties of primary mutation file to get format from it.
        FileProperties updatedFileProps = loadPropertiesFromFile(primaryPropFilePath);
        // Clears all keys values in loaded primaryFileProps to create template for making of mutation properties file.
        // In this point we have clear format, this means each key and value on correct row,
        // empty rows and comments from primary mutation file is also on correct rows.
        updatedFileProps.values().forEach(property -> {
            if (property.isPropValue() || property.isPropValueMultiLine()) {
                property.setValue(EMPTY_VAL);
            }
        });
        FileProperties propsOnlyInMutation = new FileProperties();
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
            if (!value.equals(property.getValue())) {
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
        // Save changes into target file on disk.
        savePropertiesToFile(updatedFileProps, mutationPropFilePath);
    }

    private void savePropertiesToFile(FileProperties fileProperties, String pathFileName) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(pathFileName), StandardCharsets.UTF_8);
        fileProperties.save(outputStreamWriter);
    }

}
