package com.fg.util.babylon.export;

import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.entity.MessageFileContent;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.export.dto.ExportResult;
import com.fg.util.babylon.sheets.gsheets.model.ASheet;
import com.fg.util.babylon.util.AntPathResourceLoader;
import com.fg.util.babylon.sheets.SheetsException;
import com.fg.util.babylon.sheets.export.ExporterSheetContract;
import com.fg.util.babylon.snapshot.Snapshot;
import com.fg.util.babylon.util.JsonUtils;
import com.fg.util.babylon.util.PathUtils;
import lombok.extern.apachecommons.CommonsLog;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//FIXME: should throw unchecked or checked exceptions?
@CommonsLog
public class NewExporter {

    private final TranslationCollector translationCollector;
    private final SnapshotManager dfm;
    private final ExporterSheetContract gsc;
    private final AntPathResourceLoader resourceLoader;
    private final PathUtils pu;

    //FIXME: move to config
    private static final List<String> lockedCellEditors = Arrays.asList("kosar@fg.cz", "kamenik@fg.cz");

    public NewExporter(TranslationCollector translationCollector, SnapshotManager dfm, ExporterSheetContract gsc, AntPathResourceLoader resourceLoader) {
        this.translationCollector = translationCollector;
        this.dfm = dfm;
        this.gsc = gsc;
        this.resourceLoader = resourceLoader;
        this.pu = new PathUtils();
    }

    public void walkPathsAndWriteSheets(List<String> patternPaths,
                                        String spreadsheetId,
                                        TranslationConfiguration config) {
        warnDuplicatePaths(patternPaths);

        List<ASheet> prevSheets = listAllSheets(spreadsheetId);

        Collection<String> allUniquePaths = expandsToUniquePaths(patternPaths);
        boolean pathsOk = checkPathsExist(allUniquePaths);
        if (!pathsOk) {
            throw new IllegalArgumentException("Please fix the message file paths in the configuration file.");
        }

        ExportResult result = translationCollector.walkPathsAndCollectTranslationSheets(allUniquePaths, config.getMutations());

        uploadTranslations(result, spreadsheetId, lockedCellEditors);

        Snapshot originalSnapshot = dfm.getOriginalDataFile();
        updateSnapshotAndWriteToDisk(originalSnapshot, result, config.getDataFileName());

        List<Integer> prevSheetIds = prevSheets.stream().map(sheet -> sheet.getId()).collect(Collectors.toList());
        deleteOldSheets(prevSheetIds, spreadsheetId);
    }

    private void warnDuplicatePaths(List<String> patternPaths) {
        List<String> duplicatePaths = detectDuplicatePatternPaths(patternPaths);
        if (!duplicatePaths.isEmpty()) {
            log.warn("Detected duplicate message file paths in configuration file:");
            duplicatePaths.forEach(dup -> log.warn("'" + dup + "' is defined more than once."));
        }
    }

    private List<String> detectDuplicatePatternPaths(List<String> patternPaths) {
        return patternPaths.stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    private Collection<String> expandsToUniquePaths(List<String> patternPaths) {
        return patternPaths.stream()
                .map(path -> expandPath(path))
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private List<String> expandPath(String patternPath) {
        try {
            return pu.expandPath(patternPath, resourceLoader);
        } catch (IOException e) {
            throw new RuntimeException("Error when expanding path '" + patternPath + "'", e);
        }
    }

    private boolean checkPathsExist(Collection<String> paths) {
        boolean pathsOk = true;
        for (String path : paths) {
            if (! new File(path).exists()) {
                log.error("File '" + path + "' could not be found.");
                pathsOk = false;
            }
        }
        return pathsOk;
    }

    private List<ASheet> listAllSheets(String spreadsheetId) {
        try {
            return gsc.listSheets(spreadsheetId);
        } catch (SheetsException e) {
            String errMsg = "Error when listing sheets of spreadsheet '" + spreadsheetId + "'";
            throw new RuntimeException(errMsg, e);
        }
    }

    private void uploadTranslations(ExportResult exportResult, String spreadsheetId, List<String> lockedCellEditors) {
        int remaining = exportResult.getSheets().size();
        exportResult.getSheets().stream()
                .filter(sheet -> !sheet.getDataRows().isEmpty())
                .forEach(sheet -> {
                    try {
                        log.info("Writing " + sheet.getDataRows().size() + " rows into sheet '" + sheet.getSheetName() + "'.");
                        gsc.createSheet(spreadsheetId, sheet.getSheetName(), sheet.getRows(), lockedCellEditors);
                    } catch (SheetsException e) {
                        String errMsg = "Error when uploading data to spreadsheet '" + spreadsheetId + "'";
                        throw new RuntimeException(errMsg, e);
                    }
                });
    }

    private void updateSnapshotAndWriteToDisk(Snapshot originalSnapshot, ExportResult exportResult, String snapshotFilename) {
        try {
            Iterable<String> newMsgFiles = exportResult.getPathsOfNewMsgFiles();
            newMsgFiles.forEach(newMsgFile ->
                    originalSnapshot.putPropFile(newMsgFile, new MessageFileContent())
            );
            File snapshotFileName = new File(snapshotFilename);
            JsonUtils.objToJsonFile(snapshotFileName, originalSnapshot, true);
        } catch (IOException e) {
            String errMsg = "Error when updating translation snapshot '" + snapshotFilename + "' with new message file paths.";
            throw new RuntimeException(errMsg, e);
        }
    }

    private void deleteOldSheets(Collection<Integer> sheetIds, String spreadsheetId) {
        try {
            gsc.deleteSheets(spreadsheetId, sheetIds);
        } catch (SheetsException e) {
            String errMsg = "Error when deleting sheets '" + sheetIds + "'";
            throw new RuntimeException(errMsg, e);
        }
    }

}
