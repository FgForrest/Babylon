package one.edee.babylon.imp0rt;

/**
 * Updates content of message files (property files for primary language and for translations).
 */
public interface MessageWriter {

    /**
     * Stores new message in primary language.
     *
     * @param msgKey message key
     * @param msgValue message value
     */
    void storePrimaryMessage(String msgKey, String msgValue);

    /**
     * Stores translation (message in language different from primary).
     *
     * @param language translation language
     * @param msgKey message key
     * @param msgValue message value
     */
    void storeTranslation(String language, String msgKey, String msgValue);

}
