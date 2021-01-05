package one.edee.babylon.enums;

/**
 * Enum of all supported actions in Babylon.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public enum Action {
    /**
     * Action for export of data to be translated, from source language properties files, specified by Json Configuration file,
     * through Json DataFile into Google sheet specified by ID.
     */
    EXPORT,
    /**
     * Action for import of translated data from Google sheet specified by ID, through Json DataFile into language properties files,
     * according to given Json Configuration file.
     */
    IMPORT
}
