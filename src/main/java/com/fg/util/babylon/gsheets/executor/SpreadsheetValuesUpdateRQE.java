package com.fg.util.babylon.gsheets.executor;

import com.fg.util.babylon.gsheets.GSheetsClient;
import com.google.api.services.sheets.v4.model.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SpreadsheetValuesUpdateRQE extends RateLimitingRequestExecutor<BatchUpdateValuesRequest, BatchUpdateValuesResponse> {

    public SpreadsheetValuesUpdateRQE(GSheetsClient gsClient, String spreadsheetId, BatchUpdateValuesRequest request) {
        super(gsClient, spreadsheetId, request);
    }

    @Override
    BatchUpdateValuesResponse executeRequest(BatchUpdateValuesRequest request) throws GeneralSecurityException, IOException {
        return getSheetsClient().spreadsheets().values().batchUpdate(spreadsheetId, request).execute();
    }

}
