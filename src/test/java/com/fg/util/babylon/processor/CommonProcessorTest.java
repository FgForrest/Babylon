package com.fg.util.babylon.processor;

import com.fg.util.babylon.enums.PropertyType;
import com.fg.util.babylon.propfiles.FileProperties;
import com.fg.util.babylon.propfiles.Property;

import java.util.*;

/**
 * Class with common functionality for ExportProcessorTest and ImportProcessorTest.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
class CommonProcessorTest {

    static final String MUTATION_FILENAME_REGEX = ".*_[a-zA-Z]{2}.*";
    static final int TEST_KEYS_CNT = 5;

    List<String> mutations = new LinkedList<>(Collections.singletonList("en"));
    List<String> testPropFilesPaths = new LinkedList<>(Arrays.asList("A.properties", "A_en.properties", "B.properties", "B_en.properties"));
    LinkedHashMap<String, FileProperties> filePropsMap = new LinkedHashMap<>();

    /**
     * Generates default properties test data.
     */
    void loadDefaultFilesPropsMap() {
        loadFilesPropsMap(testPropFilesPaths);
    }

    /**
     * Generates properties test data for given list of FileNames
     * (simulates real properties files with expected generated data).
     * @param propFilesPaths List of FileNames.
     */
    private void loadFilesPropsMap(List<String> propFilesPaths) {
        propFilesPaths.forEach(fileName -> {
            // Key is by primary prop file fileName
            String key = fileName.replaceAll("_[a-zA-Z]{2}", "");
            FileProperties fileProperties = new FileProperties();
            for (int i=0 ; i < TEST_KEYS_CNT ; i++) {
                fileProperties.put((key + i), new Property(PropertyType.VALUE, "value " + fileName + i));
            }
            filePropsMap.put(fileName, fileProperties);
        });
    }

}
