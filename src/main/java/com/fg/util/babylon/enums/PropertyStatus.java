package com.fg.util.babylon.enums;

/**
 * Working status of one property in translation process.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public enum PropertyStatus {
    /** Value of property is new (generally) */
    NEW,
    /** Value of property in primary mutation file is changed */
    CHANGED,
    /** Value of property in primary mutation file is unchanged */
    UNCHANGED
}
