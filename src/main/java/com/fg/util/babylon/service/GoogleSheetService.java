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
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Service
@CommonsLog
public class GoogleSheetService {

    private static final String APPLICATION_NAME = "Google Sheets API for Babylon";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private String googleCredentialsJson = "credentials.json";
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
     * @throws IOException
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
     * @throws IOException
     */
    public Sheet getSheet(final String spreadsheetId, final String sheetTitle) throws GeneralSecurityException, IOException {
        Spreadsheet spreadsheet = getSheetService().spreadsheets().get(spreadsheetId).execute();
        List<Sheet> sheets = spreadsheet.getSheets();
        return sheets.stream()
                .filter(sheet -> sheet.getProperties().getTitle().equals(sheetTitle))
                .findFirst().orElse(null);
    }

    /**
     * Clears all data (not formatting) in target sheet (by range) of spreadsheet specified by spreadsheetId!
     * @param spreadsheetId spreadsheet ID
     * @param range The A1 notation of the values to clear. You can also target to whole sheet by using its unique sheet title e.g. "Sheet 1".
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
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
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public void setSheetRowAndColCount(final String spreadsheetId, final SheetParams sheetParams) throws IOException, GeneralSecurityException {
        SheetProperties sheetProperties = createSheetProperties(sheetParams);
        List<Request> requests = new ArrayList<>();
        UpdateSheetPropertiesRequest request = new UpdateSheetPropertiesRequest();
        request.setProperties(sheetProperties);
        requests.add(new Request().setUpdateSheetProperties(request));
        executeSpreadsheetBatchUpdate(spreadsheetId, requests);
    }

    /**
     * Writes data into specified range of spreadsheet.
     * @param spreadsheetId spreadsheet ID
     * @param range The A1 notation of the values to update. You can also target to whole sheet by using its unique sheet title e.g. "Sheet 1".
     * @param values Values to write.
     * @throws IOException
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
     * @throws IOException
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

    private SheetProperties createSheetProperties(SheetParams sheetParams) {
        GridProperties gridProperties = new GridProperties()
                .setRowCount(sheetParams.getRowCount())
                .setColumnCount(sheetParams.getColumnCount())
                .setFrozenRowCount(sheetParams.getFrozenRowCount());
        SheetProperties sheetProperties = new SheetProperties()
                .setTitle(sheetParams.getSheetTitle())
                .setGridProperties(gridProperties);
        return sheetProperties;
    }

    private BatchUpdateSpreadsheetResponse executeSpreadsheetBatchUpdate(String spreadsheetId, List<Request> requests) throws IOException, GeneralSecurityException {
        BatchUpdateSpreadsheetRequest req = new BatchUpdateSpreadsheetRequest()
                .setRequests(requests)
                .setIncludeSpreadsheetInResponse(false);
        return getSheetService().spreadsheets().batchUpdate(spreadsheetId, req).execute();
    }

    /**
     * Set credentials json file name and path if different from default "credentials.json".
     * @param googleCredentialsJson
     */
    public void setGoogleCredentialsJson(String googleCredentialsJson) {
        if (this.googleCredentialsJson.equals(googleCredentialsJson)) {
            return;
        }
        this.googleCredentialsJson = googleCredentialsJson;
        // Invalidate existing loaded credential and sheetService.
        this.credential = null;
        this.sheetService = null;
    }

    /**
     * Get cached or build a new authorized API client service.
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
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
            // Load client secrets.
            InputStream in = new FileInputStream(googleCredentialsJson);
            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + googleCredentialsJson);
            }
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
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

    /**
     *
     * @param spreadsheetId Spreadsheet ID.
     * @param range You can also specify sheet name like e.g. "List1!A1:D3", if sheet name is missing,
     *              then range will be read from first sheet.
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public List<List<Object>> testReadExample(final String spreadsheetId, final String range) throws GeneralSecurityException, IOException {
        Sheets service = getSheetService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            log.info("No data found.");
        } else {
            for (List row : values) {
                log.info(row.stream().map(col -> col.toString()).collect(Collectors.joining(";")));
            }
        }
        return values;
    }
}
