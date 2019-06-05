package com.fg.util.babylon.processor;

import com.fg.util.babylon.entity.DataFile;
import com.fg.util.babylon.service.GoogleSheetService;
import com.fg.util.babylon.util.JsonUtils;
import com.fg.util.babylon.util.TestUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GoogleSheetService.class)
@CommonsLog
public class ExportProcessorTest {

    @Test
    public void pathTest() throws IOException {
        ExportProcessor exportProcessor = new ExportProcessor();
        log.info(System.getProperty("user.dir"));
        Resource[] resources = exportProcessor.pathResolver.getResources("file:src\\test\\resources\\META-INF\\goPayGate\\*.properties");
        assertTrue("Unexpected number of results", resources.length == 2);
    }

    /**
     * Checks of {@link DataFile} serialization from object to string and back.
     */
    @Test
    public void checkDataFileSerializationAndDeserialization() throws IOException {
        DataFile dataFile = TestUtils.createTestDataFile();
        String jsonString = JsonUtils.objToJsonString(dataFile, true);
        assertFalse("Json String is null or empty", StringUtils.isEmpty(jsonString));
        log.info(jsonString);
        DataFile dataFileFromStr = JsonUtils.jsonObjFromString(jsonString, DataFile.class);
        assertNotNull("Json object from string is null", dataFileFromStr);
    }

}