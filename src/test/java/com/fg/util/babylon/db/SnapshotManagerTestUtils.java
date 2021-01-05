package com.fg.util.babylon.db;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Allows access to protected method of {@link SnapshotManager} to easily override snapshot path in tests.
 */
public class SnapshotManagerTestUtils {

    public static void setSnapshotFile(Path snapshotPath, SnapshotManager snapshotManager) throws IOException {
        snapshotManager.forceSetSnapshotFile(snapshotPath);
    }

}
