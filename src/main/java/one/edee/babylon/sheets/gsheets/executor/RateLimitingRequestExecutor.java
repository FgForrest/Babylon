package one.edee.babylon.sheets.gsheets.executor;

import one.edee.babylon.sheets.gsheets.GSheetsClient;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.json.GenericJson;
import com.google.api.services.sheets.v4.Sheets;
import lombok.extern.apachecommons.CommonsLog;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;

/**
 * Executes Google Sheets API batch requests using exponential backoff in response to API rate limiting.
 * Create a new instance for every batch of requests to be executed.
 *
 * @param <T> API request type
 * @param <U> API response type
 */
@CommonsLog
public abstract class RateLimitingRequestExecutor<T extends GenericJson, U extends GenericJson> {

    private static final int HTTP_TOO_MANY_REQUESTS = 429;
    static final int MAX_BACKOFF_TIME_SEC = 64;
    static final int MAX_RETRIES = 50;

    protected final GSheetsClient gsClient;
    protected final String spreadsheetId;

    @Nullable
    private T request;

    public RateLimitingRequestExecutor(GSheetsClient gsClient,
                                       String spreadsheetId,
                                       T request) {
        this.gsClient = gsClient;
        this.request = request;
        this.spreadsheetId = spreadsheetId;
    }

    /**
     * Send the batch request, waiting for 1..2..4..8..{@link #MAX_BACKOFF_TIME_SEC} seconds,
     * retrying up to {@link #MAX_RETRIES} times.
     *
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
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

    /**
     * Executes the request. This should be implemented using the knowledge of request type in a subclass.
     *
     * @param request request to execute
     * @return response from API
     */
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

    protected Sheets getSheetsClient() throws GeneralSecurityException, IOException {
        return gsClient.getSheetService();
    }

}
