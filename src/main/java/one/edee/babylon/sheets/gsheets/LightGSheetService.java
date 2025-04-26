package one.edee.babylon.sheets.gsheets;

import one.edee.babylon.sheets.gsheets.executor.SpreadsheetUpdateRQE;
import one.edee.babylon.sheets.gsheets.executor.SpreadsheetValuesUpdateRQE;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import lombok.extern.apachecommons.CommonsLog;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Implements business logic by calling Google Sheets API client library in a way that optimizes number of HTTP requests sent.
 * Does not attempt to build a general abstraction over the client library.
 */
@CommonsLog
public class LightGSheetService {

    private final GSheetApiRequestFactory gSheetsRequestFactory;
    private final GSheetsClient gsClient;

    private static final Integer COLUMN_WIDTH = 350;

    public LightGSheetService(GSheetApiRequestFactory gSheetApiRequestFactory, GSheetsClient gsClient) {
        this.gSheetsRequestFactory = gSheetApiRequestFactory;
        this.gsClient = gsClient;
    }

    /**
     * Lists all sheets of a spreadsheet without loading their cell data.
     *
     * @param spreadsheetId id of spreadsheet
     * @return all sheets of spreadsheet {@code spreadSheetId}
     */
    public List<Sheet> listSheetsLazily(final String spreadsheetId) throws GeneralSecurityException, IOException {
        Sheets.Spreadsheets.Get listRequest = getSheetsClient().spreadsheets().get(spreadsheetId);
        Spreadsheet spreadSheet = listRequest.execute();
        return spreadSheet.getSheets();
    }

    /**
     * Lists all sheets of a spreadsheet also fetching their cell data.
     *
     * @param spreadsheetId id of spreadsheet
     * @return all sheets of spreadsheet {@code spreadSheetId}
     */
    public List<Sheet> listSheetsEagerly(final String spreadsheetId) throws GeneralSecurityException, IOException {
        Sheets.Spreadsheets.Get listRequest = getSheetsClient().spreadsheets().get(spreadsheetId).setIncludeGridData(true);
        Spreadsheet spreadSheet = listRequest.execute();
        return spreadSheet.getSheets();
    }

    /**
     * Loads sheet from given spreadsheet, if exists.
     *
     * @param spreadsheetId id of spreadsheet to find in
     * @param sheetTitle    title of sheet to find
     * @return sheet {@code sheetTitle} from spreadsheet {@spreadsheetId}, or null if not found
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public Sheet loadSheet(String spreadsheetId, String sheetTitle) throws GeneralSecurityException, IOException {
        Sheets.Spreadsheets.Get loadRequest = getSheetsClient().spreadsheets().get(spreadsheetId);
        Spreadsheet spreadSheet = loadRequest.execute();
        return spreadSheet.getSheets()
                .stream()
                .filter(sheet -> sheet.getProperties().getTitle().equals(sheetTitle))
                .findFirst().orElse(null);
    }


    /**
     * Stores data in a new sheet in given spreadsheet.
     *
     * @param spreadsheetId id of spreadsheet to create sheet in
     * @param sheetTitle name of the new sheet
     * @param sheetRows sheet data to store
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public void uploadDataToGoogleSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows) throws GeneralSecurityException, IOException {
        uploadDataToGoogleSheet(spreadsheetId, sheetTitle, sheetRows, 0, 0);
    }

    /**
     * Stores data in a new sheet in given spreadsheet.
     *
     * @param spreadsheetId id of spreadsheet to create sheet in
     * @param sheetTitle name of the new sheet
     * @param sheetRows sheet data to store
     * @param rowsToFreeze number of rows to freeze
     * @param colsToFreeze number of cols to freeze
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public void uploadDataToGoogleSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows, int rowsToFreeze, int colsToFreeze) throws GeneralSecurityException, IOException {
        Integer rows = sheetRows.size();
        Integer cols = sheetRows.size() > 0
                ? sheetRows.get(0).size()
                : 0;

        Request addSheet = gSheetsRequestFactory.addSheet(sheetTitle, rows, cols, rowsToFreeze, colsToFreeze);
        executeRequests(spreadsheetId, addSheet);

        writeDataToGoogleSheet(spreadsheetId, sheetTitle, sheetRows);
    }

    private void writeDataToGoogleSheet(String spreadsheetId, String range, List<? extends List<? extends Object>> values) throws GeneralSecurityException, IOException {
        // casting to List<List<Object>> is safe here, the Sheets API could have accepted List<? extends List<? extends Object>> in setValues()
        // convert nulls to empty strings, GSheet API skips null values
        List<List<Object>> convertedValues = convertNullsToEmptyString((List) values);

        ValueRange valueRange = new ValueRange()
                .setValues(convertedValues)
                .setRange(range);
        BatchUpdateValuesRequest update = new BatchUpdateValuesRequest()
                .setValueInputOption("RAW")
                .setData(Collections.singletonList(valueRange));

        BatchUpdateValuesResponse result = executeRequest(spreadsheetId, update);
        log.info(String.format("%d cells written.", result.getTotalUpdatedCells()));
    }

    private List<? extends List<? extends Object>> convertNullsToEmptyString(List<? extends List<? extends Object>> values) {
        return values.stream().map(row ->
                row.stream().map(cell -> (cell == null) ? "" : cell).collect(Collectors.toList())
        ).collect(Collectors.toList());
    }

    /**
     * Updates the style and configuration of a specified sheet in a Google Spreadsheet.
     * This includes wrapping text in all cells, resizing columns, protecting cells,
     * hiding specific columns, and applying color changes to specified cells.
     *
     * @param spreadsheetId          the ID of the Google Spreadsheet
     * @param sheetId                the ID of the sheet within the spreadsheet to update
     * @param lockedCellEditors      a list of email addresses permitted to edit protected cells in the first two columns
     * @param translatedAutomatically a list of cell identifiers (formatted as "row_column") to apply a specific background color, indicating automatic translation
     * @param translatedHistorically  a list of cell identifiers (formatted as "row_column") to apply a different background color, indicating manual translation from historical data
     *
     * @throws GeneralSecurityException if there is an authentication or API access issue
     * @throws IOException              if an issue occurs during communication with the Google Sheets API
     */
    public void updateSheetStyle(String spreadsheetId, Integer sheetId, List<String> lockedCellEditors, List<String> translatedAutomatically, List<String> translatedHistorically) throws GeneralSecurityException, IOException {
        List<Request> requests = new LinkedList<>();
        requests.add(gSheetsRequestFactory.setWrapWrappingStrategyForAllCells(sheetId));
        requests.add(gSheetsRequestFactory.resizeAllColumns(sheetId, COLUMN_WIDTH));
        if (!lockedCellEditors.isEmpty())
            requests.add(gSheetsRequestFactory.protectCellsInFirstTwoColumns(sheetId, lockedCellEditors));
        requests.add(gSheetsRequestFactory.hideFirstColumn(sheetId));
        requests.addAll(gSheetsRequestFactory.changeCellColor(sheetId, translatedAutomatically, new Color().setRed(1f).setGreen(0.8f).setBlue(0.61f)));

        requests.addAll(gSheetsRequestFactory.changeCellColor(sheetId, translatedHistorically, new Color().setRed(0.64f).setGreen(0.77f).setBlue(0.96f)));
        executeRequests(spreadsheetId, requests.toArray(new Request[0]));
    }

    public void deleteSheets(String spreadsheetId, Collection<Integer> sheetIds) throws GeneralSecurityException, IOException {
        Request[] deleteSheetRequests = sheetIds.stream()
                .map(gSheetsRequestFactory::deleteSheet)
                .toArray(Request[]::new);

        executeRequests(spreadsheetId, deleteSheetRequests);
    }

    private BatchUpdateValuesResponse executeRequest(String spreadsheetId, BatchUpdateValuesRequest request) throws GeneralSecurityException, IOException {
        SpreadsheetValuesUpdateRQE requestQueueExecutor = new SpreadsheetValuesUpdateRQE(gsClient, spreadsheetId, request);
        return requestQueueExecutor.executeRequest();
    }

    private BatchUpdateSpreadsheetResponse executeRequests(String spreadsheetId, Request... requests) throws GeneralSecurityException, IOException {
        BatchUpdateSpreadsheetRequest req = new BatchUpdateSpreadsheetRequest()
                .setRequests(Arrays.asList(requests))
                .setIncludeSpreadsheetInResponse(false);

        SpreadsheetUpdateRQE requestQueueExecutor = new SpreadsheetUpdateRQE(gsClient, spreadsheetId, req);
        return requestQueueExecutor.executeRequest();
    }

    private Sheets getSheetsClient() throws GeneralSecurityException, IOException {
        return gsClient.getSheetService();
    }

}
