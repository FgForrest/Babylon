package com.fg.util.translator.service;

import com.fg.util.translator.entity.Configuration;
import com.fg.util.translator.entity.PropertiesFile;
import com.fg.util.translator.util.JsonUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class TranslationServiceTest {

    /**
     * Checks of {@link Configuration} serialization from object to string and back.
     * @throws IOException
     */
    @Test
    public void checkConfigSerializationAndDeserialization() throws IOException {
        Configuration configuration = createTestConfiguration();
        String jsonString = JsonUtils.objToJsonString(configuration, true);
        assertFalse("JSON String is null or empty", StringUtils.isEmpty(jsonString));
        log.info(jsonString);
        Configuration configFromStr = JsonUtils.jsonObjFromString(jsonString, Configuration.class);
        assertNotNull("JSON object from string is null", configFromStr);
    }

    /**
     * Checks creation of json configuration file with data from test language properties file.
     * @throws IOException
     */
    @Test
    public void checkCreateConfigurationFromProperties() throws IOException {
        File file = new File("test-config.json");
        Configuration configuration = createTestConfiguration();
        configuration.setPrimaryDataFile("translation-db.json");
        configuration.setMutations(Arrays.asList("CZ","EN","DE"));
        JsonUtils.objToJsonFile(file, configuration, true);
        assertFalse("primaryDataFile is empty or null", StringUtils.isEmpty(configuration.getPrimaryDataFile()));
        assertFalse("propertiesFiles is empty", configuration.getPropertiesFiles().isEmpty());
        assertTrue("Configuration file not generated", file.exists());
    }

    @Test
    public void checkCreateDataFile() {

    }

    private Configuration createTestConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setPrimaryDataFile("translation-db.json");
        configuration.setMutations(Arrays.asList("CZ","EN","DE"));
        ArrayList<PropertiesFile> files = new ArrayList<>();
        String relativeFilePath = "src/test/resources/META-INF/lib_eshop_edee/country.properties";
        PropertiesFile propFile = new PropertiesFile(relativeFilePath);
        propFile.addExcludedProperty("MWI");
        propFile.addExcludedProperty("ind");
        files.add(propFile);
        propFile = new PropertiesFile("items.properties");
        propFile.addExcludedProperty("NO");
        propFile.addExcludedProperty("NC");
        files.add(propFile);
        configuration.setPropertiesFiles(files);
        return configuration;
    }

}