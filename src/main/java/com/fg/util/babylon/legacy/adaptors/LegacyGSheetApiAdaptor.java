package com.fg.util.babylon.legacy.adaptors;

import com.fg.util.babylon.gsheets.LightGSheetService;
import com.fg.util.babylon.legacy.GoogleSheetApi;
import com.fg.util.babylon.sheet.GoogleSheetContract;
import com.fg.util.babylon.sheet.SheetsException;
import com.google.api.services.sheets.v4.model.Sheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

// migrating from GoogleSheetApi to LightGoogleSheetService
public class LegacyGSheetApiAdaptor implements GoogleSheetContract {

    private final LightGSheetService lightGSheetService;
    private final GoogleSheetApi googleSheetApi;

    public LegacyGSheetApiAdaptor(LightGSheetService lightGSheetService,
                                  GoogleSheetApi googleSheetApi) {
        this.lightGSheetService = lightGSheetService;
        this.googleSheetApi = googleSheetApi;
    }

    @Override
    public List<Sheet> listSheets(String spreadsheetId) throws SheetsException {
        try {
            return googleSheetApi.getAllSheets(spreadsheetId);
        } catch (GeneralSecurityException | IOException e) {
            throw new SheetsException("Error when listing all sheets of spreadsheet '" + spreadsheetId + "'", e);
        }
    }

    @Override
    public void deleteSheets(String spreadsheetId, Iterable<Integer> sheetIds) throws SheetsException {
        try {
            googleSheetApi.deleteSheets(spreadsheetId, sheetIds);
        } catch (IOException | GeneralSecurityException e) {
            String errMsg = "Error when deleting sheets '" + sheetIds + "' of spreadsheet '" + spreadsheetId + "'";
            throw new SheetsException(errMsg, e);
        }
    }

    @Override
    public void uploadDataToGoogleSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows, List<String> lockedCellEditors) throws SheetsException {
        try {
            Sheet existingSheet = lightGSheetService.loadSheet(spreadsheetId, sheetTitle);
            if (existingSheet != null) {
                throw new SheetsException("Sheet '" + sheetTitle + "' already exists.");
            }
            lightGSheetService.uploadDataToGoogleSheet(spreadsheetId, sheetTitle, sheetRows);
            Sheet sheet = lightGSheetService.loadSheet(spreadsheetId, sheetTitle);
            Integer sheetId = sheet.getProperties().getSheetId();
            lightGSheetService.updateSheetStyle(spreadsheetId, sheetId, lockedCellEditors);
        } catch (IOException | GeneralSecurityException e) {
            String errMsg = "Error when creating sheet '" + sheetTitle + "' in spreadsheet '" + spreadsheetId + "'";
            throw new SheetsException(errMsg, e);
        }
    }

}
