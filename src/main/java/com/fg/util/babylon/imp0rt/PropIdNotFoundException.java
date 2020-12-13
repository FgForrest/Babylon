package com.fg.util.babylon.imp0rt;

import java.io.IOException;

/**
 * Exception when unique id not found in specified json data file while import data.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class PropIdNotFoundException extends IOException {

    public PropIdNotFoundException(String message) {
        super(message);
    }
}
