package com.fg.util.babylon.exception;

import java.io.IOException;

/**
 * Exception when sheet exists in spreadsheet, because we need to prevent state when somebody runs export again on same spreadsheet,
 * because it would lead to destroy work of the translator when sheet data is changed during the translation process in agency.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class SheetExistsException extends IOException {

    public SheetExistsException(String message) {
        super(message);
    }
}
