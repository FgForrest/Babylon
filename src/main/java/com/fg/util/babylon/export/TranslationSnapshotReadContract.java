package com.fg.util.babylon.export;

import java.util.NoSuchElementException;

/**
 * Set of operations that are required from the snapshot of current translation stat - i.e. the result of previous
 * translation synchronization roundtrip (export + import). In case no previous synchronization roundtrip has been completed,
 * the snapshot is empty.
 */
public interface TranslationSnapshotReadContract {

    /**
     * Check if message file {@code msgFile} is part of translation snapshot.
     *
     * @param msgFile message file path that is either included in the snapshot or it is not
     */
    boolean includesMsgFile(String msgFile);

    /**
     * Check if translation snapshot contains message {@code msgKey} for file {@code msgFile}.
     *
     * @param msgKey key of message that might be contained in message file {@code msgFile}
     * @param msgFile message file path that we assume is included in the snapshot
     * @throws NoSuchElementException in case snapshot doesn't include [msgFile] at all
     */
    boolean containsMessage(String msgKey, String msgFile);

    /**
     * Return the message value of the message key {@code msgKey} as captured in the snapshot.
     *
     * @param msgKey key of the message to retrieve from message file {@msgFile}
     * @param msgFile message file path that will be examined for given {@msgKey}
     * @throws NoSuchElementException if snapshot of file {@code msgFile} does not contain message with key {@code msgKey}
     * of if the snapshot doesn't include {@code msgFile} at all
     */
    String getLastMessageValue(String msgKey, String msgFile);

}
