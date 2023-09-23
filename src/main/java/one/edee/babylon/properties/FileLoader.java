package one.edee.babylon.properties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Loads {@link FileLoader} from a file.
 */
public abstract class FileLoader {

    /**
     * Loads properties from file.
     *
     * @param fileNamePath path to existing properties file
     * @return Returns properties {@link FileActiveRecord} or null if file not exists.
     */
    public FileActiveRecord loadPropertiesFromFile(String fileNamePath) {
        if (!new File(fileNamePath).exists()) {
            return createFileActiveRecord();
        }
        try (InputStream propertyFile = Files.newInputStream(Paths.get(fileNamePath))) {
            return loadProperties(propertyFile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not close file " + fileNamePath, e);
        }
    }

    /**
     * Loads properties from input stream.
     *
     * @param propertyFile input stream with properties content
     * @return Returns loaded file {@link FileActiveRecord}
     * @throws IOException error when reading the stream
     */
    public FileActiveRecord loadProperties(InputStream propertyFile) throws IOException {
        FileActiveRecord propertyFileActiveRecord = createFileActiveRecord();
        try (InputStreamReader inputStreamReader = new InputStreamReader(propertyFile, StandardCharsets.UTF_8)) {
            propertyFileActiveRecord.load(inputStreamReader);
        }
        return propertyFileActiveRecord;
    }

    /**
     * Indicates whether file could be loaded by implementation.
     */
    public abstract boolean canBeLoaded(String filePath);

    public abstract FileActiveRecord createFileActiveRecord();
}
