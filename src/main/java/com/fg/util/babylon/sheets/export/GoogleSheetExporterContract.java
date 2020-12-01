package com.fg.util.babylon.sheets.export;

import com.fg.util.babylon.sheets.gsheets.model.ASheet;
import com.fg.util.babylon.sheets.SheetsException;

import java.util.Collection;
import java.util.List;

public interface GoogleSheetExporterContract {

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
    List<ASheet> listSheets(String spreadsheetId) throws SheetsException;

    void deleteSheets(String spreadsheetId, Collection<Integer> sheetIds) throws SheetsException;

    void uploadDataToGoogleSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows, List<String> lockedCellEditors) throws SheetsException;

}
