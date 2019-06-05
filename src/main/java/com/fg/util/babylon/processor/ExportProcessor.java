package com.fg.util.babylon.processor;


import com.fg.util.babylon.entity.DataPropFile;
import com.fg.util.babylon.entity.PropertiesMap;
import com.fg.util.babylon.entity.SheetParams;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.enums.PropertyStatus;
import com.fg.util.babylon.exception.SheetExistsException;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.ValueRange;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Processor for {@link Action#EXPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Component
@CommonsLog
public class ExportProcessor extends BaseProcessor {

    /** Regex for filter out possible secondary mutations files */
    private static final String REMOVE_MUTATIONS_REGEX = ".*_[a-zA-Z]{2,3}\\..*";

    @Override
    protected void processTranslation() throws IOException, GeneralSecurityException {
        for (String path : configuration.getPath()) {
            processPath(path);
        }
        uploadDataToGoogleSheet();
    }

    /**
     * Processing of one language property path (primary language properties files and its language mutations files).
     * @param path path to one or more primary properties files.
     * @throws IOException
     */
    private void processPath(String path) throws IOException {
        // Get all files from path by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
        List<String> propFilesPaths = getPropertiesFilesPathsFromPath(path);
        // Filter out possible mutations properties files, because we need only primary mutation properties files.
        propFilesPaths.removeIf(item -> item.matches(REMOVE_MUTATIONS_REGEX));
        log.info("Processing properties files: ");
        propFilesPaths.stream().forEach(propFilesPath -> log.info(propFilesPath));
        // Process all properties of all files.
        for (String propFilePath : propFilesPaths) {
            processPropertiesOfFile(propFilePath);
        }
    }

    /**
     * Gets all relative paths of files for given path by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
     * @param path Path can contains masked expressions for by org.springframework.core.io.support.PathMatchingResourcePatternResolver.
     * @return
     * @throws IOException
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
        Properties primaryProperties = loadPropertiesFromFile(primaryPropFilePath);
        if (primaryProperties == null) {
            throw new FileNotFoundException("Primary properties file: " + primaryPropFilePath + " not exists.");
        }
        Map<String, Properties> mutationsProperties = loadSecondaryMutationsProperties(primaryPropFilePath);
        for (Map.Entry<Object, Object> entry : primaryProperties.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            DataPropFile primaryDataPropFile = getOrCreateDataFile().getOrPutNewDataPropFile(primaryPropFilePath);
            // - porovná jejich hodnoty s hodnotou daného klíče v rámci daného souboru s hodnotou uloženou v datovém jsonu
            primaryDataPropFile.putProperty(key, value);
            /**
             * v rámci každého souboru projede všechny klíče a:
             * - porovná jejich hodnoty s hodnotou daného klíče v rámci daného souboru s hodnotou uloženou v datovém jsonu
             * - zkontroluje, že daný klíč existuje v souborech sekundárních mutací (nebo, že neexistují soubor/y sekundárních mutací)
             * pokud se:
             * - hodnota liší (byla provedena úprava v primární mutaci a je potřeba přeložit znovu všechny sekundární mutace)
             * - hodnota v jsonu úplně chybí (je to nová věc v primární mutace a je třeba ji přeložit do všech sekundárních mutací)
             * - nebo neexistuje soubor některé ze sekundárních mutacích uvedených v konfiguraci (je to nová mutace do které se bude překládat)
             */

            /**
             * ** zkontroluje, že daný klíč existuje v souborech sekundárních mutací (nebo, že neexistují soubor/y sekundárních mutací)
             */
            processSecondaryMutations(key, mutationsProperties, primaryPropFilePath, primaryDataPropFile);
        }
    }

    /**
     * Method loads all properties from mutation files for given primary language file.
     * @return returns map where key is mutation and value is properties loaded from mutation file.
     */
    private Map<String, Properties> loadSecondaryMutationsProperties(String primaryPropertyFilePath) throws IOException {
        Map<String, Properties> map = new HashMap<>();
        for (String mutation : configuration.getMutations()) {
            String secPropFileNamePath = getFileNameForMutation(primaryPropertyFilePath, mutation);
            Properties properties = loadPropertiesFromFile(secPropFileNamePath);
            if (properties == null) {
                log.warn("Properties file \"" + secPropFileNamePath + "\" for mutation: \"" + mutation + "\" doesn't exists");
            } else {
                map.put(mutation, properties);
            }
        }
        return map;
    }

    /**
     * Processing all defined secondary mutations of key, defined in configuration for given primary properties file.
     * @param key primary property key
     * @param filesMutationProps map with all properties from secondary mutation files
     * @param primaryPropertyFilePath file path of primary property
     * @param primaryDataPropFile data of primary property file
     * @throws IOException
     */
    private void processSecondaryMutations(String key,
                                           Map<String, Properties> filesMutationProps,
                                           String primaryPropertyFilePath,
                                           DataPropFile primaryDataPropFile) throws IOException {
        PropertyStatus primaryPropertyStatus = primaryDataPropFile.getPropertyStatus(key);
        for (String mutation : configuration.getMutations()) {
            final Properties properties = Optional.ofNullable(filesMutationProps.get(mutation)).orElse(new Properties());
            // Set value of property from existing properties file or set defaultValue if property not found.
            final String propValue = (String) Optional.ofNullable(properties.get(key)).orElse(EMPTY_VAL);
            // Log property not found if value is default and properties is not empty (which indicates a nonexistent mutation properties file)
            if (propValue.isEmpty() && !properties.isEmpty()) {
                String secPropFileNamePath = getFileNameForMutation(primaryPropertyFilePath, mutation);
                log.warn("Value for key \"" + key + "\" in properties file \"" + secPropFileNamePath + "\" for mutation \"" + mutation + "\" doesn't exists");
            }
            // TODO: sekundarni soubor se tam vubec davat nebude, informace o sekundarnich mutacich
            //  budou ulozeny do DataPropFile#mutationProperties
            PropertiesMap mutationPropsMap = Optional.ofNullable(primaryDataPropFile.getMutationProperties(mutation)).orElse(new PropertiesMap());
            mutationPropsMap.put(key, propValue, primaryPropertyStatus);
            primaryDataPropFile.putMutationProperties(mutation, mutationPropsMap);

//            DataPropFile secDataPropFile = getOrCreateDataFile().getOrPutNewDataPropFile(secPropFileNamePath);
//            // If property doesn't exists in DataFile or DataFile itself doesn't exists...
//            if (secDataPropFile.getPropertyValue(key) == null) {
//                // Set its status to NEW.
//                secDataPropFile.putProperty(key, EMPTY_VAL, PropertyStatus.NEW);
//            } else {
//                // Otherwise use primaryPropertyStatus
//                switch (primaryPropertyStatus) {
//                    case NEW:
//                    case CHANGED:
//                        secDataPropFile.putProperty(key, EMPTY_VAL);
//                        break;
//                    default:
//                        secDataPropFile.putProperty(key, propValue);
//                }
//                secDataPropFile.putPropertyStatus(key, primaryPropertyStatus);
//            }
        }
    }

    public void uploadDataToGoogleSheet() throws GeneralSecurityException, IOException {
        Map<String, DataPropFile> dataPropFiles = getOrCreateDataFile().getDataPropFiles();
        for (Map.Entry<String, DataPropFile> entry : dataPropFiles.entrySet()) {
            String sheetTitle = entry.getKey();
            log.info("Uploading data of " + sheetTitle + " to google sheet...");
            DataPropFile dataPropFile = entry.getValue();
            Integer columnCount = configuration.getMutations().size() + 2;
            Integer rowCount = dataPropFile.getProperties().size() + 1;
            SheetParams sheetParams = new SheetParams(sheetTitle, columnCount, rowCount);
            // Freeze first row (header)
            sheetParams.setFrozenRowCount(1);
            // Disabled temporary for testing.
            Sheet sheet = googleSheetService.addSheet(arguments.getGoogleSheetId(), sheetParams);
//            if (sheet != null) {
//                throw new SheetExistsException("Sheet \"" + sheetTitle + "\" already exists!");
//            }
            List<List<Object>> sheetData = new LinkedList<>();
            // Add header into sheet
            sheetData.addAll(createSheetHeader());
            // Add data into sheet
            sheetData.addAll(createSheetData(dataPropFile));
            googleSheetService.writeDataIntoSheet(arguments.getGoogleSheetId(), sheetTitle, sheetData);
            sheet = googleSheetService.getSheet(arguments.getGoogleSheetId(), sheetTitle);
            googleSheetService.setAutoResizeColumns(arguments.getGoogleSheetId(), sheet.getProperties().getSheetId());
            // TODO: Ukotvit prvni radek, mozna by bylo i dobre tu hlavicku nejak zvyraznit.
            // GridProperties#setFrozenRowCount udělal jsem v metodě addSheet nastavenim SheetParams#frozenRowCount
            // TODO: Skrýt první sloupec s klíči, protože ty nejsou pro překladatele důležité.
            /**
             * requests.append({
             *   'updateDimensionProperties': {
             *     "range": {
             *       "sheetId": sheet_id,
             *       "dimension": 'COLUMNS',
             *       "startIndex": 4,
             *       "endIndex": 5,
             *     },
             *     "properties": {
             *       "hiddenByUser": True,
             *     },
             *     "fields": 'hiddenByUser',
             * }})
             * Pro danou dimension nastavím skrytí takto. dimension nastavím na "COLUMNS"
             * a startIndex a endIndex nastavím na 1 abych skryl první sloupec.
             * Jako přepravku použiju přímo DimensionRange to se vyplatí.
             * UpdateDimensionPropertiesRequest#DimensionProperties#setHiddenByUser
             */
        }
    }

    private List<List<Object>> createSheetHeader() {
        List<List<Object>> sheetHeader = new LinkedList<>();
        List<Object> headerValues = new LinkedList<>(Arrays.asList("key", "primary"));
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
                String mutationValue = mutationsPropsMap.get(entry.getKey());
                rowValues.add(mutationValue);
            }
            sheetData.add(rowValues);
        }
        return sheetData;
    }

}
