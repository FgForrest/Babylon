package com.fg.util.babylon.processor;

/**
 * Base class for all processors.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public abstract class BaseProcessor {

    /** Name of the column with names of the properties in google sheet. */
    static final String COL_KEY = "key";
    /** Name of the column with text values of the primary mutation in google sheet. */
    static final String COL_PRIMARY = "primary";
    static final String EMPTY_VAL = "";

}
