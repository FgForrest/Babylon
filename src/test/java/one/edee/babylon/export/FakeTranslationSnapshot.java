package one.edee.babylon.export;

import one.edee.babylon.snapshot.TranslationSnapshotReadContract;

import java.util.*;

public class FakeTranslationSnapshot implements TranslationSnapshotReadContract {

    private final Map<String, Map<String, String>> content;

    public FakeTranslationSnapshot(Map<String, Map<String, String>> content) {
        this.content = content;
    }

    @Override
    public boolean includesMsgFile(String msgFile) {
        return content.containsKey(msgFile);
    }

    @Override
    public Collection<String> listMsgFiles() {
        return new ArrayList<>(content.keySet());
    }

    @Override
    public boolean containsMessage(String msgKey, String msgFile) {
        if (!includesMsgFile(msgFile)) {
            return false;
        }
        Map<String, String> messages = content.get(msgFile);
        return messages != null && messages.containsKey(msgKey);
    }

    @Override
    public boolean hasSameMessage(String msgKey, String msgFile, String currentMsg) {
        return !Objects.equals(getLastMessageValue(msgKey, msgFile), currentMsg);
    }

    private String getLastMessageValue(String msgKey, String msgFile) {
        if (!containsMessage(msgKey, msgFile)) {
            throw new NoSuchElementException("Message with key '" + msgKey + "' is not included in the snapshot.");
        }
        return content.get(msgFile).get(msgKey);
    }
}