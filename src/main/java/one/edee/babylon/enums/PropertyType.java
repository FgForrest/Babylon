package one.edee.babylon.enums;

import one.edee.babylon.properties.Property;

/**
 * Enum of all types of properties {@link Property}
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public enum PropertyType {
    /**
     * Property value (key=value)
     */
    VALUE,
    /**
     * Property value (key=value) with multi line value escaped by '\'. *
     * {@link Property#getValue()} method is overridden to return value as single string separated by '\' + line separator.
     */
    MULTILINE,
    /**
     * Empty line in properties file.
     */
    EMPTY,
    /**
     * Comment in property file.
     */
    COMMENT,
    /* TODO VKR - document */
    UNKNOWN
}
