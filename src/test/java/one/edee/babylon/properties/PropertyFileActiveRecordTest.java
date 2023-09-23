package one.edee.babylon.properties;

import one.edee.babylon.export.TsMessageLoader;
import one.edee.babylon.util.TestUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class PropertyFileActiveRecordTest {

    /**
     * Tests if properties file is read and store to another file with same content and formatting.
     */
    @Test
    public void checkLoadAndSavePropertiesFile() throws IOException {
        long stTime = System.currentTimeMillis();
        PropertyFileActiveRecord propertyFileActiveRecord = new PropertyFileActiveRecord();
        String primary = "META-INF/09_mail_form/messages.properties";
        File sourceFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(primary)).getFile());
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(sourceFile.toPath()), StandardCharsets.UTF_8);
        propertyFileActiveRecord.load(inputStreamReader);
        propertyFileActiveRecord.entrySet().forEach(log::info);
        log.info("Load time: " + (System.currentTimeMillis() - stTime) + " ms");
        stTime = System.currentTimeMillis();
        String path = TestUtils.getTempDir() + "messages-out.properties";
        File targetFile = new File(path);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(targetFile.toPath()), StandardCharsets.UTF_8);
        propertyFileActiveRecord.save(outputStreamWriter, primary);
        log.info("Save time: " + (System.currentTimeMillis() - stTime) + " ms");
        assertTrue("Source and target file is different", FileUtils.contentEquals(sourceFile, targetFile));

    }
    @Test
    public void checkLoadAndSaveTsFile() throws IOException {
        testTs("META-INF/09_mail_form/messages.ts", "messages-out.ts");
    }

    @Test
    public void checkLoadAndSaveTsFileWithArgs() throws IOException {
        testTs("META-INF/addresses/addresses.ts", "addresses-out.ts");
    }


    private void testTs(String primary, String output) throws IOException {
        long stTime = System.currentTimeMillis();
        FileActiveRecord propertyFileActiveRecord = new TsFileActiveRecord();
        File sourceFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(primary)).getFile());
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(sourceFile.toPath()), StandardCharsets.UTF_8);
        propertyFileActiveRecord.load(inputStreamReader);
        propertyFileActiveRecord.entrySet().forEach(log::info);
        log.info("Load time: " + (System.currentTimeMillis() - stTime) + " ms");
        stTime = System.currentTimeMillis();
        String path = TestUtils.getTempDir() + output;
        File targetFile = new File(path);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(targetFile.toPath()), StandardCharsets.UTF_8);
        String absolutePath = sourceFile.getAbsolutePath();
        propertyFileActiveRecord.save(outputStreamWriter, absolutePath);
        log.info("Save time: " + (System.currentTimeMillis() - stTime) + " ms");

        Assert.assertEquals(Objects.requireNonNull(TsMessageLoader.loadFile(absolutePath)).getPropertyDefinitions(), Objects.requireNonNull(TsMessageLoader.loadFile(path)).getPropertyDefinitions());
    }
}
