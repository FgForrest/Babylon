package com.fg.util.babylon.export

import com.fg.util.babylon.entity.PropertiesMap
import com.fg.util.babylon.entity.Snapshot
import java.util.NoSuchElementException

/**
 * Set of write operations that are required from the translation snapshot.
 */
interface TranslationSnapshotWriteContract {

    /**
     * Generated persistent id for [msgFilePath] and stores the path along the new id
     *
     * @return persistent id given to the [msgFilePath]
     */
    fun registerMsgFile(msgFilePath: MsgFilePath): Int

}
