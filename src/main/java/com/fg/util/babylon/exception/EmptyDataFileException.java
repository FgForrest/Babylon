package com.fg.util.babylon.exception;

import com.fg.util.babylon.snapshot.Snapshot;

import java.io.IOException;

/**
 * Exception when attempt to save empty {@link Snapshot} object to json file.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class EmptyDataFileException extends IOException {

    public EmptyDataFileException(String message) {
        super(message);
    }
}
