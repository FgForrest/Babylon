package com.fg.util.babylon.export;

import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.processor.AntPathResourceLoader;
import com.fg.util.babylon.sheets.GoogleSheetContract;
import com.fg.util.babylon.legacy.TranslationSheetService;
import com.fg.util.babylon.sheets.SheetsException;
import com.fg.util.babylon.snapshot.Snapshot;
import com.fg.util.babylon.snapshot.SnapshotService;
import com.fg.util.babylon.util.PathUtils;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.val;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//FIXME: should throw unchecked or checked exceptions?
public class NewExporter {

    private final Exporter exporter;
    private final DataFileManager dfm;
    private final GoogleSheetContract gsc;
    private final SnapshotService snapshotService;
    private final AntPathResourceLoader resourceLoader;
    private final PathUtils pu;

    public NewExporter(Exporter exporter, DataFileManager dfm, GoogleSheetContract gsc, AntPathResourceLoader resourceLoader) {
        this.exporter = exporter;
        this.dfm = dfm;
        this.gsc = gsc;
        this.snapshotService = new SnapshotService();
        this.resourceLoader = resourceLoader;
        this.pu = new PathUtils();
    }

    public void go(List<String> patternPaths,
                   String spreadsheetId,
                   TranslationConfiguration config) {
        List<Sheet> prevSheets = listAllSheets(spreadsheetId);



        // FIXME remove:
        List<Integer> sheetIds = prevSheets.stream().map(sheet -> sheet.getProperties().getSheetId()).collect(Collectors.toList());
        sheetIds.remove(0);
        if (sheetIds.size() > 0) {
            deleteOldSheets(sheetIds, spreadsheetId);
        }

        Set<String> allUniquePaths = patternPaths.stream()
                .map(path -> expandPath(path))
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Exporter.ExportResult result = exporter.walkPathsAndCollectTranslationSheets(allUniquePaths, config.getMutations());

        uploadTranslations(result, spreadsheetId);

        Snapshot originalSnapshot = dfm.getOriginalDataFile();
        updateSnapshot(originalSnapshot, result, config.getDataFileName());

        List<Integer> prevSheetIds = prevSheets.stream().map(sheet -> sheet.getProperties().getSheetId()).collect(Collectors.toList());
        deleteOldSheets(prevSheetIds, spreadsheetId);
    }

    private List<String> expandPath(String patternPath) {
        try {
            return pu.expandPath(patternPath, resourceLoader);
        } catch (IOException e) {
            throw new RuntimeException("Error when expading path '" + patternPath + "'", e);
        }
    }

    private List<Sheet> listAllSheets(String spreadsheetId) {
        try {
            return gsc.listSheets(spreadsheetId);
        } catch (SheetsException e) {
            String errMsg = "Error when listing sheets of spreadsheet '" + spreadsheetId + "'";
            throw new RuntimeException(errMsg, e);
        }
    }

    private void uploadTranslations(Exporter.ExportResult exportResult, String spreadsheetId) {
        exportResult.getSheets().stream()
                .filter(sheet -> !sheet.getDataRows().isEmpty())
                .forEach(sheet -> {
                    try {
                        gsc.uploadDataToGoogleSheet(spreadsheetId, sheet.getSheetName(), sheet.getRows());
                    } catch (SheetsException e) {
                        String errMsg = "Error when uploading data to spreadsheet '" + spreadsheetId + "'";
                        throw new RuntimeException(errMsg, e);
                    }
                });
    }

    private void updateSnapshot(Snapshot originalSnapshot, Exporter.ExportResult exportResult, String snapshotFilename) {
        try {
            snapshotService.updateSnapshotWithNewFilePaths(originalSnapshot, exportResult.getPathsOfNewMsgFiles(), snapshotFilename);
        } catch (IOException e) {
            String errMsg = "Error when updating translation snapshot '" + snapshotFilename + "' with new message file paths.";
            throw new RuntimeException(errMsg, e);
        }
    }

    private void deleteOldSheets(Iterable<Integer> sheetIds, String spreadsheetId) {
        try {
            gsc.deleteSheets(spreadsheetId, sheetIds);
        } catch (SheetsException e) {
            String errMsg = "Error when deleting sheets '" + sheetIds + "'";
            throw new RuntimeException(errMsg, e);
        }
    }

}
