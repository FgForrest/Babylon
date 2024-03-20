package one.edee.babylon.util;

import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.snapshot.Snapshot;
import one.edee.babylon.entity.MessageFileContent;
import one.edee.babylon.entity.PropertiesMap;
import one.edee.babylon.enums.PropertyStatus;

import java.io.File;
import java.util.Arrays;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class TestUtils {

    private TestUtils() {
    }

    public static String getTempDir() {
        String dir = System.getProperty("java.io.tmpdir");
        if (!dir.endsWith(File.separator)) {
            dir += File.separator;
        }
        return dir;
    }

    public static Snapshot createTestDataFile() {
        Snapshot snapshot = new Snapshot();
        MessageFileContent propFile = new MessageFileContent();
        propFile.putProperty("key", "value", PropertyStatus.NEW);
        propFile.putProperty("key2", "value2");
        PropertiesMap mutationProperties = new PropertiesMap();
        mutationProperties.put("key2", "dfdsg");
        propFile.putMutationProperties("en", mutationProperties);
        snapshot.putPropFile("my.properties", propFile);
        propFile = new MessageFileContent();
        propFile.putProperty("key3", "value3");
        propFile.putProperty("key4", "value4");
        snapshot.putPropFile("my2.properties", propFile);
        return snapshot;
    }

    public static TranslationConfiguration createTestConfiguration() {
        TranslationConfiguration configuration = new TranslationConfiguration("translation-db.json", "cz");
        configuration.addFileToPath("src\\test\\resources\\META-INF\\lib_eshop_edee\\country.properties");
        configuration.addFileToPath("src\\test\\resources\\META-INF\\09_mail_form\\messages.properties");
        configuration.addFileToPath("src\\test\\resources\\META-INF\\goPayGate\\*.properties");
        configuration.setMutations(Arrays.asList("en", "de"));
        return configuration;
    }

}
