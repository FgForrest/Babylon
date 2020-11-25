package com.fg.util.babylon.export;

import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.Snapshot;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.gsheet.GoogleSheetContract;
import com.fg.util.babylon.gsheet.TranslationSheetService;
import com.fg.util.babylon.snapshot.SnapshotService;
import com.google.api.services.sheets.v4.model.Sheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class NewExporter {

    private final Exporter exporter;
    private final TranslationSheetService tss;
    private final DataFileManager dfm;
    private final GoogleSheetContract gsc;
    private final SnapshotService snapshotService;

    public NewExporter(Exporter exporter, TranslationSheetService tss, DataFileManager dfm, GoogleSheetContract gsc) {
        this.exporter = exporter;
        this.tss = tss;
        this.dfm = dfm;
        this.gsc = gsc;
        this.snapshotService = new SnapshotService();
    }

    public void go(List<String> patternPaths,
                   String spreadsheetId,
                   TranslationConfiguration config) {
        List<Sheet> prevSheets = listAllSheets(spreadsheetId);

        Exporter.ExportResult result = exporter.walkPathsAndCollectTranslationSheets(patternPaths, config.getMutations());

        uploadTranslations(result, spreadsheetId);

        Snapshot originalSnapshot = dfm.getOriginalDataFile();
        updateSnapshot(originalSnapshot, result, config.getDataFileName());

        List<Integer> prevSheetIds = prevSheets.stream().map(sheet -> sheet.getProperties().getSheetId()).collect(Collectors.toList());
        deleteOldSheets(prevSheetIds, spreadsheetId);
    }

    private List<Sheet> listAllSheets(String spreadsheetId) {
        try {
            return gsc.listSheets(spreadsheetId);
        } catch (GeneralSecurityException | IOException e) {
            String errMsg = "Error when listing sheets of spreadsheet '" + spreadsheetId + "'";
            throw new RuntimeException(errMsg, e);
        }
    }

    private void uploadTranslations(Exporter.ExportResult exportResult, String spreadsheetId) {
        AtomicInteger processed = new AtomicInteger(0);
        exportResult.getSheets().stream().forEach(sheet -> {
            try {
                tss.uploadDataToGoogleSheet(spreadsheetId, sheet.getRows(), sheet.getSheetName(), processed);
            } catch (IOException | GeneralSecurityException e) {
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
        } catch (IOException | GeneralSecurityException e) {
            String errMsg = "Error when deleting sheets '" + sheetIds + "'";
            throw new RuntimeException(errMsg, e);
        }
    }

}
