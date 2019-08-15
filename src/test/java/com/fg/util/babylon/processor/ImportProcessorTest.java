package com.fg.util.babylon.processor;

import com.fg.util.babylon.entity.*;
import com.fg.util.babylon.enums.PropertyType;
import com.fg.util.babylon.properties.FileProperties;
import com.fg.util.babylon.properties.Property;
import com.fg.util.babylon.service.GoogleSheetService;
import com.fg.util.babylon.statistics.ImportFileStatistic;
import com.fg.util.babylon.util.JsonUtils;
import com.google.api.services.sheets.v4.model.*;
import lombok.extern.apachecommons.CommonsLog;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Test of {@link ImportProcessor}
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ImportProcessor.class, GoogleSheetService.class})
@CommonsLog
public class ImportProcessorTest extends CommonProcessorTest {

    private ImportProcessor importProcessor;
    private List<Sheet> testSheets = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        mockImportProcessor();
    }

    private void mockImportProcessor() throws Exception {
        importProcessor = PowerMock.createPartialMock(ImportProcessor.class,
                "readAndCheckConfiguration",
                "loadPropertiesFromFile",
                "saveDataFile",
                "savePropertiesToFile");
        Configuration cfg = new Configuration();
        cfg.setPath(Collections.singletonList(""));
        cfg.setMutations(mutations);
        cfg.setDataFileName("");
        importProcessor.configuration = cfg;
        PowerMock.expectPrivate(importProcessor, "readAndCheckConfiguration").andVoid().anyTimes();
        PowerMock.expectPrivate(importProcessor, "loadPropertiesFromFile", EasyMock.anyString())
                .andStubAnswer(() -> {
                    Object[] arguments = EasyMock.getCurrentArguments();
                    String fileName = (String) arguments[0];
                    return filePropsMap.get(fileName);
                });
        PowerMock.expectPrivate(importProcessor, "saveDataFile").andVoid().anyTimes();
        PowerMock.expectPrivate(importProcessor, "savePropertiesToFile",
                EasyMock.anyObject(FileProperties.class), EasyMock.anyString()).andVoid().anyTimes();
        loadDefaultFilesPropsMap();
        loadTestSheets();
        importProcessor.dataFile = createTestDataFile();
        log.debug("DataFile:\n" + JsonUtils.objToJsonString(importProcessor.dataFile, true));
        importProcessor.originalDataFileOnDisk = createTestDataFile();
        GoogleSheetService googleSheetService = PowerMock.createPartialMock(GoogleSheetService.class,
                "getAllSheetsWithData");
        PowerMock.expectPrivate(googleSheetService, "getAllSheetsWithData", EasyMock.anyString())
                .andStubReturn(testSheets);
        importProcessor.googleSheetService = googleSheetService;
        PowerMock.replay(importProcessor, googleSheetService);
    }

    /**
     * First import, JSON DataFile exists on disk only with primary properties file names and theirs indexes (state after first export)
     * @throws IOException some exception derived from {@link IOException}
     * @throws GeneralSecurityException when authentication to Google sheets API problem is appeared.
     */
    @Test
    public void checkFirstWholeImport() throws IOException, GeneralSecurityException, InterruptedException {
        importProcessor.startTranslation(new Arguments());
        DataFile dataFile = importProcessor.getOrCreateDataFile();
        assertNotNull("DataFile is null", dataFile);
        dataFile.getDataPropFiles().values().forEach(dataPropFile -> {
            assertEquals("Unexpected count of primary properties", TEST_KEYS_CNT, dataPropFile.getProperties().size());
            Map<String, PropertiesMap> mutationProperties = dataPropFile.getMutationProperties();
            assertEquals("Unexpected count of mutations", mutations.size(), mutationProperties.size());
            boolean allCountsMatch = mutationProperties.values().stream().allMatch(propertiesMap -> propertiesMap.size() == TEST_KEYS_CNT);
            assertTrue("Unexpected count of mutations properties", allCountsMatch);
        });
    }

    /**
     * Test where one property is added to one secondary mutation file.
     * @throws IOException some exception derived from {@link IOException}
     * @throws GeneralSecurityException when authentication to Google sheets API problem is appeared.
     */
    @Test
    public void checkWholeImportPropertyOnlyInMutationFile() throws IOException, GeneralSecurityException, InterruptedException {
        // Add property existing only in "A_en.properties" file.
        FileProperties fileProperties = filePropsMap.get("A_en.properties");
        fileProperties.put("A.properties" + TEST_KEYS_CNT, new Property(PropertyType.VALUE, "value A_en.properties" + TEST_KEYS_CNT));
        importProcessor.startTranslation(new Arguments());
        importProcessor.getOrCreateDataFile();
        ImportFileStatistic fileStatistic = importProcessor.statistics.getFileStatistic("A_en.properties");
        assertNotNull("Statistics for file \"A_en.properties\" is null", fileStatistic);
        assertEquals("Unexpected count of properties which is not found in primary properties file",
                1, fileStatistic.getNotFoundInPrimaryFile());
    }

    private void loadTestSheets() {
        testSheets.add(createTestSheet("A#0"));
        testSheets.add(createTestSheet("B#1"));
    }

    private Sheet createTestSheet(String sheetTitle) {
        log.debug("Sheet: " + sheetTitle);
        Sheet sheet = new Sheet().setProperties(new SheetProperties().setTitle(sheetTitle));
        String fileName = sheetTitle.split("#")[0];
        LinkedList<GridData> gridDataList = new LinkedList<>();
        LinkedList<RowData> rowDataList = new LinkedList<>();
        // Add sheet header
        RowData rowData = new RowData();
        rowData.setValues(createTestHeader());
        log.debug(rowData.getValues().stream().map(CellData::getFormattedValue).collect(Collectors.joining("\t|")));
        rowDataList.add(rowData);
        // Generate and add sheet rows
        for (int row = 0 ; row < TEST_KEYS_CNT ; row++) {
            rowData = new RowData();
            rowData.setValues(createTestRow(row, fileName));
            log.debug(rowData.getValues().stream().map(CellData::getFormattedValue).collect(Collectors.joining("|")));
            rowDataList.add(rowData);
        }
        GridData gridData = new GridData().setRowData(rowDataList);
        gridDataList.add(gridData);
        sheet.setData(gridDataList);
        return sheet;
    }

    private LinkedList<CellData> createTestHeader() {
        LinkedList<CellData> cellDataList = new LinkedList<>();
        cellDataList.add(new CellData().setFormattedValue("key"));
        cellDataList.add(new CellData().setFormattedValue("primary"));
        mutations.forEach(mutation -> cellDataList.add(new CellData().setFormattedValue(mutation)));
        return cellDataList;
    }

    private LinkedList<CellData> createTestRow(int row, String fileName) {
        LinkedList<CellData> cellDataList = new LinkedList<>();
        cellDataList.add(new CellData().setFormattedValue(fileName + ".properties" + row));
        cellDataList.add(new CellData().setFormattedValue("value " + fileName + ".properties" + row));
        mutations.forEach(mutation -> cellDataList.add(new CellData().setFormattedValue(fileName + "_" + mutation + row)));
        return cellDataList;
    }

    /**
     * @return DataFile object with only primary properties filenames.
     */
    private DataFile createTestDataFile() {
        DataFile dataFile = new DataFile();
        testPropFilesPaths.forEach(fileName -> {
            if (fileName.matches(MUTATION_FILENAME_REGEX)) {
                // Skip mutation properties files
                return;
            }
            DataPropFile dataPropFile = new DataPropFile();
            dataFile.putPropFile(fileName, dataPropFile);
        });
        return dataFile;
    }
}