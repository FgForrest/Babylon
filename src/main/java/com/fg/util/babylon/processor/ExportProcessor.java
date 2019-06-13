package com.fg.util.babylon.processor;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.DataPropFile;
import com.fg.util.babylon.entity.PropertiesMap;
import com.fg.util.babylon.entity.SheetParams;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.enums.PropertyStatus;
import com.fg.util.babylon.exception.SheetExistsException;
import com.fg.util.babylon.properties.FileProperties;
import com.fg.util.babylon.properties.PropValue;
import com.fg.util.babylon.properties.Property;
import com.fg.util.babylon.statistics.ExportFileStatistic;
import com.fg.util.babylon.statistics.TranslationStatisticsOfExport;
import com.fg.util.babylon.util.JsonUtils;
import com.google.api.services.sheets.v4.model.DimensionRange;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

/**
 * Processor for {@link Action#EXPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Component
@CommonsLog
public class ExportProcessor extends BaseProcessor {

    /** Regex for filter out possible secondary mutations files */
    private static final String REMOVE_MUTATIONS_REGEX = ".*_[a-zA-Z]{2,3}\\..*";

    private TranslationStatisticsOfExport statistics;

    @Override
    protected void processTranslation() throws IOException, GeneralSecurityException {
        statistics = new TranslationStatisticsOfExport();
        statistics.setAction(Action.EXPORT);
        for (String path : configuration.getPath()) {
            processPath(path);
        }
        uploadDataToGoogleSpreadsheet();
        saveDataFileWithoutProperties();
        log.info(statistics);
    }

    /**
     * Processing of one language property path (primary language properties files and its language mutations files).
     * @param path path to one or more primary properties files.
     * @throws IOException some exception derived from {@link IOException}
    */
    private void processPath(String path) throws IOException {
        // Get all files from path by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
        List<String> propFilesPaths = getPropertiesFilesPathsFromPath(path);
        // Filter out possible mutations properties files, because we need only primary mutation properties files.
        propFilesPaths.removeIf(item -> item.matches(REMOVE_MUTATIONS_REGEX));
        log.info("Processing properties files: ");
        propFilesPaths.forEach(log::info);
        statistics.incPrimaryPropFilesProcessed(propFilesPaths.size());
        // Process all properties of all files.
        for (String propFilePath : propFilesPaths) {
            processPropertiesOfFile(propFilePath);
        }
    }

    /**
     * Gets all relative paths of files for given path by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
     * @param path Path can contains masked expressions for by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
     * @return
     * @throws IOException some exception derived from {@link IOException}
    */
    private List<String> getPropertiesFilesPathsFromPath(String path) throws IOException {
        Resource[] resources = pathResolver.getResources("file:" + path);
        List<String> list = new ArrayList<>();
        for (Resource resource : resources) {
            String relativePath = resource.getURL().getPath();
            if (resource instanceof FileSystemResource) {
                relativePath = relativePath.substring(System.getProperty("user.dir").length() + 2);
            }
            list.add(relativePath);
        }
        return list;
    }

    private void processPropertiesOfFile(String primaryPropFilePath) throws IOException {
        FileProperties primaryProperties = loadPropertiesFromFile(primaryPropFilePath);
        if (primaryProperties == null) {
            throw new FileNotFoundException("Primary properties file: " + primaryPropFilePath + " not exists.");
        }
        statistics.incTotalPropFilesProcessed(1);
        Map<String, FileProperties> mutationsProperties = loadSecondaryMutationsProperties(primaryPropFilePath);
        for (Map.Entry<String, Property> entry : primaryProperties.entrySet()) {
            String key = entry.getKey();
            Property value = entry.getValue();
            // Skip processing of comments and empty lines, process only simple or multiline key=value values.
            if (!value.isPropValue() && !value.isPropValueMultiLine()) {
                continue;
            }
            DataPropFile primaryDataPropFile = getOrCreateDataFile().getOrPutNewPropFileByFileName(primaryPropFilePath);
            // Compares value to that key value within a given file with the value stored in the DataPropFile object read from Json data file.
            // - Keys which not found in Json data file is marked as NEW.
            // - Keys which value is different from value in Json data file is marked as CHANGED.
            primaryDataPropFile.putProperty(key, value.getValue());
            // Checks that the key exists in secondary mutation files (or that there are no secondary mutations)
            processSecondaryMutations(key, primaryPropFilePath, mutationsProperties, primaryDataPropFile);
        }
    }

    /**
     * Method loads all properties from mutation files for given primary language file.
     * @return returns map where key is mutation and value is properties loaded from mutation file.
     */
    private Map<String, FileProperties> loadSecondaryMutationsProperties(String primaryPropertyFilePath) throws IOException {
        Map<String, FileProperties> map = new HashMap<>();
        for (String mutation : configuration.getMutations()) {
            String secPropFileNamePath = getFileNameForMutation(primaryPropertyFilePath, mutation);
            FileProperties properties = Optional.ofNullable(loadPropertiesFromFile(secPropFileNamePath)).orElse(new FileProperties());
            if (!properties.isEmpty()) {
                statistics.incTotalPropFilesProcessed(1);
            }
            map.put(mutation, properties);
        }
        return map;
    }

    /**
     * Processing all defined secondary mutations of key, defined in configuration for given primary properties file.
     * @param key primary property key
     * @param primaryPropFilePath path to the primary mutation file
     * @param filesMutationProps map with all properties from secondary mutation files
     * @param primaryDataPropFile data of primary property file
     */
    private void processSecondaryMutations(String key,
                                           String primaryPropFilePath,
                                           Map<String, FileProperties> filesMutationProps,
                                           DataPropFile primaryDataPropFile) {
        PropertyStatus primaryPropStatus = primaryDataPropFile.getPropertyStatus(key);
        for (String mutation : configuration.getMutations()) {
            // Read all properties for secondary mutation.
            final FileProperties properties = Optional.ofNullable(filesMutationProps.get(mutation)).orElse(new FileProperties());
            // Get value of property from existing properties file or set empty value if property not found.
            Property propValue = Optional.ofNullable(properties.get(key)).orElse(new PropValue(EMPTY_VAL));
            PropertiesMap mutationPropsMap = primaryDataPropFile.getMutationProperties(mutation);
            if (mutationPropsMap == null) {
                mutationPropsMap = new PropertiesMap();
                primaryDataPropFile.putMutationProperties(mutation, mutationPropsMap);
            }
            String mutationPropFilePath = getFileNameForMutation(primaryPropFilePath, mutation);
            ExportFileStatistic fileStatistic = new ExportFileStatistic();
            statistics.putFileStatistic(mutationPropFilePath, fileStatistic);
            // If property doesn't exists in file of secondary mutation or file for secondary mutation doesn't exists...
            if (properties.get(key) == null) {
                // set its value to empty string and status to NEW.
                mutationPropsMap.put(key, EMPTY_VAL, PropertyStatus.NEW);
                fileStatistic.incNewKeysCnt();
            } else {
                // Otherwise use primaryPropStatus. This covers scenarios:
                // - new property in primary mutation file (key not exists in Json DataFile) -> status = NEW
                // - changes of property value in primary mutation file -> status = CHANGED, propValue = ""
                if (primaryPropStatus == PropertyStatus.CHANGED) {
                    propValue.setValue(EMPTY_VAL);
                    fileStatistic.incKeysToUpdateCnt();
                }
                mutationPropsMap.put(key, propValue.getValue(), primaryPropStatus);
            }
            fileStatistic.incTotalKeysCnt();
        }
    }

    /**
     * Uploads data {@link BaseProcessor#getOrCreateDataFile()} into google spreadsheet specified by {@link Arguments#getGoogleSheetId()}.
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    private void uploadDataToGoogleSpreadsheet() throws GeneralSecurityException, IOException {
        Map<String, DataPropFile> dataPropFiles = getOrCreateDataFile().getDataPropFiles();
        // Gets all existing sheets in this time.
        List<Sheet> prevAllSheets = googleSheetService.getAllSheets(arguments.getGoogleSheetId());
        for (Map.Entry<String, DataPropFile> entry : dataPropFiles.entrySet()) {
            String fileNamePath = entry.getKey();
            DataPropFile dataPropFile = entry.getValue();
            // Title of target google sheet is created from "properties fileName only" + "#" + "fileName id".
            String sheetTitle = FilenameUtils.getBaseName(fileNamePath) + "#" + dataPropFile.getId();
            log.info("Uploading data of \"" + fileNamePath + "\" into google sheet \"" + sheetTitle + "\"...");
            Sheet sheet = createGoogleSheet(dataPropFile, sheetTitle);
            if (sheet != null) {
                throw new SheetExistsException("Sheet \"" + sheetTitle + "\" already exists!");
            }
            uploadDataToGoogleSheet(dataPropFile, sheetTitle);
        }
        // Delete all previously existing sheets (usually default "Sheet 1" of new empty spreadsheet) if
        // current sheets count is greater then previous.
        List<Sheet> currAllSheets = googleSheetService.getAllSheets(arguments.getGoogleSheetId());
        if (currAllSheets.size() > prevAllSheets.size()) {
            googleSheetService.deleteSheets(arguments.getGoogleSheetId(), prevAllSheets);
        }
    }

    private Sheet createGoogleSheet(DataPropFile dataPropFile, String sheetTitle) throws GeneralSecurityException, IOException {
        Integer columnCount = configuration.getMutations().size() + 2;
        Integer rowCount = dataPropFile.getProperties().size() + 1;
        SheetParams sheetParams = new SheetParams(sheetTitle, columnCount, rowCount);
        // Freezes first row (header) to prevent scrolling of this row with rest of data.
        if (rowCount > 1) {
            sheetParams.setFrozenRowCount(1);
        }
        return googleSheetService.addSheet(arguments.getGoogleSheetId(), sheetParams);
    }

    private void uploadDataToGoogleSheet(DataPropFile dataPropFile, String sheetTitle) throws IOException, GeneralSecurityException {
        Sheet sheet;
        List<List<Object>> sheetData = new LinkedList<>();
        // Add header into sheet
        sheetData.addAll(createSheetHeader());
        // Add data into sheet
        sheetData.addAll(createSheetData(dataPropFile));
        googleSheetService.writeDataIntoSheet(arguments.getGoogleSheetId(), sheetTitle, sheetData);
        sheet = googleSheetService.getSheet(arguments.getGoogleSheetId(), sheetTitle);
        googleSheetService.setAutoResizeColumns(arguments.getGoogleSheetId(), sheet.getProperties().getSheetId());
        hideSheetFirstColumn(sheet.getProperties().getSheetId());
    }

    private List<List<Object>> createSheetHeader() {
        List<List<Object>> sheetHeader = new LinkedList<>();
        List<Object> headerValues = new LinkedList<>(Arrays.asList(COL_KEY, COL_PRIMARY));
        headerValues.addAll(configuration.getMutations());
        sheetHeader.add(headerValues);
        return sheetHeader;
    }

    private List<List<Object>> createSheetData(DataPropFile dataPropFile) {
        List<List<Object>> sheetData = new LinkedList<>();
        for (Map.Entry<String, String> entry : dataPropFile.getProperties().entrySet()) {
            // Add key name and primary mutation value
            List<Object> rowValues = new LinkedList<>(Arrays.asList(entry.getKey(), entry.getValue()));
            // Add all secondary mutations values
            for (String mutation : configuration.getMutations()) {
                PropertiesMap mutationsPropsMap = dataPropFile.getMutationProperties(mutation);
                if (mutationsPropsMap == null) {
                    mutationsPropsMap = new PropertiesMap();
                    dataPropFile.putMutationProperties(mutation, mutationsPropsMap);
                }
                String mutationValue = mutationsPropsMap.get(entry.getKey());
                rowValues.add(mutationValue);
            }
            sheetData.add(rowValues);
        }
        return sheetData;
    }

    /**
     * Hiding of first column which contains properties keys, because it's not important for workers in translation agency.
     * @param sheetId ID of the target sheet
     * @throws IOException some exception derived from {@link IOException}
     * @throws GeneralSecurityException
     */
    private void hideSheetFirstColumn(Integer sheetId) throws IOException, GeneralSecurityException {
        DimensionRange dimensionRange = new DimensionRange()
                .setSheetId(sheetId)
                .setDimension("COLUMNS")
                .setStartIndex(0)
                .setEndIndex(1);
        googleSheetService.hideDimensionRange(arguments.getGoogleSheetId(), dimensionRange);
    }

    /**
     * Saves created DataFile object without properties into file on disk. Only if DataFile not exists on disk!
     */
    private void saveDataFileWithoutProperties() throws IOException {
        File file = new File(configuration.getDataFileName());
        if (file.exists()) {
            log.info("DataFile \"" + file.getPath() + "\" already exists. File unchanged.");
            return;
        }
        String[] ignorableFieldNames = { "properties" };
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("DataPropFileFilter", SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames));
        JsonUtils.objToJsonFile(file, getOrCreateDataFile(), true, filters);
    }

}
