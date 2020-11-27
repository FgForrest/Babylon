package com.fg.util.babylon.snapshot;

import com.fg.util.babylon.entity.MessageFileContent;
import com.fg.util.babylon.util.JsonUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SnapshotService {

    /**
     * Saves created Snapshot object without properties into file on disk. Only if DataFile not exists on disk!
     * FIXME: tohle prida do snapshotu cesty k novym message souborum, stavajici to ponecha
     * FIXME: kdyz budu mit seznam novych souboru, nemusim tohle delat
     */
    public void saveSnapshotWithoutProperties(Snapshot currentSnapshot, Snapshot originalSnapshot, String snapshotName) throws IOException {
        Map<String, MessageFileContent> originalDataPropFiles = originalSnapshot.getDataPropFiles();

        Snapshot overriddenSnapshot = currentSnapshot;
        List<String> newExportedFiles = overriddenSnapshot.getDataPropFiles()
                .keySet()
                .stream()
                .filter(exportedFilePath -> !originalDataPropFiles.containsKey(exportedFilePath))
                .collect(Collectors.toList());
        updateSnapshotWithNewFilePaths(originalSnapshot, newExportedFiles, snapshotName);
    }

    public void updateSnapshotWithNewFilePaths(Snapshot originalSnapshot, Iterable<String> newMsgFiles, String snapshotName) throws IOException {
        newMsgFiles.forEach(newMsgFile ->
                originalSnapshot.putPropFile(newMsgFile, new MessageFileContent())
        );
        File snapshotFileName = new File(snapshotName);
        JsonUtils.objToJsonFile(snapshotFileName, originalSnapshot, true);
    }

}
