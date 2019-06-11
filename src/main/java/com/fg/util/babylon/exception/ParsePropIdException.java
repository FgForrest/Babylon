package com.fg.util.babylon.exception;

import java.io.IOException;

/**
 * Exception when parse unique id from {@link String} containing google sheet title in this format "file name"#"id" failed.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class ParsePropIdException extends IOException {

    public ParsePropIdException(String message) {
        super(message);
    }
}
