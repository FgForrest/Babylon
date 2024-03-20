package one.edee.babylon.snapshot;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
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
     * Lists all message files included in the translation snapshot
     *
     * @return collection of message file paths
     */
    Collection<String> listMsgFiles();

    /**
     * Check if translation snapshot contains message {@code msgKey} for file {@code msgFile}.
     *
     * @param msgKey key of message that might be contained in message file {@code msgFile}
     * @param msgFile message file path that we assume is included in the snapshot
     */
    boolean containsMessage(String msgKey, String msgFile);

    boolean hasSameMessage(@NotNull String msgKey, @NotNull String msgFile, @Nullable String currentMsg);
}
