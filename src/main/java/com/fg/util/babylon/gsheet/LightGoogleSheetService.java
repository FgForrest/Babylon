package com.fg.util.babylon.gsheet;

import com.fg.util.babylon.legacy.GoogleSheetApi;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import lombok.extern.apachecommons.CommonsLog;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

//FIXME: abstract out interface
@CommonsLog
public class LightGoogleSheetService {

    private final GoogleSheetApiRequestFactory gSheetsRequestFactory;
    private final GoogleSheetApi googleSheetApi;

    //FIXME: this should not be here
    private BatchUpdateSpreadsheetRequest currentRequest;

    private static final Integer COLUMN_WIDTH = 350;

    public LightGoogleSheetService(GoogleSheetApiRequestFactory googleSheetApiRequestFactory, GoogleSheetApi googleSheetApi) {
        this.gSheetsRequestFactory = googleSheetApiRequestFactory;
        this.googleSheetApi = googleSheetApi;
    }

    /**
     * Loads sheet from given spreadsheet, if exists.
     *
     * @param spreadsheetId id of spreadsheet to find in
     * @param sheetTitle title of sheet to find
     *
     * @return sheet {@code sheetTitle} from spreadsheet {@spreadsheetId}, or null if not found
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public Sheet loadSheet(String spreadsheetId, String sheetTitle) throws GeneralSecurityException, IOException {
        Spreadsheet spreadsheet = getSheetsService().spreadsheets().get(spreadsheetId).execute();
        return spreadsheet.getSheets()
                .stream()
                .filter(sheet -> sheet.getProperties().getTitle().equals(sheetTitle))
                .findFirst().orElse(null);
    }

    public void uploadDataToGoogleSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows) throws GeneralSecurityException, IOException {
        Integer rows = sheetRows.size();
        Integer cols = sheetRows.size() > 0
                ? sheetRows.get(0).size()
                : 0;
        // FIXME: do not create sheet at all in case of 0 rows, 0 cols?

        Request addSheet = gSheetsRequestFactory.addSheet(sheetTitle, rows, cols, 1, 2);
        executeRequests(spreadsheetId, addSheet);

        writeDataToGoogleSheet(spreadsheetId, sheetTitle, sheetRows);
    }

    private void writeDataToGoogleSheet(String spreadsheetId, String range, List<? extends List<? extends Object>> values) throws GeneralSecurityException, IOException {
        // casting to List<List<Object>> is safe here, the Sheets API could have accepted List<? extends List<? extends Object>> in setValues()
        List<List<Object>> castValues = (List)values;
        ValueRange valueRange = new ValueRange()
                .setValues(castValues)
                .setRange(range);
        BatchUpdateValuesRequest update = new BatchUpdateValuesRequest()
                .setValueInputOption("RAW")
                .setData(Arrays.asList(valueRange));

        BatchUpdateValuesResponse result = executeRequest(spreadsheetId, update);
        log.info(String.format("%d cells written.", result.getTotalUpdatedCells()));
    }

    public void updateSheetStyle(String spreadsheetId, Integer sheetId, List<String> lockedCellEditors) throws GeneralSecurityException, IOException {
        Request setWrappingStrategy = gSheetsRequestFactory.setWrapWrappingStrategyForAllCells(sheetId);
        Request resizeColumns = gSheetsRequestFactory.resizeAllColumns(sheetId, COLUMN_WIDTH);
        Request protectColumns = gSheetsRequestFactory.protectCellsInFirstTwoColumns(sheetId, lockedCellEditors);
        Request hideColumn = gSheetsRequestFactory.hideFirstColumn(sheetId);

        executeRequests(spreadsheetId, setWrappingStrategy, resizeColumns, protectColumns, hideColumn);
    }

    private BatchUpdateValuesResponse executeRequest(String spreadsheetId, BatchUpdateValuesRequest request) throws GeneralSecurityException, IOException {
        SpreadsheetValuesUpdateRQE requestQueueExecutor = new SpreadsheetValuesUpdateRQE(googleSheetApi, spreadsheetId, request);
        return requestQueueExecutor.executeRequest();
    }

    private BatchUpdateSpreadsheetResponse executeRequests(String spreadsheetId, Request... requests) throws GeneralSecurityException, IOException {
        BatchUpdateSpreadsheetRequest req = new BatchUpdateSpreadsheetRequest()
                .setRequests(Arrays.asList(requests))
                .setIncludeSpreadsheetInResponse(false);

        SpreadsheetUpdateRQE requestQueueExecutor = new SpreadsheetUpdateRQE(googleSheetApi, spreadsheetId, req);
        return requestQueueExecutor.executeRequest();
    }


    private Sheets getSheetsService() throws GeneralSecurityException, IOException {
        return googleSheetApi.getSheetService();
    }

}
