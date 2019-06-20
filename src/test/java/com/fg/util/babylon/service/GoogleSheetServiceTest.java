package com.fg.util.babylon.service;

import com.fg.util.babylon.entity.SheetParams;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GoogleSheetService.class)
@CommonsLog
@Ignore("Only for dev testing, because it's meaningful only with real google spreadsheet and valid credentials.json to access to it.")
public class GoogleSheetServiceTest {

    private static final String GOOGLE_SHEET_ID = "1HONBwFFaXT0-MR-3TkckqhbYKaCbnYpTJ_GZBbWbAyg";
    private static final String SHEET_NAME = "List 1";

    @Autowired
    protected GoogleSheetService googleSheetService;

    @Test
    public void checkAddSheet() throws GeneralSecurityException, IOException {
        SheetParams sheetParams = new SheetParams(SHEET_NAME, 5, 1000);
        Sheet sheet = googleSheetService.addSheet(GOOGLE_SHEET_ID, sheetParams);
        if (sheet == null) {
            log.info("New sheet \"" + SHEET_NAME + "\" added");
        } else {
            log.info("Sheet \"" + SHEET_NAME + "\" already exists");
        }
    }

    @Test
    public void checkSetSheetRowAndColCount() throws IOException, GeneralSecurityException {
        SheetParams sheetParams = new SheetParams(SHEET_NAME, 10, 10);
        googleSheetService.setSheetRowAndColCount(GOOGLE_SHEET_ID, sheetParams);
    }

    @Test
    public void chekWriteData() throws IOException, GeneralSecurityException {
        List<List<Object>> values = Arrays.asList(
                // Put header into sheet
                Arrays.asList("headA1", "headA2", "headA3", "headA4", "headA5", "headA6"),
                // Put properties into sheet
                Arrays.asList("valB1", "headB2", "headB3"),
                Arrays.asList("valC1", "headC2", "headC3")
        );
        googleSheetService.writeDataIntoSheet(GOOGLE_SHEET_ID, SHEET_NAME, values);
    }

    @Test
    public void checkDeleteAllSheets() throws GeneralSecurityException, IOException {
        List<Sheet> allSheets = googleSheetService.getAllSheets(GOOGLE_SHEET_ID);
        String uniqueSheetTitle = "Sheet " + System.currentTimeMillis();
        SheetParams sheetParams = new SheetParams(uniqueSheetTitle, 5, 1000);
        googleSheetService.addSheet(GOOGLE_SHEET_ID, sheetParams);
        googleSheetService.deleteSheets(GOOGLE_SHEET_ID, allSheets);
    }
}