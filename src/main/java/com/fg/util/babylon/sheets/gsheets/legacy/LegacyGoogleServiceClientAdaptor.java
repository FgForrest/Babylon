package com.fg.util.babylon.sheets.gsheets.legacy;

import com.fg.util.babylon.sheets.gsheets.GSheetsClient;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Uses deprecated {@link GoogleSheetService} to implement {@link GSheetsClient} client interface.
 */
public class LegacyGoogleServiceClientAdaptor implements GSheetsClient {

    private final GoogleSheetService legacyApi;

    public LegacyGoogleServiceClientAdaptor(GoogleSheetService legacyApi) {
        this.legacyApi = legacyApi;
    }

    @Override
    public Sheets getSheetService() throws GeneralSecurityException, IOException {
        return legacyApi.getSheetService();
    }

}
