package com.fg.util.babylon.properties;

import com.fg.util.babylon.util.TestUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class FilePropertiesTest {

    /**
     * Tests if properties file is read and store to another file with same content and formatting.
     */
    @Test
    public void checkLoadAndSavePropertiesFile() throws IOException {
        long stTime = System.currentTimeMillis();
        FileProperties fileProperties = new FileProperties();
        File sourceFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("META-INF/09_mail_form/messages.properties")).getFile());
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8);
        fileProperties.load(inputStreamReader);
        fileProperties.entrySet().forEach(log::info);
        log.info("Load time: " + (System.currentTimeMillis() - stTime) + " ms");
        stTime = System.currentTimeMillis();
        String path = TestUtils.getTempDir() + "messages-out.properties";
        File targetFile = new File(path);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFile), StandardCharsets.UTF_8);
        fileProperties.save(outputStreamWriter);
        log.info("Save time: " + (System.currentTimeMillis() - stTime) + " ms");
        assertTrue("Source and target file is different", FileUtils.contentEquals(sourceFile, targetFile));

    }
}