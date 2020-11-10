package com.fg.util.babylon.processor;

import lombok.extern.apachecommons.CommonsLog;

import java.io.*;
import java.security.GeneralSecurityException;

/**
 * Base class for all processors.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public abstract class BaseProcessor {

    /** Name of the column with names of the properties in google sheet. */
    static final String COL_KEY = "key";
    /** Name of the column with text values of the primary mutation in google sheet. */
    static final String COL_PRIMARY = "primary";
    static final String EMPTY_VAL = "";


    public void startTranslation() throws IOException, GeneralSecurityException, InterruptedException {
        processTranslation();
    }

    protected abstract void processTranslation() throws IOException, GeneralSecurityException, InterruptedException;

}
