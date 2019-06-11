package com.fg.util.babylon.processor;

import com.fg.util.babylon.entity.DataFile;
import com.fg.util.babylon.entity.DataPropFile;
import com.fg.util.babylon.entity.PropertiesMap;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.exception.*;
import com.fg.util.babylon.properties.FileProperties;
import com.fg.util.babylon.properties.Property;
import com.fg.util.babylon.util.JsonUtils;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.GridData;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

    @Override
    protected void processTranslation() throws IOException, GeneralSecurityException {
        List<Sheet> sheets = googleSheetService.getAllSheetsWithData(arguments.getGoogleSheetId());
        if (sheets == null || sheets.isEmpty()) {
            throw new NoSheetsException("Source spreadsheet " + arguments.getGoogleSheetId() + " not contains any sheets.");
        }
        // Processes data from google spreadsheet into internal BaseProcessor#dataFile object
        // accessible by BaseProcessor#getOrCreateDataFile() method.
        for (Sheet sheet : sheets) {
            processSheet(sheet);
        }
        saveTranslations();
        // Saves BaseProcessor#dataFile with all set primary mutation properties values into file on disk.
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
        Integer col = 0;
        Map<Integer,String> header = new LinkedHashMap<>();
        for (CellData cellData : headerData.getValues()) {
            String cellValue = cellData.getFormattedValue();
            header.put(col++, cellValue);
        }
        return header;
    }

    /**
     * Processes data of the one row in google sheet.
     * @param sheetTitle
     * @param header
     * @param rowData
     * @throws ParsePropIdException
     */
    private void processRowData(String sheetTitle, Map<Integer,String> header, RowData rowData) throws IOException {
        Integer col = 0;
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
     * @return
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
     * @param mutation
     * @param dataPropFile
     * @throws IOException some exception derived from {@link IOException}
    */
    private void saveMutationPropertiesToFile(String primaryPropFilePath, String mutation, DataPropFile dataPropFile) throws IOException {
        PropertiesMap mutationProperties = dataPropFile.getMutationProperties(mutation);
        String mutationPropFilePath = getFileNameForMutation(primaryPropFilePath, mutation);
        log.info("Saving translations into \"" + mutationPropFilePath + "\"...");
        if (mutationProperties == null || mutationProperties.isEmpty()) {
            String msg = "No properties found in source google sheet for import data into \"" + mutationPropFilePath + "\"";
            throw new MutationNotFoundException(msg);
        }
        // Load target properties file to get formatting and row numbers of all its properties.
        FileProperties originalMutationFileProps = Optional.ofNullable(loadPropertiesFromFile(mutationPropFilePath)).orElse(new FileProperties());
        // Load also properties of primary mutation file to get format from it.
        FileProperties updatedFileProps = loadPropertiesFromFile(primaryPropFilePath);
        // Clears all keys values in loaded primaryFileProps to create template for making of mutation properties file.
        // In this point we have clear format, this means each key and value on correct row,
        // empty rows and comments from primary mutation file  also on correct rows.
        updatedFileProps.values().forEach(property -> {
            if (property.isPropValue() || property.isPropValueMultiLine()) {
                property.setValue(EMPTY_VAL);
            }
        });
        // Get last row number in updatedFileProps
//        Integer maxRow = updatedFileProps.size();
        FileProperties propsOnlyInMutation = new FileProperties();
        // Sets values of all keys from mutation properties file into updatedFileProps. Properties which exists only
        // in secondary mutation file add to other map and append at end of mutation property file.
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
            property.setValue(value);
            updatedFileProps.put(key, property);
        });
        // Add possible keys and values present only in mutation file to the end of the file.
        if (!propsOnlyInMutation.isEmpty()) {
            propsOnlyInMutation.forEach((key, value) -> updatedFileProps.put(key, value));
            log.info("Property keys only in mutation file \"" + String.join(",", propsOnlyInMutation.keySet()) + "\"");
        }
        // Save changes into file on disk.
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(mutationPropFilePath), StandardCharsets.UTF_8);
        updatedFileProps.save(outputStreamWriter);
    }

}
