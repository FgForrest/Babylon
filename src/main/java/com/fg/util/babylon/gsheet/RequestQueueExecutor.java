package com.fg.util.babylon.gsheet;

import com.fg.util.babylon.legacy.GoogleSheetApi;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetResponse;
import lombok.extern.apachecommons.CommonsLog;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

@CommonsLog
public class RequestQueueExecutor {

    private static final int HTTP_TOO_MANY_REQUESTS = 429;
    private static final int MAX_BACKOFF_TIME_SEC = 64;
    private static final int MAX_RETRIES = 50;

    private final GoogleSheetApi googleSheetApi;
    private final String spreadsheetId;

    private final Queue<BatchUpdateSpreadsheetRequest> requestQueue;

    public RequestQueueExecutor(GoogleSheetApi googleSheetApi,
                                Collection<BatchUpdateSpreadsheetRequest> requests,
                                String spreadsheetId) {
        this.googleSheetApi = googleSheetApi;
        this.requestQueue = new LinkedList(requests);
        this.spreadsheetId = spreadsheetId;
    }

    //FIXME: this does not for exception in catch block!!! just a proof of concept
    public void executeRequests() throws GeneralSecurityException, IOException {
        int backoffTime = 1;
        int retries = 0;
        while (!requestQueue.isEmpty() && retries < MAX_RETRIES) {
            BatchUpdateSpreadsheetRequest currentRequest = requestQueue.peek();
            try {
                executeRequest(currentRequest);
                requestQueue.poll();
            } catch (GoogleJsonResponseException gjre) {
                if (gjre.getStatusCode() == HTTP_TOO_MANY_REQUESTS) {
                    log.warn(gjre.getDetails());
                    sleepFor(backoffTime);
                    backoffTime *= 2;
                    backoffTime = Math.min(backoffTime, MAX_BACKOFF_TIME_SEC);
                    retries += 1;
                }
            }
        }
    }

    private void executeRequest(BatchUpdateSpreadsheetRequest request) throws GeneralSecurityException, IOException {
        BatchUpdateSpreadsheetResponse result = getSheetsService().spreadsheets().batchUpdate(spreadsheetId, request).execute();
    }

    private void sleepFor(int seconds) {
        try {
            log.info("API limit exceeded. Pausing for " + seconds + " seconds.");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted while sleeping before next attempt at HTTP request!");
        }
    }

    private Sheets getSheetsService() throws GeneralSecurityException, IOException {
        return googleSheetApi.getSheetService();
    }

}
