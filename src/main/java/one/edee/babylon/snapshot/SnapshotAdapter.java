package one.edee.babylon.snapshot;

import one.edee.babylon.entity.MessageFileContent;
import one.edee.babylon.entity.PropertiesMap;

import java.util.Collection;
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
    public Snapshot getUnderlyingSnapshot() {
        return snapshot;
    }

    @Override
    public boolean includesMsgFile(String msgFile) {
        return snapshot.getPropFileByFileName(msgFile) != null;
    }

    @Override
    public Collection<String> listMsgFiles() {
        return snapshot.dataPropFiles.keySet();
    }

    @Override
    public Integer registerMsgFile(String msgFilePath) {
        MessageFileContent messageFileContent = snapshot.getOrPutNewPropFileByFileName(msgFilePath);
        return messageFileContent.getId();
    }

    @Override
    public void removeMsgFilePaths(Collection<String> msgFilePaths) {
        snapshot.dataPropFiles.keySet().removeAll(msgFilePaths);
    }

    @Override
    public boolean containsMessage(String msgKey, String msgFile) {
        if (!includesMsgFile(msgFile)) return false;
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
        return snapshot.getPropFileByFileName(msgFile).getProperties();
    }

    @Override
    public String getLastMessageValue(String msgKey, String msgFile) {
        PropertiesMap msgProps = getTranslationProperties(msgFile);
        if (!containsMessageInProps(msgKey, msgProps)) {
            // caller should have asked before
            String errMsg = "No message for key '" + msgKey + "' in '" + msgFile +"' message file snapshot.";
            throw new NoSuchElementException(errMsg);
        }
        return msgProps.get(msgKey);
    }

}
