package com.fg.util.babylon.gsheet;

import com.fg.util.babylon.legacy.GoogleSheetApi;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.json.GenericJson;
import com.google.api.services.sheets.v4.Sheets;
import lombok.extern.apachecommons.CommonsLog;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;

@CommonsLog
public abstract class RequestQueueExecutor<T extends GenericJson, U extends GenericJson> {

    private static final int HTTP_TOO_MANY_REQUESTS = 429;
    private static final int MAX_BACKOFF_TIME_SEC = 64;
    private static final int MAX_RETRIES = 50;

    protected final GoogleSheetApi googleSheetApi;
    protected final String spreadsheetId;

    @Nullable
    private T request;

    public RequestQueueExecutor(GoogleSheetApi googleSheetApi,
                                String spreadsheetId,
                                T request) {
        this.googleSheetApi = googleSheetApi;
        this.request = request;
        this.spreadsheetId = spreadsheetId;
    }

    //FIXME: this does not for exception in catch block!!! just a proof of concept
    public U executeRequest() throws GeneralSecurityException, IOException {
        int backoffTime = 1;
        int retries = 0;
        U result = null;
        while (request != null && retries < MAX_RETRIES) {
            try {
                result = executeRequest(request);
                this.request = null;
            } catch (GoogleJsonResponseException gjre) {
                if (gjre.getStatusCode() == HTTP_TOO_MANY_REQUESTS) {
                    log.warn(gjre.getDetails());
                    sleepFor(backoffTime);
                    backoffTime *= 2;
                    backoffTime = Math.min(backoffTime, MAX_BACKOFF_TIME_SEC);
                    retries++;
                }
            }
        }
        return result;
    }

    abstract U executeRequest(T request) throws GeneralSecurityException, IOException;

    private void sleepFor(int seconds) {
        try {
            String secStr = seconds == 1 ? "second" : "seconds";
            log.info("API rate limit exceeded. Pausing for " + seconds + " " + secStr + ".");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted while sleeping before next attempt at HTTP request!");
        }
    }

    protected Sheets getSheetsService() throws GeneralSecurityException, IOException {
        return googleSheetApi.getSheetService();
    }

}
