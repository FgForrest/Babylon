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
public class GoogleSheetServiceTest {

    private static final String GOOGLE_SHEET_ID = "1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc";
    private static final String SHEET_NAME = "New test sheet";

    @Autowired
    protected GoogleSheetService googleSheetService;

    @Test
    public void checkGoogleSheet() throws GeneralSecurityException, IOException {
        googleSheetService.testReadExample(GOOGLE_SHEET_ID, "A1:D8");
    }

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
    public void checkClearSheet() throws GeneralSecurityException, IOException {
        googleSheetService.clearSheetData(GOOGLE_SHEET_ID, SHEET_NAME);
    }

    @Test
    @Ignore
    public void checkSetSheetRowAndColCount() throws IOException, GeneralSecurityException {
        SheetParams sheetParams = new SheetParams(SHEET_NAME, 10, 10);
        googleSheetService.setSheetRowAndColCount(GOOGLE_SHEET_ID, sheetParams);
    }

    @Test
    public void chekWriteData() throws IOException, GeneralSecurityException {
        List<List<Object>> values = Arrays.asList(
                // TODO: Put header into sheet
                Arrays.asList("headA1", "headA2", "headA3", "headA4", "headA5", "headA6"),
                // TODO: Put properties into sheet
                Arrays.asList("valB1", "headB2", "headB3"),
                Arrays.asList("valC1", "headC2", "headC3")
        );
        googleSheetService.writeDataIntoSheet(GOOGLE_SHEET_ID, SHEET_NAME, values);
    }
}