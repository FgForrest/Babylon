package com.fg.util.babylon.imp0rt;

import java.io.IOException;

/**
 * Exception when source spreadsheet not contains any sheets.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class NoSheetsException extends IOException {

    public NoSheetsException(String message) {
        super(message);
    }
}
