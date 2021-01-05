package one.edee.babylon.sheets.gsheets.legacy;

import one.edee.babylon.sheets.gsheets.GSheetsClient;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Uses legacy {@link SheetsFactory} to implement {@link GSheetsClient} client interface.
 * TODO VKR do we need factory at all when we have Spring context?
 */
public class LegacyGoogleServiceClientAdaptor implements GSheetsClient {

    private final SheetsFactory legacyApi;

    public LegacyGoogleServiceClientAdaptor(SheetsFactory legacyApi) {
        this.legacyApi = legacyApi;
    }

    @Override
    public Sheets getSheetService() throws GeneralSecurityException, IOException {
        /* TODO VKR - do we need to call it legacy when we use it? we don't need to maintain backward compatibility so why legacy? */
        return legacyApi.getSheetService();
    }

}
