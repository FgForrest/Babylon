package one.edee.babylon.snapshot;

import one.edee.babylon.entity.MessageFileContent;
import one.edee.babylon.entity.PropertiesMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        return snapshot.getPaths();
    }

    @Override
    public Integer registerMsgFile(String msgFilePath) {
        MessageFileContent messageFileContent = snapshot.getOrPutNewPropFileByFileName(msgFilePath);
        return messageFileContent.getId();
    }

    @Override
    public void removeMsgFilePaths(Collection<String> msgFilePaths) {
        snapshot.removePaths(msgFilePaths);
    }

    @Override
    public boolean containsMessage(String msgKey, String msgFile) {
        if (!includesMsgFile(msgFile)) return false;

        if (!includesMsgFile(msgFile)) {
            // caller should have asked before
            throw new NoSuchElementException("Translation snapshot doesn't contain message file '$msgFile'.");
        }
        MessageFileContent propFileByFileName = snapshot.getPropFileByFileName(msgFile);
        return containsMessageInProps(msgKey, propFileByFileName);
    }

    private boolean containsMessageInProps(String msgKey, MessageFileContent propFileByFileName) {
        // PropertiesMap replaces null values with empty strings internally
        return propFileByFileName.containsKey(msgKey) && propFileByFileName.getPropertyValue(msgKey) != null && !propFileByFileName.getPropertyValue(msgKey).isEmpty();
    }

    @Override
    public boolean hasSameMessage(@NotNull String msgKey, @NotNull String msgFile, @Nullable String currentMsg) {

        if (!includesMsgFile(msgFile)) {
            // caller should have asked before
            throw new NoSuchElementException("Translation snapshot doesn't contain message file '$msgFile'.");
        }
        MessageFileContent propFileByFileName = snapshot.getPropFileByFileName(msgFile);
        if (!containsMessageInProps(msgKey, propFileByFileName)) {
            // caller should have asked before
            String errMsg = "No message for key '" + msgKey + "' in '" + msgFile +"' message file snapshot.";
            throw new NoSuchElementException(errMsg);
        }
        return propFileByFileName.hasSameValue(msgKey, currentMsg);
    }

}
