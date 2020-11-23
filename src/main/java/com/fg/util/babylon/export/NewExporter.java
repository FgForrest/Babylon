package com.fg.util.babylon.export;

import com.fg.util.babylon.gsheet.TranslationSheetService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NewExporter {

    private final Exporter exporter;
    private final TranslationSheetService tss;

    public NewExporter(Exporter exporter, TranslationSheetService tss) {
        this.exporter = exporter;
        this.tss = tss;
    }

    public void go(List<String> patternPaths,
                   List<String> translateTo) {
        Exporter.ExportResult result = exporter.walkPathsAndCollectTranslationSheets(patternPaths, translateTo);
        AtomicInteger processed = new AtomicInteger(0);
        result.getSheets().stream().forEach(sheet -> {
            try {
                tss.uploadDataToGoogleSheet(sheet.getRows(), sheet.getSheetName(), processed);
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });
    }
}
