package com.fg.util.babylon.imp0rt;

import com.fg.util.babylon.export.NewExporter;
import com.fg.util.babylon.sheets.SheetsException;
import com.fg.util.babylon.sheets.gsheets.model.ASheet;

import java.util.Collection;
import java.util.List;

/**
 * Defines sheet operations required by {@link ImportProcessor}.
 */
public interface ImporterSheetContract {

    /**
     * Lists all sheets of spreadsheet {@code spreadsheetId}. Also fetches cell data of the sheets.
     *
     * @param spreadsheetId id of spreadsheet
     * @return sheets from {@code spreadsheetId}
     * @throws SheetsException when unable to list sheets
     */
    List<ASheet> loadSheets(String spreadsheetId) throws SheetsException;

}
