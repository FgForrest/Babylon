package com.fg.util.babylon.processor;


import com.fg.util.babylon.SheetConstants;
import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.*;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.enums.PropertyStatus;
import com.fg.util.babylon.enums.PropertyType;
import com.fg.util.babylon.exception.SheetExistsException;
import com.fg.util.babylon.propfiles.PropertyFileActiveRecord;
import com.fg.util.babylon.propfiles.Property;
import com.fg.util.babylon.service.GoogleSheetService;
import com.fg.util.babylon.statistics.ExportFileStatistic;
import com.fg.util.babylon.statistics.TranslationStatisticsOfExport;
import com.fg.util.babylon.todo.TranslationFileUtils;
import com.fg.util.babylon.util.JsonUtils;
import com.google.api.services.sheets.v4.model.DimensionRange;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Processor for {@link Action#EXPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class ExportProcessor {

    private final DataFileManager dataFileManager;
    private final AntPathResourceLoader resourceLoader;
    private final I18nFileManager i18nFileManager;
    private final GoogleSheetService googleSheetService;

    private final Arguments arguments;
    private final TranslationConfiguration configuration;

    protected TranslationStatisticsOfExport statistics;
    protected List<String> changedPropertiesDuringExport = new LinkedList<>();

    public ExportProcessor(GoogleSheetService googleSheetService,
                           DataFileManager dataFileManager,
                           I18nFileManager i18nFileManager,
                           AntPathResourceLoader resourceLoader,
                           Arguments arguments,
                           TranslationConfiguration configuration) {
        this.dataFileManager = dataFileManager;
        this.resourceLoader = resourceLoader;
        this.i18nFileManager = i18nFileManager;
        this.googleSheetService = googleSheetService;
        this.arguments = arguments;
        this.configuration = configuration;
    }

    /**
     * Id of the target google spreadsheet.
     */
    private String getGoogleSheetId() {
        return arguments.getGoogleSheetId();
    }

    public void doExport() throws IOException, GeneralSecurityException {
        log.info("Started translation EXPORT with Google sheet id: '" + getGoogleSheetId() +"'");
        statistics = new TranslationStatisticsOfExport();
        statistics.setAction(Action.EXPORT);
        // Using "for" loop to propagating of IOException
        for (String path : configuration.getPath()) {
            processPath(path);
        }
        uploadDataToGoogleSpreadsheet();
        saveDataFileWithoutProperties();
        log.info(statistics);
    }

    /**
     * Processing of one language property path (primary language properties files and its translation files).
     * @param path path to one or more primary properties files.
     * @throws IOException some exception derived from {@link IOException}
    */
    private void processPath(String path) throws IOException {
        List<String> allPaths = expandPath(path);

        final String TRANSLATION_FILES_REGEX = ".*_[a-zA-Z]{2,3}\\.properties";
        // Filter out possible mutations properties files, because we only need primary language property files
        allPaths.removeIf(item -> item.matches(TRANSLATION_FILES_REGEX));

        log.info("Processing property files: ");
        allPaths.forEach(log::info);
        statistics.incPrimaryPropFilesProcessed(allPaths.size()); //FIXME: should be called after the file has really been processed
        // Process all properties of all files.
        for (String propFilePath : allPaths) {
            processPropertiesOfFile(propFilePath);
        }
    }

    /**
     * Gets all relative paths of files for given path by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
     * @param path Path can contains masked expressions for by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
     * @return List of relative paths to files
     * @throws IOException some exception derived from {@link IOException}
    */
    private List<String> expandPath(String path) throws IOException {
        Resource[] resources = resourceLoader.getResources("file:" + path);
        List<String> list = new ArrayList<>();
        String currentDir = System.getProperty("user.dir");
        for (Resource resource : resources) {
            String relativePath = resource.getFile().getPath();
            // If is it absolute path then parse relative path to current directory.
            if (relativePath.startsWith(currentDir)) {
                relativePath = relativePath.substring(currentDir.length() + 1);
            }
            list.add(relativePath);
        }
        return list;
    }

    private void processPropertiesOfFile(String primaryPropFilePath) throws IOException {
        PropertyFileActiveRecord primaryProperties = i18nFileManager.loadPropertiesFromFile(primaryPropFilePath);
        if (primaryProperties == null) {
            throw new FileNotFoundException("Primary properties file: " + primaryPropFilePath + " does not exist.");
        }
        statistics.incTotalPropFilesProcessed(); //FIXME: should be called after the file has really been processed

        Map<String, PropertyFileActiveRecord> translationProperties = loadTranslationProperties(primaryPropFilePath);
        final MessageFile primaryMessageFile = dataFileManager.getOrCreateDataFile().getOrPutNewPropFileByFileName(primaryPropFilePath);
        changedPropertiesDuringExport.add(primaryPropFilePath);
        for (Map.Entry<String, Property> entry : primaryProperties.entrySet()) {
            String key = entry.getKey();
            Property value = entry.getValue();
            // Skip processing of comments and empty lines, process only simple or multiline key=value values.
            if (!value.isPropValue() && !value.isPropValueMultiLine()) {
                continue;
            }
            // Compares value to that key value within a given file with the value stored in the DataPropFile object read from Json data file.
            // - Keys which not found in Json data file is marked as NEW.
            // - Keys which value is different from value in Json data file is marked as CHANGED.
            primaryMessageFile.putProperty(key, value.getValue());
        }
        List<String> deprecatedProperties = new LinkedList<>();
        primaryMessageFile.getProperties().forEach((i, j)->{

            Property property = primaryProperties.get(i);
            if (property == null){
                deprecatedProperties.add(i);
            }
        });
        deprecatedProperties.forEach(i-> primaryMessageFile.getProperties().remove(i));

        for (Map.Entry<String, Property> entry : primaryProperties.entrySet()) {
            // Checks that the key exists in secondary mutation files (or that there are no secondary mutations)
            processSecondaryMutations(entry.getKey(), primaryPropFilePath, translationProperties, primaryMessageFile);
        }
    }

    /**
     * Method loads all properties from translation files for given primary language file.
     * @return returns map where key is mutation and value is properties loaded from translation file.
     */
    private Map<String, PropertyFileActiveRecord> loadTranslationProperties(String primaryPropertyFilePath) throws IOException {
        Map<String, PropertyFileActiveRecord> map = new HashMap<>();
        for (String language : configuration.getMutations()) {
            String translationFileNamePath = TranslationFileUtils.getFileNameForTranslation(primaryPropertyFilePath, language);
            PropertyFileActiveRecord properties = Optional.ofNullable(i18nFileManager.loadPropertiesFromFile(translationFileNamePath)).orElse(new PropertyFileActiveRecord());
            if (!properties.isEmpty()) {
                statistics.incTotalPropFilesProcessed();
            }
            map.put(language, properties);
        }
        return map;
    }

    /**
     * Processing all defined secondary mutations of key, defined in configuration for given primary properties file.
     * @param key primary property key
     * @param primaryPropFilePath path to the primary mutation file
     * @param filesMutationProps map with all properties from secondary mutation files
     * @param primaryMessageFile data of primary property file
     */
    private void processSecondaryMutations(String key,
                                           String primaryPropFilePath,
                                           Map<String, PropertyFileActiveRecord> filesMutationProps,
                                           MessageFile primaryMessageFile) {
        PropertyStatus primaryPropStatus = primaryMessageFile.getPropertyStatus(key);
        PropertiesMap mutationPropsMap;
        for (String mutation : configuration.getMutations()) {
            log.debug("Processing key \"" + key + "\" for mutation \"" + mutation + "\" of \"" + primaryPropFilePath + "\"");
            // Get all properties for secondary mutation.
            final PropertyFileActiveRecord properties = Optional.ofNullable(filesMutationProps.get(mutation)).orElse(new PropertyFileActiveRecord());
            // Get value of property from existing mutation properties file or set empty value if property not found.
            Property propValue = Optional.ofNullable(properties.get(key)).orElse(new Property(PropertyType.VALUE, SheetConstants.EMPTY_VAL));
            mutationPropsMap = getMutationPropertiesMap(primaryMessageFile, mutation);
            // Default status of mutation property is UNCHANGED.
            mutationPropsMap.putPropertyStatus(key, PropertyStatus.UNCHANGED);
            // Set default value from properties file
            mutationPropsMap.put(key, propValue.getValue());
            /* Resolves final status of the property value. If its status is not PropertyStatus.UNCHANGED then property will be exported. */
            // If property doesn't exists in file of secondary mutation or file for secondary mutation doesn't exists...
            if (properties.get(key) == null) {
                // set its value to empty string and status to MISSING.
                mutationPropsMap.put(key, SheetConstants.EMPTY_VAL, PropertyStatus.MISSING);
            } else if(primaryPropStatus == PropertyStatus.CHANGED) {
                mutationPropsMap.put(key, SheetConstants.EMPTY_VAL, PropertyStatus.CHANGED);
            } else {
                /* Otherwise compare key value from actual DataFile from data.json file on disk.
                   This covers scenarios:
                   - new property in primary mutation file (key not exists in Json DataFile) -> status = NEW
                   - changes of property value in primary mutation file -> status = CHANGED, propValue = ""
                   (secured in DataPropFile#putProperty(String key, String value) method)
                 */
                MessageFile propFileByFileName = null;
                // No json datafile exists on disk or no record for this file in Json DataFile on disk -> NEW
                if (dataFileManager.getOriginalDataFile() != null) { // FIXME: this can never happen, remove branch
                    propFileByFileName = dataFileManager.getOriginalDataFile().getPropFileByFileName(primaryPropFilePath);
                }
                if (propFileByFileName == null) {
                    mutationPropsMap.putPropertyStatus(key, PropertyStatus.NEW);
                } else {
                    // Value from json DataPropFile from disk.
                    String propVal = propFileByFileName.getProperties().get(key);
                    // Value is missing in json data file -> NEW
                    if (propVal == null ) {
                        mutationPropsMap.putPropertyStatus(key, PropertyStatus.NEW);
                    } else {
                        // Value in primary properties file is changed (against stored value in json DataFile) ->
                        // all secondary mutations must be translated again.
                        String primaryPropVal = primaryMessageFile.getPropertyValue(key);
                        if (!propVal.equals(primaryPropVal)) {
                            mutationPropsMap.put(key, SheetConstants.EMPTY_VAL, PropertyStatus.CHANGED);
                        }
                    }
                }
            }
            String mutationPropFilePath = TranslationFileUtils.getFileNameForTranslation(primaryPropFilePath, mutation);
            countStatistics(key, mutationPropsMap, mutationPropFilePath);
        }
        /* Set final primary properties status by statuses of this key in all secondary properties.
          - if all secondary properties for this key have status UNCHANGED then set primary property status to UNCHANGED
          - if at least one secondary properties status is not UNCHANGED then set primary property status to CHANGED
         */
        boolean allUnchanged = primaryMessageFile.getMutationProperties().values().stream().allMatch(propertiesMap ->
                propertiesMap.getPropertiesStatus().entrySet().stream()
                        .filter(entry -> entry.getKey().equals(key))
                        .allMatch(entry -> entry.getValue() == PropertyStatus.UNCHANGED)
        );
        primaryMessageFile.putPropertyStatus(key, allUnchanged ? PropertyStatus.UNCHANGED : PropertyStatus.CHANGED);
    }

    private PropertiesMap getMutationPropertiesMap(MessageFile primaryMessageFile, String mutation) {
        PropertiesMap mutationPropsMap;
        mutationPropsMap = primaryMessageFile.getMutationProperties(mutation);
        if (mutationPropsMap == null) {
            mutationPropsMap = new PropertiesMap();
            primaryMessageFile.putMutationProperties(mutation, mutationPropsMap);
        }
        return mutationPropsMap;
    }

    /**
     * Final Re-count of statistics by final status of property.
     * @param key key of property
     * @param mutationPropsMap map of mutation properties
     * @param mutationPropFilePath relative path to the mutation property file
     */
    private void countStatistics(String key, PropertiesMap mutationPropsMap, String mutationPropFilePath) {
        PropertyStatus primaryPropStatus;
        ExportFileStatistic fileStatistic = statistics.getFileStatistic(mutationPropFilePath);
        if (fileStatistic == null) {
            fileStatistic = new ExportFileStatistic();
            statistics.putFileStatistic(mutationPropFilePath, fileStatistic);
        }
        primaryPropStatus = mutationPropsMap.getPropertyStatus(key);
        if (primaryPropStatus == PropertyStatus.NEW) {
            fileStatistic.incNewKeysCnt();
            statistics.incTotalNewKeysCnt();
        } else if (primaryPropStatus == PropertyStatus.CHANGED) {
            fileStatistic.incKeysToUpdateCnt();
            statistics.incTotalKeysToUpdateCnt();
        } else if (primaryPropStatus == PropertyStatus.MISSING) {
            fileStatistic.incMissingKeysTranslationCnt();
            statistics.incTotalMissingKeysTranslationCnt();
        }
        fileStatistic.incTotalKeysCnt();
    }

    /**
     * Uploads data {@link DataFileManager#getOrCreateDataFile()} into google spreadsheet specified by {@link Arguments#getGoogleSheetId()}.
     * @throws GeneralSecurityException when authentication to Google sheets API problem is appeared.
     * @throws IOException some exception derived from {@link IOException}
    */
    private void uploadDataToGoogleSpreadsheet() throws GeneralSecurityException, IOException {
        Map<String, MessageFile> dataPropFiles = dataFileManager.getOrCreateDataFile()
                        .getDataPropFiles()
                        .entrySet()
                        .stream()
                        .filter(i->changedPropertiesDuringExport.contains(i.getKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        AtomicInteger processedCount = new AtomicInteger(0);
        // Gets all existing sheets in this time.
        List<Sheet> prevAllSheets = googleSheetService.getAllSheets(getGoogleSheetId());
        for (Map.Entry<String, MessageFile> entry : dataPropFiles.entrySet()) {
            String fileNamePath = entry.getKey();
            MessageFile messageFile = entry.getValue();

            uploadDataToGoogleSheet(messageFile, fileNamePath, processedCount);
        }
        // Delete all previously existing sheets (usually default "Sheet 1" of new empty spreadsheet) if
        // current sheets count is greater then previous.
        List<Sheet> currAllSheets = googleSheetService.getAllSheets(getGoogleSheetId());
        if (currAllSheets.size() > prevAllSheets.size()) {
            googleSheetService.deleteSheets(getGoogleSheetId(), prevAllSheets);
        }
    }

    private Sheet createGoogleSheet(List<List<Object>> sheetRows, String sheetTitle) throws GeneralSecurityException, IOException {
        Integer columnCount = sheetRows.get(0).size();
        Integer rowCount = sheetRows.size();
        SheetParams sheetParams = new SheetParams(sheetTitle, columnCount, rowCount);
        // Freezes first row (header) to prevent scrolling of this row with rest of data.
        if (rowCount > 1) {
            sheetParams.setFrozenRowCount(1);
            sheetParams.setFrozenColumnCount(2);
        }
        return googleSheetService.addSheet(getGoogleSheetId(), sheetParams);
    }

    private void uploadDataToGoogleSheet(MessageFile messageFile, String fileNamePath, AtomicInteger processedCount) throws IOException, GeneralSecurityException {
        // Add header into sheet
        List<List<Object>> sheetRows = new LinkedList<>(createSheetHeader());
        // Add data into sheet
        List<List<Object>> sheetData = createSheetData(messageFile);

        // If no data to upload return
        if (sheetData.isEmpty()) {
            log.info("No changed data for primary properties file and its mutation files: " + fileNamePath);
            return;
        }

        pauseProcessIfGoogleLimitExceed(sheetData.size(),processedCount);

        // Title of target google sheet is created from "properties fileName only" + "#" + "fileName id".
        String sheetTitle = FilenameUtils.getBaseName(fileNamePath) + "#" + messageFile.getId();
        log.info("Uploading data of \"" + fileNamePath + "\" into google sheet \"" + sheetTitle + "\"...");
        sheetRows.addAll(sheetData);
        Sheet sheet = createGoogleSheet(sheetRows, sheetTitle);
        if (sheet != null) {
            throw new SheetExistsException("Sheet \"" + sheetTitle + "\" already exists!");
        }

        googleSheetService.writeDataIntoSheet(getGoogleSheetId(), sheetTitle, sheetRows);
        sheet = googleSheetService.getSheet(getGoogleSheetId(), sheetTitle);
        googleSheetService.setWrappingStrategy(getGoogleSheetId(),sheet.getProperties().getSheetId());
        googleSheetService.resizeAllColumns(getGoogleSheetId(), sheet.getProperties().getSheetId());
        googleSheetService.protectFirstColumns(getGoogleSheetId(), sheet.getProperties().getSheetId());
        hideSheetFirstColumn(sheet.getProperties().getSheetId());
    }

    private void pauseProcessIfGoogleLimitExceed(int size, AtomicInteger processedCount) {
        // This sleep is cause of google limit where user cannot have more than 500 request in less than 100 secs
        // *2 is for updating styles :(
        int count = processedCount.addAndGet(size);
        // 300 is minus average keys that updates as frozen and protected cols
        if (count > 300){
            try {
                log.info("Google has it's limits I have to go to bed for about two minutes, so sorry :( .");
                Thread.sleep(120*1000L);
                processedCount.set(0);
            }catch (Exception e){
                // do nothing
            }
        }
    }

    private List<List<Object>> createSheetHeader() {
        List<List<Object>> sheetHeader = new LinkedList<>();
        List<Object> headerValues = new LinkedList<>(Arrays.asList(SheetConstants.COL_KEY, SheetConstants.COL_PRIMARY));
        headerValues.addAll(configuration.getMutations());
        sheetHeader.add(headerValues);
        return sheetHeader;
    }

    private List<List<Object>> createSheetData(MessageFile messageFile) {
        List<List<Object>> sheetData = new LinkedList<>();
        for (Map.Entry<String, String> entry : messageFile.getProperties().entrySet()) {
            // Add row only if status != UNCHANGED
            PropertyStatus propertyStatus = messageFile.getPropertyStatus(entry.getKey());
            if (propertyStatus == PropertyStatus.UNCHANGED) {
                continue;
            }
            // Replace doubled quotes in case of variable in property
            String entryValue = entry.getValue();
            if (entryValue.matches(".*\\{.}.*")){
                entryValue = entryValue.replace("''","'");
            }

            // Add key name and primary mutation value
            List<Object> rowValues = new LinkedList<>(Arrays.asList(entry.getKey(), entryValue));
            // Add all secondary mutations values
            for (String mutation : configuration.getMutations()) {
                PropertiesMap mutationsPropsMap = messageFile.getMutationProperties(mutation);
                if (mutationsPropsMap == null) {
                    mutationsPropsMap = new PropertiesMap();
                    messageFile.putMutationProperties(mutation, mutationsPropsMap);
                }
                String mutationValue = mutationsPropsMap.get(entry.getKey());
                // Replace doubled quotes in case of variable in property
                if (mutationValue != null && mutationValue.matches(".*\\{.}.*")) {
                    mutationValue = mutationValue.replace("''", "'");
                }

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
     * @throws GeneralSecurityException when authentication to Google sheets API problem is appeared.
     */
    private void hideSheetFirstColumn(Integer sheetId) throws IOException, GeneralSecurityException {
        DimensionRange dimensionRange = new DimensionRange()
                .setSheetId(sheetId)
                .setDimension("COLUMNS")
                .setStartIndex(0)
                .setEndIndex(1);
        googleSheetService.hideDimensionRange(getGoogleSheetId(), dimensionRange);
    }

    /**
     * Saves created DataFile object without properties into file on disk. Only if DataFile not exists on disk!
     */
    // FIXME: abstractions are wrong
    private void saveDataFileWithoutProperties() throws IOException {
        File file = new File(configuration.getDataFileName());
        Map<String, MessageFile> originalDataPropFiles = dataFileManager.getOriginalDataFile().getDataPropFiles();

        Snapshot overriddenSnapshot = dataFileManager.getOrCreateDataFile();
        overriddenSnapshot.getDataPropFiles().forEach((i, j)->{
            if (!originalDataPropFiles.containsKey(i)){
                j.setProperties(new PropertiesMap());
                originalDataPropFiles.put(i,j);
            }
        });

        JsonUtils.objToJsonFile(file, dataFileManager.getOriginalDataFile(), true);
    }

}
