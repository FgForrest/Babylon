package com.fg.util.babylon.snapshot;

import com.fg.util.babylon.entity.MessageFileContent;
import com.fg.util.babylon.util.JsonUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SnapshotService {

    public void updateSnapshotWithNewFilePaths(Snapshot originalSnapshot, Iterable<String> newMsgFiles, String snapshotName) throws IOException {
        newMsgFiles.forEach(newMsgFile ->
                originalSnapshot.putPropFile(newMsgFile, new MessageFileContent())
        );
        File snapshotFileName = new File(snapshotName);
        JsonUtils.objToJsonFile(snapshotFileName, originalSnapshot, true);
    }

}
