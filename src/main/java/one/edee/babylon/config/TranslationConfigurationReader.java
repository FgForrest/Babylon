package one.edee.babylon.config;

import one.edee.babylon.util.JsonUtils;
import lombok.extern.apachecommons.CommonsLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;


/**
 * Reads translation configuration file and performs basic validation on it.
 */
@CommonsLog
public class TranslationConfigurationReader {

    public TranslationConfiguration readAndCheckConfiguration(String configFileName) throws IOException {
        Objects.requireNonNull(configFileName, "Config file name must not be null");
        File file = new File(configFileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Cannot find configuration file: " + file.getAbsolutePath());
        }
        TranslationConfiguration configuration = readConfiguration(file);
        if (configuration.getMutations().isEmpty()) {
            throw new IllegalArgumentException("No primary mutations defined in configuration file \"" + configFileName + "\"");
        }

        return configuration;
    }

    private TranslationConfiguration readConfiguration(File file) throws IOException {
        return JsonUtils.jsonObjFromFile(file, TranslationConfiguration.class);
    }

}
