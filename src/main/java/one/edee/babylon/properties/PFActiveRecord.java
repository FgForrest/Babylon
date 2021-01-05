package one.edee.babylon.properties;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * TODO VKR get rid of interface with single implementation ... merge it with PropertyFileActiveRecord class please
 *  * or is there an expectation that someone will need to exchange this?
 */
public interface PFActiveRecord extends Map<String, IProperty> {

    /**
     * Saves properties into file by specified writer.
     * @param writer Some {@link Writer} implementation.
     * @throws IOException some exception derived from {@link IOException}
     */
    void save(Writer writer) throws IOException;

}
