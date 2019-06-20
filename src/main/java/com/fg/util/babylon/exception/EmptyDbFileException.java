package com.fg.util.babylon.exception;

import com.fg.util.babylon.entity.DataFile;

import java.io.IOException;

/**
 * Exception when attempt to load {@link DataFile} object from empty json file is performed.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class EmptyDbFileException extends IOException {

    public EmptyDbFileException(String message) {
        super(message);
    }
}
