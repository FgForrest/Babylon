package com.fg.util.babylon.export

import java.util.NoSuchElementException

/**
 * Set of operations that are required from the snapshot of current translation stat - i.e. the result of previous
 * translation synchronization roundtrip (export + import). In case no previous synchronization roundtrip has been completed,
 * the snapshot is empty.
 */
interface TranslationSnapshotReadContract {

    /**
     * Check if message file [msgFile] is part of translation snapshot.
     */
    fun includesMsgFile(msgFile: MsgFilePath): Boolean

    /**
     * Check if translation snapshot contains message [msgKey] for file [msgFile].
     *
     * @throws NoSuchElementException in case snapshot doesn't include [msgFile] at all
     */
    fun containsMessage(msgKey: MessageKey, msgFile: MsgFilePath): Boolean

    /**
     * Return the message value of the message key [msgKey] as captured in the snapshot.
     *
     * @throws NoSuchElementException if snapshot of file [msgFile] does not contain message with key[msgKey]
     * of if the snapshot doesn't include [msgFile] at all
     */
    fun getLastMessageValue(msgKey: MessageKey, msgFile: MsgFilePath): Message

}

