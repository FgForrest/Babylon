package com.fg.util.babylon.export

import com.fg.util.babylon.entity.PropertiesMap
import com.fg.util.babylon.entity.Snapshot
import java.util.NoSuchElementException

/**
 * Set of operations that is required from the translation snapshot.
 */
interface TranslationSnapshotContract {

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

/**
 * Delegates to [Snapshot] without exposing its details.
 */
class SnapshotAdapter(private val snapshot: Snapshot) : TranslationSnapshotContract {

    override fun includesMsgFile(msgFile: String): Boolean =
            snapshot.getPropFileByFileName(msgFile) != null

    override fun containsMessage(msgKey: MessageKey, msgFile: MsgFilePath): Boolean =
            containsMessageInProps(msgKey, getTranslationProperties(msgFile))

    private fun containsMessageInProps(msgKey: MessageKey, msgProps: PropertiesMap): Boolean =
            // PropertiesMap replaces null values with empty strings internally
            if (!msgProps.containsKey(msgKey)) false else !msgProps[msgKey].isNullOrEmpty()

    override fun getLastMessageValue(msgKey: MessageKey, msgFile: MsgFilePath): Message {
        val msgProps = getTranslationProperties(msgFile)
        if (!containsMessageInProps(msgKey, msgProps)) {
            // caller should have asked before
            throw NoSuchElementException("No message for key '$msgKey' in '$msgFile' message file snapshot.")
        }
        return msgProps[msgKey]
    }

    private fun getTranslationProperties(msgFile: MsgFilePath): PropertiesMap {
        if (!includesMsgFile(msgFile)) {
            // caller should have asked before
            throw NoSuchElementException("Translation snapshot doesn't contain message file '$msgFile'.")
        }
        return snapshot.getPropFileByFileName(msgFile)?.properties!!
    }

}
