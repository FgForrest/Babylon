package com.fg.util.babylon.processor;

import com.fg.util.babylon.propfiles.FileProperties;

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
     * @return Returns loaded file {@link FileProperties} or null if file not exists.
     * @throws IOException some exception derived from {@link IOException}
     */
    FileProperties loadPropertiesFromFile(String fileNamePath) throws IOException {
        if (!new File(fileNamePath).exists()) {
            return null;
        }
        FileProperties fileProperties = new FileProperties();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileNamePath), StandardCharsets.UTF_8)) {
            fileProperties.load(inputStreamReader);
        }
        return fileProperties;
    }

}