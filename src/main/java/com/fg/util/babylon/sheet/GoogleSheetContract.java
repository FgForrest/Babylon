package com.fg.util.babylon.sheet;

import com.google.api.services.sheets.v4.model.Sheet;

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
     * @throws SheetsException in case of permission issues or I/O error
     */
    List<Sheet> listSheets(String spreadsheetId) throws SheetsException;

    void deleteSheets(String spreadsheetId, Iterable<Integer> sheetIds) throws SheetsException;

    void uploadDataToGoogleSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows, List<String> lockedCellEditors) throws SheetsException;

}
