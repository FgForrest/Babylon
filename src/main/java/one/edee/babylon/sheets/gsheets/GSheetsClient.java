package one.edee.babylon.sheets.gsheets;

import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Use to retrieve Google Sheets API client, {@link Sheets}.
 */
public interface GSheetsClient {

    Sheets getSheetService() throws GeneralSecurityException, IOException;

}
