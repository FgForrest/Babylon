package one.edee.babylon.db;

import one.edee.babylon.snapshot.Snapshot;
import one.edee.babylon.util.JsonUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Utils to read/write {@link one.edee.babylon.snapshot.Snapshot} from/to JSON.
 */
public class SnapshotUtils {

    public static Snapshot readSnapshot(Path path) throws IOException {
        return readSnapshot(path.toFile());
    }

    public static Snapshot readSnapshot(File file) throws IOException {
        return JsonUtils.jsonObjFromFile(file, Snapshot.class);
    }

    public static void writeSnapshot(Snapshot snapshot, Path path) throws IOException {
        writeSnapshot(snapshot, path.toFile());
    }

    public static void writeSnapshot(Snapshot snapshot, File file) throws IOException {
        JsonUtils.objToJsonFile(file, snapshot, true);
    }

}
