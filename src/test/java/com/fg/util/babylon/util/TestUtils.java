package com.fg.util.babylon.util;

import com.fg.util.babylon.entity.Configuration;
import com.fg.util.babylon.entity.DataFile;
import com.fg.util.babylon.entity.DataPropFile;
import com.fg.util.babylon.entity.PropertiesMap;
import com.fg.util.babylon.enums.PropertyStatus;

import java.util.Arrays;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class TestUtils {

    private TestUtils() {
    }

    public static DataFile createTestDataFile() {
        DataFile dataFile = new DataFile();
        DataPropFile propFile = new DataPropFile();
        propFile.putProperty("key", "value", PropertyStatus.NEW);
        propFile.putProperty("key2", "value2");
        PropertiesMap mutationProperties = new PropertiesMap();
        mutationProperties.put("key2", "dfdsg");
        propFile.putMutationProperties("en", mutationProperties);
        dataFile.putPropFile("my.properties", propFile);
        propFile = new DataPropFile();
        propFile.putProperty("key3", "value3");
        propFile.putProperty("key4", "value4");
        dataFile.putPropFile("my2.properties", propFile);
        return dataFile;
    }

    public static Configuration createTestConfiguration() {
        Configuration configuration = new Configuration("translation-db.json");
        configuration.addFileToPath("src\\test\\resources\\META-INF\\lib_eshop_edee\\country.properties");
        configuration.addFileToPath("src\\test\\resources\\META-INF\\09_mail_form\\messages.properties");
        configuration.addFileToPath("src\\test\\resources\\META-INF\\goPayGate\\*.properties");
        configuration.setMutations(Arrays.asList("en", "de"));
        return configuration;
    }

}
