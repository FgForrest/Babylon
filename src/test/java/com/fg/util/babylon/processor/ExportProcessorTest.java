package com.fg.util.babylon.processor;

import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.Configuration;
import com.fg.util.babylon.entity.DataFile;
import com.fg.util.babylon.entity.DataPropFile;
import com.fg.util.babylon.enums.PropertyStatus;
import com.fg.util.babylon.properties.FileProperties;
import com.fg.util.babylon.service.GoogleSheetService;
import com.fg.util.babylon.util.JsonUtils;
import com.fg.util.babylon.util.TestUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.easymock.EasyMock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Test of {@link ExportProcessor}
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ExportProcessor.class)
@CommonsLog
public class ExportProcessorTest extends CommonProcessorTest {

    private ExportProcessor exportProcessor;

    /**
     * Create mock of {@link ExportProcessor} class.
     * @throws Exception when mocking failed
     */
    private void mockExportProcessor() throws Exception {
        exportProcessor = PowerMock.createPartialMock(ExportProcessor.class,
                "readAndCheckConfiguration",
                "getPropertiesFilesPathsFromPath",
                "loadPropertiesFromFile",
                "saveDataFileWithoutProperties",
                "uploadDataToGoogleSpreadsheet");
        exportProcessor.changedPropertiesDuringExport = new LinkedList<>();
        Configuration cfg = new Configuration();
        cfg.setPath(Collections.singletonList(""));
        cfg.setMutations(mutations);
        cfg.setDataFileName("");
        exportProcessor.configuration = cfg;
        exportProcessor.pathResolver = new PathMatchingResourcePatternResolver();
        loadDefaultFilesPropsMap();
        PowerMock.expectPrivate(exportProcessor, "readAndCheckConfiguration").andVoid().anyTimes();
        PowerMock.expectPrivate(exportProcessor, "getPropertiesFilesPathsFromPath", EasyMock.anyString())
                .andStubReturn(testPropFilesPaths);
        PowerMock.expectPrivate(exportProcessor, "loadPropertiesFromFile", EasyMock.anyString())
                .andStubAnswer(() -> {
            Object[] arguments = EasyMock.getCurrentArguments();
            String fileName = (String) arguments[0];
            return filePropsMap.get(fileName);
        });
        PowerMock.expectPrivate(exportProcessor, "saveDataFileWithoutProperties").andVoid().anyTimes();
        PowerMock.expectPrivate(exportProcessor, "uploadDataToGoogleSpreadsheet").andVoid().anyTimes();
        PowerMock.replay(exportProcessor);
    }

    @Test
    @Ignore
    public void pathTest() throws IOException {
        GoogleSheetService gss = new GoogleSheetService();
        ExportProcessor exportProcessor = new ExportProcessor(gss);
        log.info(System.getProperty("user.dir"));
        Resource[] resources = exportProcessor.pathResolver.getResources("file:src\\test\\resources\\META-INF\\goPayGate\\*.properties");
        assertEquals("Unexpected number of results", 2, resources.length);
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

    /**
     * First export, JSON DataFile not exists on disk. All properties is marked as NEW and must be exported.
     * @throws Exception when test failed
     */
    @Test
    public void checkFirstWholeExport() throws Exception {
        DataFile dataFile = runFirstExport();
        // Checks of results in DataFile.
        assertNotNull("DataFile is null", dataFile);
        boolean allPrimaryPropsPresent = filePropsMap.entrySet().stream().allMatch(entry -> {
            String fileName = entry.getKey();
            if (fileName.matches(MUTATION_FILENAME_REGEX)) {
                // Skip mutation properties file
                return true;
            }
            DataPropFile dataPropFile = dataFile.getPropFileByFileName(entry.getKey());
            FileProperties fileProperties = entry.getValue();
            return fileProperties.keySet().stream().allMatch(key -> dataPropFile.getPropertyValue(key) != null);
        });
        assertTrue("Not all primary properties present", allPrimaryPropsPresent);
        boolean allIsNew = dataFile.getDataPropFiles().values().stream()
                .allMatch(dataPropFile -> dataPropFile.getProperties().getPropertiesStatus().values().stream()
                        .allMatch(propertyStatus -> propertyStatus == PropertyStatus.CHANGED));
        assertTrue("Not all primary properties is CHANGED. Check log of test to find problem.", allIsNew);
    }

    /**
     * Test where one property value in primary mutation file is changed.
     * @throws Exception when test failed
     */
    @Test
    public void checkWholeExportWithPrimaryPropValueChanged() throws Exception {
        // Run first export to get DataFile
        DataFile dataFile = runFirstExport();
        assertNotNull("DataFile is null", dataFile);
        // Use this datafile for second export
        exportProcessor.dataFile = dataFile;
        exportProcessor.originalDataFileOnDisk = dataFile;
        // Change value of one primary property (simulates change in primary properties file)
        String changedFileName = "A.properties";
        String changedPropKey = "A.properties0";
        String changedValue = "changed value";
        filePropsMap.get(changedFileName).get(changedPropKey).setValue(changedValue);
        // Run second export
        exportProcessor.startTranslation(new Arguments());
        dataFile = exportProcessor.getOrCreateDataFile();
        // Check if status of this one property is changed and at the same time status of all other properties must be UNCHANGED
        boolean valueIsChanged = dataFile.getPropFileByFileName(changedFileName).getPropertyValue(changedPropKey).equals(changedValue);
        assertTrue("Value is not correctly changed", valueIsChanged);
        PropertyStatus changedStatus = dataFile.getPropFileByFileName(changedFileName).getPropertyStatus(changedPropKey);
        assertEquals("Changed status not match", PropertyStatus.CHANGED, changedStatus);
        int changedCnt = 0;
        for (DataPropFile dataPropFile : dataFile.getDataPropFiles().values()) {
            Collection<PropertyStatus> propertyStatuses = dataPropFile.getProperties().getPropertiesStatus().values();
            changedCnt += propertyStatuses.stream().filter(propertyStatus -> propertyStatus == PropertyStatus.CHANGED).count();
        }
        assertEquals("Expect only one CHANGED property.", 1, changedCnt);
        int unchangedCnt = 0;
        for (DataPropFile dataPropFile : dataFile.getDataPropFiles().values()) {
            Collection<PropertyStatus> propertyStatuses = dataPropFile.getProperties().getPropertiesStatus().values();
            unchangedCnt += propertyStatuses.stream().filter(propertyStatus -> propertyStatus == PropertyStatus.UNCHANGED).count();
        }
        long allPrimaryPropsCnt = filePropsMap.entrySet().stream().filter(entry -> !entry.getKey().matches(MUTATION_FILENAME_REGEX))
                .map(stringFilePropertiesEntry -> stringFilePropertiesEntry.getValue().values()).mapToInt(Collection::size).sum();
        assertEquals("Not all other properties have status UNCHANGED.", allPrimaryPropsCnt - 1, unchangedCnt);
    }

    /**
     * Test where new secondary mutation is added. Properties files for this mutations are NOT exists. All values must be exported.
     * @throws Exception when test failed
     */
    @Test
    public void checkWholeExportWithMutationAdded() throws Exception {
        DataFile dataFile = runFirstExport();
        assertNotNull("DataFile is null", dataFile);
        // Add mutation "de" (properties files for "de" are NOT exists) re-mock ExportProcessor and run export process again
        mutations = new LinkedList<>(Arrays.asList("en", "de"));
        mockExportProcessor();
        // Use this datafile for second export
        exportProcessor.dataFile = dataFile;
        exportProcessor.originalDataFileOnDisk = dataFile;
        exportProcessor.startTranslation(new Arguments());
        dataFile = exportProcessor.getOrCreateDataFile();
        int missingCnt = 0;
        for (DataPropFile dataPropFile : dataFile.getDataPropFiles().values()) {
            Collection<PropertyStatus> propertyStatuses = dataPropFile.getProperties().getPropertiesStatus().values();
            missingCnt += propertyStatuses.stream().filter(propertyStatus -> propertyStatus == PropertyStatus.CHANGED).count();
        }
        long allPrimaryPropsCnt = filePropsMap.entrySet().stream().filter(entry -> !entry.getKey().matches(MUTATION_FILENAME_REGEX))
                .map(stringFilePropertiesEntry -> stringFilePropertiesEntry.getValue().values()).mapToInt(Collection::size).sum();
        assertEquals("Not all primary properties have status CHANGED.", allPrimaryPropsCnt, missingCnt);
    }

    /**
     * Test where new secondary mutation is added. Properties files for this mutations are exists and all have values, so no export needed.
     * @throws Exception when test failed
     */
    @Test
    public void checkWholeExportWithMutationAddedWithFiles() throws Exception {
        DataFile dataFile = runFirstExport();
        assertNotNull("DataFile is null", dataFile);
        // Add mutation "de" (properties files for "de" are exists) re-mock ExportProcessor and run export process again
        mutations = new LinkedList<>(Arrays.asList("en", "de"));
        testPropFilesPaths = new LinkedList<>(Arrays.asList("A.properties", "A_en.properties", "A_de.properties",
                "B.properties", "B_en.properties", "B_de.properties"));
        mockExportProcessor();
        // Use this datafile for second export
        exportProcessor.dataFile = dataFile;
        exportProcessor.originalDataFileOnDisk = dataFile;
        exportProcessor.startTranslation(new Arguments());
        dataFile = exportProcessor.getOrCreateDataFile();
        int missingCnt = 0;
        for (DataPropFile dataPropFile : dataFile.getDataPropFiles().values()) {
            Collection<PropertyStatus> propertyStatuses = dataPropFile.getProperties().getPropertiesStatus().values();
            missingCnt += propertyStatuses.stream().filter(propertyStatus -> propertyStatus == PropertyStatus.UNCHANGED).count();
        }
        long allPrimaryPropsCnt = filePropsMap.entrySet().stream().filter(entry -> !entry.getKey().matches(MUTATION_FILENAME_REGEX))
                .map(stringFilePropertiesEntry -> stringFilePropertiesEntry.getValue().values()).mapToInt(Collection::size).sum();
        assertEquals("Not all properties have status UNCHANGED.", allPrimaryPropsCnt, missingCnt);
    }

    /**
     * Test where one value of one secondary mutation is missing.
     * @throws Exception when test failed
     */
    @Test
    public void checkWholeExportWithOneMutationValueIsMissing() throws Exception {
        DataFile dataFile = runFirstExport();
        assertNotNull("DataFile is null", dataFile);
        // Add mutation "de" (properties files for "de" are exists) re-mock ExportProcessor and run export process again
        mutations = new LinkedList<>(Arrays.asList("en", "de"));
        testPropFilesPaths = new LinkedList<>(Arrays.asList("A.properties", "A_en.properties", "A_de.properties",
                "B.properties", "B_en.properties", "B_de.properties"));
        mockExportProcessor();
        // Use this datafile for second export
        exportProcessor.dataFile = dataFile;
        exportProcessor.originalDataFileOnDisk = dataFile;
        // Remove value of one "en" mutation property
        String changedFileName = "A_en.properties";
        String changedPropKey = "A.properties0";
        filePropsMap.get(changedFileName).remove(changedPropKey);
        exportProcessor.startTranslation(new Arguments());
        dataFile = exportProcessor.getOrCreateDataFile();
        DataPropFile propFile = dataFile.getPropFileByFileName("A.properties");
        PropertyStatus propStatus = propFile.getPropertyStatus(changedPropKey);
        String propValue = propFile.getMutationProperties("en").get(changedPropKey);
        assertEquals("Primary property status is not CHANGED", PropertyStatus.CHANGED, propStatus);
        assertTrue("Property value is not empty", propValue.isEmpty());
        // Primary property value and value of de mutation must be untouched.
        String primaryPropValue = propFile.getPropertyValue(changedPropKey);
        assertEquals("Primary property value is changed", filePropsMap.get("A.properties").get(changedPropKey).getValue(), primaryPropValue);
        String dePropValue = propFile.getMutationProperties("de").get(changedPropKey);
        assertEquals("Primary property value is changed", filePropsMap.get("A_de.properties").get(changedPropKey).getValue(), dePropValue);
    }

    private DataFile runFirstExport() throws Exception {
        mockExportProcessor();
        exportProcessor.startTranslation(new Arguments());
        return exportProcessor.getOrCreateDataFile();
    }
}
