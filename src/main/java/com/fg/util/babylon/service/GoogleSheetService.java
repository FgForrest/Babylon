package com.fg.util.babylon.service;

import com.fg.util.babylon.entity.SheetParams;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to work with google spreadsheets.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Service
@CommonsLog
public class GoogleSheetService {

    private static final String APPLICATION_NAME = "Google Sheets API for Babylon";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final String GOOGLE_CREDENTIALS_JSON = "credentials.json";

    /** Use only by cached and null safe access by {@link #getCredentials(NetHttpTransport)} method. */
    private Credential credential;
    /** Use only by cached and null safe access by {@link #getSheetService()} method */
    private Sheets sheetService;

    /**
     * Adds new sheet to spreadsheet.
     * @param spreadsheetId spreadsheet ID
     * @param sheetParams sheet parameters
     * @return If sheet already exists then will be returned. If not then null will be returned.
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    public Sheet addSheet(final String spreadsheetId, final SheetParams sheetParams) throws GeneralSecurityException, IOException {
        Sheet sheetByTitle = getSheet(spreadsheetId, sheetParams.getSheetTitle());
        if (sheetByTitle != null) {
            return sheetByTitle;
        }
        SheetProperties sheetProperties = createSheetProperties(sheetParams);
        List<Request> requests = new ArrayList<>();
        AddSheetRequest request = new AddSheetRequest();
        request.setProperties(sheetProperties);
        requests.add(new Request().setAddSheet(request));
        executeSpreadsheetBatchUpdate(spreadsheetId, requests);
        return null;
    }

    /**
     * Gets sheet of spreadsheet by its title.
     * @param spreadsheetId spreadsheet ID
     * @param sheetTitle unique sheet title
     * @return
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    public Sheet getSheet(final String spreadsheetId, final String sheetTitle) throws GeneralSecurityException, IOException {
        Spreadsheet spreadsheet = getSheetService().spreadsheets().get(spreadsheetId).execute();
        List<Sheet> sheets = spreadsheet.getSheets();
        return sheets.stream()
                .filter(sheet -> sheet.getProperties().getTitle().equals(sheetTitle))
                .findFirst().orElse(null);
    }

    public void deleteSheets(final String spreadsheetId, List<Sheet> sheets) throws IOException, GeneralSecurityException {
        List<Request> requests = new ArrayList<>();
        sheets.forEach(sheet -> {
            DeleteSheetRequest request = new DeleteSheetRequest()
                    .setSheetId(sheet.getProperties().getSheetId());
            requests.add(new Request().setDeleteSheet(request));
        });
        executeSpreadsheetBatchUpdate(spreadsheetId, requests);
    }

    /**
     * Gets all sheets from given spreadsheet. Method gets only basic information about each sheet without their data.
     * Data of each sheet must be read individually by {@link #readDataFromSheet(String, String)} method or if you want
     * to get all sheet with their data at once, then you must use {@link #getAllSheetsWithData(String)} method instead.
     * @param spreadsheetId spreadsheet ID
     * @return
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    public List<Sheet> getAllSheets(final String spreadsheetId) throws GeneralSecurityException, IOException {
        Spreadsheet spreadsheet = getSheetService().spreadsheets().get(spreadsheetId).execute();
        return spreadsheet.getSheets();
    }

    /**
     * Gets all sheets from given spreadsheet with all their data.
     * @param spreadsheetId spreadsheet ID
     * @return
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    public List<Sheet> getAllSheetsWithData(final String spreadsheetId) throws GeneralSecurityException, IOException {
        Sheets.Spreadsheets.Get request = getSheetService().spreadsheets().get(spreadsheetId)
                .setIncludeGridData(true);
        Spreadsheet spreadsheet = request.execute();
        return spreadsheet.getSheets();
    }

    /**
     * Use with great caution! Clears all data of spreadsheet (not formatting) in target sheet (by range)!
     * @param spreadsheetId spreadsheet ID
     * @param range The A1 notation of the values to clear. You can also target to whole sheet by using its unique sheet title e.g. "Sheet 1".
     * @return
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    public ClearValuesResponse clearSheetData(final String spreadsheetId, final String range) throws GeneralSecurityException, IOException {
        ClearValuesRequest requestBody = new ClearValuesRequest();
        Sheets.Spreadsheets.Values.Clear request = getSheetService().spreadsheets().values().clear(spreadsheetId, range, requestBody);
        return request.execute();
    }

    /**
     * Update count of sheet rows and column by {@link SheetParams#getRowCount()} and {@link SheetParams#getColumnCount()} values.
     * @param spreadsheetId spreadsheet ID
     * @param sheetParams sheet parameters
     * @throws IOException some exception derived from {@link IOException}
     * @throws GeneralSecurityException
     */
    public void setSheetRowAndColCount(final String spreadsheetId, final SheetParams sheetParams) throws IOException, GeneralSecurityException {
        SheetProperties sheetProperties = createSheetProperties(sheetParams);
        List<Request> requests = new ArrayList<>();
        UpdateSheetPropertiesRequest request = new UpdateSheetPropertiesRequest()
                .setProperties(sheetProperties);
        requests.add(new Request().setUpdateSheetProperties(request));
        executeSpreadsheetBatchUpdate(spreadsheetId, requests);
    }

    /**
     * Reads data from the specified range of spreadsheet.
     * @param spreadsheetId Spreadsheet ID.
     * @param range You can also specify sheet name like e.g. "List1!A1:D3", if sheet name is missing,
     *              then range will be read from first sheet.
     * @return Data as List of {@link List&lt;List&lt;Object&gt;&gt;} or {@link Collections#emptyList()} if data not found.
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    public List<List<Object>> readDataFromSheet(final String spreadsheetId, final String range) throws GeneralSecurityException, IOException {
        Sheets service = getSheetService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            log.info("No data found.");
            values = Collections.emptyList();
        } else {
            values.stream().map(row -> row.stream().map(Object::toString).collect(Collectors.joining(";"))).forEach(log::debug);
        }
        return values;
    }

    /**
     * Writes data into specified range of spreadsheet.
     * @param spreadsheetId spreadsheet ID
     * @param range The A1 notation of the values to update. You can also target to whole sheet by using its unique sheet title e.g. "Sheet 1".
     * @param values Values to write.
     * @throws IOException some exception derived from {@link IOException}
     * @throws GeneralSecurityException
     */
    public void writeDataIntoSheet(final String spreadsheetId, final String range, final List<List<Object>> values) throws IOException, GeneralSecurityException {
        ValueRange body = new ValueRange()
                .setValues(values);
        UpdateValuesResponse result = getSheetService().spreadsheets().values().update(spreadsheetId, range, body)
                        .setValueInputOption("RAW")
                        .execute();
        log.info(String.format("%d cells updated.", result.getUpdatedCells()));
    }

    /**
     * Set auto resizing by content for given range of spreadsheet.
     * @param spreadsheetId spreadsheet ID
     * @param sheetId sheet ID
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    public void setAutoResizeColumns(final String spreadsheetId, final Integer sheetId) throws GeneralSecurityException, IOException {
        List<Request> requests = new ArrayList<>();
        DimensionRange dimensionRange = new DimensionRange()
                .setDimension("COLUMNS")
                .setSheetId(sheetId);
        AutoResizeDimensionsRequest dimensionsRequest = new AutoResizeDimensionsRequest()
                .setDimensions(dimensionRange);
        requests.add(new Request().setAutoResizeDimensions(dimensionsRequest));
        executeSpreadsheetBatchUpdate(spreadsheetId, requests);
    }

    /**
     * Hide specified range (ROWS, COLUMNS) in spreadsheet.
     * @param spreadsheetId spreadsheet ID
     * @param dimensionRange all necessary parameters for hide range
     */
    public void hideDimensionRange(final String spreadsheetId, final DimensionRange dimensionRange) throws IOException, GeneralSecurityException {
        List<Request> requests = new ArrayList<>();
        DimensionProperties dimensionProperties = new DimensionProperties()
                .setHiddenByUser(Boolean.TRUE);
        UpdateDimensionPropertiesRequest dimensionsRequest = new UpdateDimensionPropertiesRequest()
                .setRange(dimensionRange)
                .setProperties(dimensionProperties)
                .setFields("hiddenByUser");
        requests.add(new Request().setUpdateDimensionProperties(dimensionsRequest));
        executeSpreadsheetBatchUpdate(spreadsheetId, requests);
    }

    private SheetProperties createSheetProperties(SheetParams sheetParams) {
        GridProperties gridProperties = new GridProperties()
                .setRowCount(sheetParams.getRowCount())
                .setColumnCount(sheetParams.getColumnCount())
                .setFrozenRowCount(sheetParams.getFrozenRowCount());
        return new SheetProperties()
                .setTitle(sheetParams.getSheetTitle())
                .setGridProperties(gridProperties);
    }

    private BatchUpdateSpreadsheetResponse executeSpreadsheetBatchUpdate(String spreadsheetId, List<Request> requests) throws IOException, GeneralSecurityException {
        BatchUpdateSpreadsheetRequest req = new BatchUpdateSpreadsheetRequest()
                .setRequests(requests)
                .setIncludeSpreadsheetInResponse(false);
        return getSheetService().spreadsheets().batchUpdate(spreadsheetId, req).execute();
    }

    /**
     * Get cached or build a new authorized API client service.
     * @return
     * @throws GeneralSecurityException
     * @throws IOException some exception derived from {@link IOException}
    */
    @NonNull
    private Sheets getSheetService() throws GeneralSecurityException, IOException {
        if (sheetService == null) {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            sheetService = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }
        return sheetService;
    }

    /**
     * Gets cached credentials object to access Google sheet or creates new one if not exists.
     * @param httpTransport The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    @NonNull
    private Credential getCredentials(final NetHttpTransport httpTransport) throws IOException {
        if (credential == null) {
            // Load client secrets, first try to use file from current directory
            File credentialsFile = new File(GOOGLE_CREDENTIALS_JSON);
            InputStream credentialsStream;
            if (credentialsFile.exists()) {
                credentialsStream = new FileInputStream(credentialsFile);
            } else {
                // If not exists then fallback into default credentials.json for FG Forest company in resources.
                credentialsStream = getClass().getClassLoader().getResourceAsStream(GOOGLE_CREDENTIALS_JSON);
            }
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(credentialsStream));
            // Build flow and trigger user authorization request.
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                    .setAccessType("offline")
                    .build();
            LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
            credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        }
        return credential;
    }
}
