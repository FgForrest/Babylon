package com.fg.util.babylon.export;

import com.fg.util.babylon.entity.MessageFileContent;
import com.fg.util.babylon.entity.PropertiesMap;
import com.fg.util.babylon.entity.Snapshot;

import java.util.NoSuchElementException;

/**
 * Implements snapshot contracts by delegating to [Snapshot] without exposing its details.
 */
public class SnapshotAdapter implements TranslationSnapshotReadContract, TranslationSnapshotWriteContract {

    private final Snapshot snapshot;

    public SnapshotAdapter(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    @Override
    public boolean includesMsgFile(String msgFile) {
        return snapshot.getPropFileByFileName(msgFile) != null;
    }

    @Override
    public Integer registerMsgFile(String msgFilePath) {
        MessageFileContent messageFileContent = snapshot.getOrPutNewPropFileByFileName(msgFilePath);
        return messageFileContent.id;
    }

    @Override
    public boolean containsMessage(String msgKey, String msgFile) {
        return containsMessageInProps(msgKey, getTranslationProperties(msgFile));
    }

    private boolean containsMessageInProps(String msgKey, PropertiesMap msgProps) {
        // PropertiesMap replaces null values with empty strings internally
        return msgProps.containsKey(msgKey) && msgProps.get(msgKey) != null && !msgProps.get(msgKey).isEmpty();
    }

    private PropertiesMap getTranslationProperties(String msgFile) {
        if (!includesMsgFile(msgFile)) {
            // caller should have asked before
            throw new NoSuchElementException("Translation snapshot doesn't contain message file '$msgFile'.");
        }
        return snapshot.getPropFileByFileName(msgFile).properties;
    }

    @Override
    public String getLastMessageValue(String msgKey, String msgFile) {
        return null;
    }


}
