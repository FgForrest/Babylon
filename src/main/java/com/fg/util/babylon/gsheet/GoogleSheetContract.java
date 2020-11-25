package com.fg.util.babylon.gsheet;

import com.google.api.services.sheets.v4.model.Sheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface GoogleSheetContract {

    /**
     * Lists all sheets of spreadsheet {@code spreadsheetId}. Does not fetch the data of the sheets!
     * Data of each sheet must be read individually by {@link #readDataFromSheet(String, String)} method or by
     * using method {@link #listAllSheetsWithData(String)} instead to fetch the sheet data eagerly.
     *
     * @param spreadsheetId id of spreadsheet
     * @return sheets, or null when FIXME - when?? examine gapi more
     *
     * @throws GeneralSecurityException in case of permission issues
     * @throws IOException general I/O error
     */
    public List<Sheet> listSheets(String spreadsheetId) throws GeneralSecurityException, IOException;

    //FIXME javadoc
    void deleteSheets(String spreadsheetId, Iterable<Integer> sheetIds) throws IOException, GeneralSecurityException;

}
