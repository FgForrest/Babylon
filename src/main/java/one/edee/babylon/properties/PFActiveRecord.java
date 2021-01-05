package one.edee.babylon.properties;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public interface PFActiveRecord extends Map<String, IProperty> {

    /**
     * Saves properties into file by specified writer.
     * @param writer Some {@link Writer} implementation.
     * @throws IOException some exception derived from {@link IOException}
     */
    void save(Writer writer) throws IOException;

}
