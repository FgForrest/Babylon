package com.fg.util.babylon.enums;

/**
 * Working status of one property in translation process.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public enum PropertyStatus {
    /** Value of property is new (generally) */
    NEW,
    /** Value of property in primary mutation file was changed or at least one mutation property status is not equals to UNCHANGED. Translation is needed. */
    CHANGED,
    /** Value for at least one secondary mutation is missing or whole secondary mutation properties file doesn't exists */
    MISSING,
    /** Value of property in primary mutation file is unchanged, all mutations is also translated so no translation is needed */
    UNCHANGED
}
