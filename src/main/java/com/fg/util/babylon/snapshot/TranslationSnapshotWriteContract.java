package com.fg.util.babylon.snapshot;

import java.util.Collection;

/**
 * Set of write operations that are required from the translation snapshot.
 */
public interface TranslationSnapshotWriteContract {

    /**
     * Generated persistent id for [msgFilePath] and stores the path along the new id
     *
     * @param msgFilePath message file path that will be registered in the snapshot
     * @return persistent id given to the [msgFilePath]
     */
    Integer registerMsgFile(String msgFilePath);

    /**
     * Removes message file paths from the translation snapshot.
     *
     * @param msgFilePaths message file paths to remove
     */
    void removeMsgFilPaths(Collection<String> msgFilePaths);

}