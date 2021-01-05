package one.edee.babylon.sheets.gsheets.legacy;

import one.edee.babylon.sheets.gsheets.GSheetsClient;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Uses legacy {@link SheetsFactory} to implement {@link GSheetsClient} client interface.
 */
public class LegacyGoogleServiceClientAdaptor implements GSheetsClient {

    private final SheetsFactory legacyApi;

    public LegacyGoogleServiceClientAdaptor(SheetsFactory legacyApi) {
        this.legacyApi = legacyApi;
    }

    @Override
    public Sheets getSheetService() throws GeneralSecurityException, IOException {
        return legacyApi.getSheetService();
    }

}
