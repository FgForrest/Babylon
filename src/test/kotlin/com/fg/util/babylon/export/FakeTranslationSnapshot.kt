package com.fg.util.babylon.export

import java.util.NoSuchElementException

class FakeTranslationSnapshot(val content: Map<MsgFilePath, Messages>) : TranslationSnapshotReadContract {

    override fun includesMsgFile(msgFile: MsgFilePath): Boolean =
            content.containsKey(msgFile)

    override fun containsMessage(msgKey: MessageKey, msgFile: MsgFilePath): Boolean =
            if (!includesMsgFile(msgFile))
                throw NoSuchElementException("Message file '$msgFile' is not included in the snapshot.")
            else
                content[msgFile]!!.containsKey(msgKey)

    override fun getLastMessageValue(msgKey: MessageKey, msgFile: MsgFilePath): Message =
            if (!containsMessage(msgKey, msgFile))
                throw NoSuchElementException("Message with key '$msgKey' is not included in the snapshot.")
            else
                content[msgFile]!![msgKey]

}
