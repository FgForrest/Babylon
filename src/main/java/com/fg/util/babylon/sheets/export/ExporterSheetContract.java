package com.fg.util.babylon.sheets.export;

import com.fg.util.babylon.sheets.gsheets.model.ASheet;
import com.fg.util.babylon.sheets.SheetsException;

import java.util.Collection;
import java.util.List;

/**
 * Defines sheet operations required by {@link com.fg.util.babylon.export.NewExporter}.
 */
public interface ExporterSheetContract {

    /**
     * Lists all sheets of spreadsheet {@code spreadsheetId}. Does not fetch actual cells of the sheets.
     *
     * @param spreadsheetId id of spreadsheet
     * @return sheets from {@code spreadsheetId}
     * @throws SheetsException when unable to list sheets
     */
    List<ASheet> listSheets(String spreadsheetId) throws SheetsException;

    /**
     * Deletes specified sheets from given spreadsheet.
     *
     * @param spreadsheetId spreadsheet to delete sheets from
     * @param sheetIds ids of sheets to delete
     * @throws SheetsException when unable to delete sheets
     */
    void deleteSheets(String spreadsheetId, Collection<Integer> sheetIds) throws SheetsException;

    /**
     * Creates a new sheet a fills it with provided data.
     *
     * @param spreadsheetId id of spreadsheet where new sheet should be created
     * @param sheetTitle name to use for the new sheet
     * @param sheetRows rows with data cells to fill the sheet with
     * @param lockedCellEditors list of email accounts that will be able to edit locked cells
     * @throws SheetsException when unable to upload sheets
     */
    void createSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows, List<String> lockedCellEditors) throws SheetsException;

}
