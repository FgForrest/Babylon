package one.edee.babylon.sheets;

public class SheetsException extends Exception  {

    public SheetsException(String message) {
        super(message);
    }

    public SheetsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SheetsException(Throwable cause) {
        super(cause);
    }

}
