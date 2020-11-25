package com.fg.util.babylon.export;

import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.Snapshot;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.gsheet.GoogleSheetContract;
import com.fg.util.babylon.gsheet.TranslationSheetService;
import com.fg.util.babylon.snapshot.SnapshotService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
                   TranslationConfiguration config) {
        gsc.listSheets()

        Exporter.ExportResult result = exporter.walkPathsAndCollectTranslationSheets(patternPaths, config.getMutations());

        uploadTranslations(result);

        Snapshot originalSnapshot = dfm.getOriginalDataFile();
        updateSnapshot(originalSnapshot, result, config.getDataFileName());
    }

    private void uploadTranslations(Exporter.ExportResult exportResult) {
        AtomicInteger processed = new AtomicInteger(0);
        exportResult.getSheets().stream().forEach(sheet -> {
            try {
                tss.uploadDataToGoogleSheet(sheet.getRows(), sheet.getSheetName(), processed);
            } catch (IOException | GeneralSecurityException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void updateSnapshot(Snapshot originalSnapshot, Exporter.ExportResult exportResult, String snapshotFilename) {
        //FIXME: pridat logovani asi?
        try {
            snapshotService.updateSnapshotWithNewFilePaths(originalSnapshot, exportResult.getPathsOfNewMsgFiles(), snapshotFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cleanPreviousSheets()

}
