package com.fg.util.babylon.gsheet;

import com.fg.util.babylon.legacy.GoogleSheetApi;
import com.google.api.services.sheets.v4.model.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SpreadsheetValuesUpdateRQE extends RequestQueueExecutor<BatchUpdateValuesRequest, BatchUpdateValuesResponse> {

    public SpreadsheetValuesUpdateRQE(GoogleSheetApi googleSheetApi, String spreadsheetId, BatchUpdateValuesRequest request) {
        super(googleSheetApi, spreadsheetId, request);
    }

    @Override
    BatchUpdateValuesResponse executeRequest(BatchUpdateValuesRequest request) throws GeneralSecurityException, IOException {
        return getSheetsService().spreadsheets().values().batchUpdate(spreadsheetId, request).execute();
    }

}
