package com.fg.util.babylon.propfiles;

import com.fg.util.babylon.propfiles.PropertyFileActiveRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Loads {@link PropertyFileActiveRecord} from a file.
 */
public class PropertyFileLoader {

    /**
     * Loads properties from file.
     * @param fileNamePath path to existing properties file
     * @return Returns loaded file {@link PropertyFileActiveRecord} or null if file not exists.
     * @throws IOException some exception derived from {@link IOException}
     */
    public PropertyFileActiveRecord loadPropertiesFromFile(String fileNamePath) throws IOException {
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
