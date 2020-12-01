package com.fg.util.babylon.gsheets.executor;

import com.fg.util.babylon.gsheets.GSheetsClient;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SpreadsheetUpdateRQE extends RateLimitingRequestExecutor<BatchUpdateSpreadsheetRequest, BatchUpdateSpreadsheetResponse> {

    public SpreadsheetUpdateRQE(GSheetsClient gsClient, String spreadsheetId, BatchUpdateSpreadsheetRequest request) {
        super(gsClient, spreadsheetId, request);
    }

    @Override
    BatchUpdateSpreadsheetResponse executeRequest(BatchUpdateSpreadsheetRequest request) throws GeneralSecurityException, IOException {
        return getSheetsClient().spreadsheets().batchUpdate(spreadsheetId, request).execute();
    }

}
