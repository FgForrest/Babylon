package com.fg.util.babylon.legacy.adaptors;

import com.fg.util.babylon.gsheets.GSheetsClient;
import com.fg.util.babylon.legacy.GoogleSheetApi;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Uses deprecated {@link GoogleSheetApi} to implement {@link GSheetsClient} client interface.
 */
public class LegacyGoogleServiceClientAdaptor implements GSheetsClient {

    private final GoogleSheetApi legacyApi;

    public LegacyGoogleServiceClientAdaptor(GoogleSheetApi legacyApi) {
        this.legacyApi = legacyApi;
    }

    @Override
    public Sheets getSheetService() throws GeneralSecurityException, IOException {
        return legacyApi.getSheetService();
    }

}
