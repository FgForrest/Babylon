package one.edee.babylon.service;

import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.util.JsonUtils;
import one.edee.babylon.util.TestUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class TranslationConfigurationSerializationTest {

    /**
     * Checks of {@link TranslationConfiguration} serialization from object to string and back.
     * @throws IOException some exception derived from {@link IOException}
    */
    @Test
    public void checkConfigSerializationAndDeserialization() throws IOException {
        TranslationConfiguration configuration = TestUtils.createTestConfiguration();
        String jsonString = JsonUtils.objToJsonString(configuration, true);
        assertFalse("Json String is null or empty", StringUtils.isEmpty(jsonString));
        log.info(jsonString);
        TranslationConfiguration configFromStr = JsonUtils.jsonObjFromString(jsonString, TranslationConfiguration.class);
        assertNotNull("Json object from string is null", configFromStr);
    }

}