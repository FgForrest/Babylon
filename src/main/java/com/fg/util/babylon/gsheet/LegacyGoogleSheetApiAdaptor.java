package com.fg.util.babylon.gsheet;

import com.fg.util.babylon.service.GoogleSheetApi;
import com.google.api.services.sheets.v4.model.Sheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class LegacyGoogleSheetApiAdaptor implements GoogleSheetContract {

    private final GoogleSheetApi googleSheetApi;

    public LegacyGoogleSheetApiAdaptor(GoogleSheetApi googleSheetApi) {
        this.googleSheetApi = googleSheetApi;
    }

    @Override
    public List<Sheet> listSheets(String spreadsheetId) throws GeneralSecurityException, IOException {
        return googleSheetApi.getAllSheets(spreadsheetId);
    }

    @Override
    public void deleteSheets(String spreadsheetId, Iterable<Integer> sheetIds) throws IOException, GeneralSecurityException {
        googleSheetApi.deleteSheets(spreadsheetId, sheetIds);
    }

}
