package com.fg.util.babylon.properties;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class FilePropertiesTest {

    /**
     * Tests if properties file is read and store to another file with same content and formatting.
     */
    @Test
    public void checkLoadAndSavePropertiesFile() {
        long stTime = System.currentTimeMillis();
        FileProperties fileProperties = new FileProperties();
        try {
            // Set encoding is maybe not necessary, but in case it is needed...
            File sourceFile = new File(getClass().getClassLoader().getResource("META-INF/09_mail_form/messages.properties").getFile());
            fileProperties.load(new FileReader(sourceFile));
            fileProperties.entrySet().forEach(log::info);
            log.info("Load time: " + (System.currentTimeMillis() - stTime) + " ms");
            stTime = System.currentTimeMillis();
            File targetFile = new File("messages-out.properties");
            FileWriter fileWriter = new FileWriter(targetFile);
            fileProperties.save(fileWriter);
            log.info("Save time: " + (System.currentTimeMillis() - stTime) + " ms");
            assertTrue("Source and target file is different", FileUtils.contentEquals(sourceFile, targetFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}