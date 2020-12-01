package com.fg.util.babylon.gsheet;

import com.fg.util.babylon.legacy.GoogleSheetApi;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SpreadsheetUpdateRQE extends RequestQueueExecutor<BatchUpdateSpreadsheetRequest, BatchUpdateSpreadsheetResponse> {

    public SpreadsheetUpdateRQE(GoogleSheetApi googleSheetApi, String spreadsheetId, BatchUpdateSpreadsheetRequest request) {
        super(googleSheetApi, spreadsheetId, request);
    }

    @Override
    BatchUpdateSpreadsheetResponse executeRequest(BatchUpdateSpreadsheetRequest request) throws GeneralSecurityException, IOException {
        return getSheetsService().spreadsheets().batchUpdate(spreadsheetId, request).execute();
    }

}
