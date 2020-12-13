package com.fg.util.babylon.sheets.gsheets.legacy;

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
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.lang.NonNull;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.*;

import static java.util.Collections.singletonList;

/**
 * Service to work with google spreadsheets.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class GoogleSheetApi {

    private static final String APPLICATION_NAME = "Google Sheets API for Babylon";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = singletonList(SheetsScopes.SPREADSHEETS);
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final String GOOGLE_CREDENTIALS_JSON = "credentials.json";

    /** Use only by cached and null safe access by {@link #getCredentials(NetHttpTransport)} method. */
    private Credential credential;
    /** Use only by cached and null safe access by {@link #getSheetService()} method */
    private Sheets sheetService;

    /**
     * Get cached or build a new authorized API client service.
     * @return {@link Sheets} service for access to google sheets.
     * @throws GeneralSecurityException when access to google sheet failed due to security reasons.
     * @throws IOException some exception derived from {@link IOException}
    */
    @NonNull
    public Sheets getSheetService() throws GeneralSecurityException, IOException {
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
            InputStream credentialsStream = null;
            InputStreamReader credentialsReader = null;
            try {
                if (credentialsFile.exists()) {
                    credentialsStream = new FileInputStream(credentialsFile);
                } else {
                    // If not exists then fallback into default credentials.json for FG Forest company in resources.
                    credentialsStream = getClass().getClassLoader().getResourceAsStream(GOOGLE_CREDENTIALS_JSON);
                }
                assert credentialsStream != null;
                credentialsReader = new InputStreamReader(credentialsStream);
                GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, credentialsReader);
                // Build flow and trigger user authorization request.
                GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                        httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                        .setAccessType("offline")
                        .build();
                LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
                credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
            } finally {
                if (credentialsStream != null) {
                    credentialsStream.close();
                }
                if (credentialsReader != null) {
                    credentialsReader.close();
                }
            }
        }
        return credential;
    }
}
