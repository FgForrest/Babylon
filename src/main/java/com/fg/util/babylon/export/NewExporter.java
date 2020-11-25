package com.fg.util.babylon.export;

import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.Snapshot;
import com.fg.util.babylon.entity.TranslationConfiguration;
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

    public NewExporter(Exporter exporter, TranslationSheetService tss, DataFileManager dfm) {
        this.exporter = exporter;
        this.tss = tss;
        this.dfm = dfm;
    }

    public void go(List<String> patternPaths,
                   TranslationConfiguration config) {
        Snapshot originalSnapshot = dfm.getOriginalDataFile();
        Exporter.ExportResult result = exporter.walkPathsAndCollectTranslationSheets(patternPaths, config.getMutations());
        AtomicInteger processed = new AtomicInteger(0);
        SnapshotService ss = new SnapshotService();

        result.getSheets().stream().forEach(sheet -> {
            try {
                tss.uploadDataToGoogleSheet(sheet.getRows(), sheet.getSheetName(), processed);
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });
        //FIXME: pridat logovani asi?
        try {
            ss.updateSnapshotWithNewFilePaths(originalSnapshot, result.getPathsOfNewMsgFiles(), config.getDataFileName());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
