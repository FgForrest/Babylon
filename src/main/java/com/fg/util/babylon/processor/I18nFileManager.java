package com.fg.util.babylon.processor;

import com.fg.util.babylon.propfiles.PropertyFileActiveRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Handles i18n property files.
 */
public class I18nFileManager {

    /**
     * Loads properties from file.
     * @param fileNamePath path to existing properties file
     * @return Returns loaded file {@link PropertyFileActiveRecord} or null if file not exists.
     * @throws IOException some exception derived from {@link IOException}
     */
    PropertyFileActiveRecord loadPropertiesFromFile(String fileNamePath) throws IOException {
        if (!new File(fileNamePath).exists()) {
            return null;
        }
        PropertyFileActiveRecord propertyFileActiveRecord = new PropertyFileActiveRecord();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileNamePath), StandardCharsets.UTF_8)) {
            propertyFileActiveRecord.load(inputStreamReader);
        }
        return propertyFileActiveRecord;
    }

}
