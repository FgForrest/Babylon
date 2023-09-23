package one.edee.babylon.properties;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedHashMap;

/**
 * My own implementation for reading/writing of properties files. Implementation take care about precise format of file.
 * Keeps information about row number for each row which represents values: key and value, empty lines or comments
 *
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public abstract class FileActiveRecord extends LinkedHashMap<String, AbstractProperty> {

    /**
     * Loads properties from file by specified reader.
     *
     * @param reader Some {@link Reader} implementation.
     * @throws IOException some exception derived from {@link IOException}
     */
    public abstract void load(Reader reader) throws IOException;

    /**
     * Saves properties into file by specified writer.
     *
     * @param writer Some {@link Writer} implementation.
     * @throws IOException some exception derived from {@link IOException}
     */
    public abstract void save(Writer writer, String primaryPropFilePath) throws IOException;

}
