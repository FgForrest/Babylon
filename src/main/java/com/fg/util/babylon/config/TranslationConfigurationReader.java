package com.fg.util.babylon.config;

import com.fg.util.babylon.util.JsonUtils;
import lombok.extern.apachecommons.CommonsLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Reads translation configuration file and performs basic validation on it.
 */
@CommonsLog
public class TranslationConfigurationReader {

    public TranslationConfiguration readAndCheckConfiguration(String configFileName) throws IOException {
        File file = new File(configFileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Cannot find configuration file: " + file.getAbsolutePath());
        }
        TranslationConfiguration configuration = JsonUtils.jsonObjFromFile(file, TranslationConfiguration.class);
        if (configuration.getMutations().isEmpty()) {
            throw new IllegalArgumentException("No primary mutations defined in configuration file \"" + configFileName + "\"");
        }

        return configuration;
    }



}
