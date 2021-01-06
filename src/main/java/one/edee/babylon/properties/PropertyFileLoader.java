package one.edee.babylon.properties;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Loads {@link PropertyFileLoader} from a file.
 */
public class PropertyFileLoader {

    /**
     * Loads properties from file.
     *
     * @param fileNamePath path to existing properties file
     * @return Returns properties {@link PropertyFileActiveRecord} or null if file not exists.
     * @throws IOException error when reading the file
     */
    public PropertyFileActiveRecord loadPropertiesFromFile(String fileNamePath) {
        if (!new File(fileNamePath).exists()) {
            return null;
        }
        try (InputStream propertyFile = new FileInputStream(fileNamePath)) {
            return loadProperties(propertyFile);
        } catch (Exception e) {
            throw new RuntimeException("Could not close file " + fileNamePath, e);
        }
    }

    /**
     * Loads properties from input stream.
     *
     * @param propertyFile input stream with properties content
     * @return Returns loaded file {@link PropertyFileActiveRecord}
     * @throws IOException error when reading the stream
     */
    public PropertyFileActiveRecord loadProperties(InputStream propertyFile) throws IOException {
        PropertyFileActiveRecord propertyFileActiveRecord = new PropertyFileActiveRecord();
        try (InputStreamReader inputStreamReader = new InputStreamReader(propertyFile, StandardCharsets.UTF_8)) {
            propertyFileActiveRecord.load(inputStreamReader);
        }
        return propertyFileActiveRecord;
    }

}
