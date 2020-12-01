package com.fg.util.babylon.service;

import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.gsheets.GSheetsClient;
import com.fg.util.babylon.gsheets.GSheetApiRequestFactory;
import com.fg.util.babylon.gsheets.LightGSheetService;
import com.fg.util.babylon.legacy.GoogleSheetApi;
import com.fg.util.babylon.legacy.adaptors.LegacyGoogleServiceClientAdaptor;
import com.fg.util.babylon.snapshot.Snapshot;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.export.*;
import com.fg.util.babylon.sheet.export.GoogleSheetExporterContract;
import com.fg.util.babylon.legacy.adaptors.LegacyGSheetExporterApiAdaptor;
import com.fg.util.babylon.legacy.TranslationSheetService;
import com.fg.util.babylon.processor.AntPathResourceLoader;
import com.fg.util.babylon.processor.ExportProcessor;
import com.fg.util.babylon.processor.I18nFileManager;
import com.fg.util.babylon.processor.ImportProcessor;
import com.fg.util.babylon.processor.spring.SpringResourceLoader;
import com.fg.util.babylon.snapshot.SnapshotAdapter;
import lombok.extern.apachecommons.CommonsLog;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Main service for translation.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class MainService {

    private final ExportProcessor exportProcessor;
    private final ImportProcessor importProcessor;
    private final Action action;
    private final TranslationConfiguration configuration;

    private final NewExporter newExporter;

    public MainService(GoogleSheetApi gsApi, DataFileManager dfm, Arguments arguments, TranslationConfiguration configuration) throws IOException {
        AntPathResourceLoader springResLoader = new SpringResourceLoader();
        I18nFileManager i18FileManager = new I18nFileManager();
        TranslationSheetService tss = new TranslationSheetService(gsApi);
        exportProcessor = new ExportProcessor(tss, dfm, i18FileManager, springResLoader, configuration);
        importProcessor = new ImportProcessor(gsApi, dfm, i18FileManager, arguments.getGoogleSheetId(), configuration);
        this.configuration = configuration;
        this.action = arguments.getAction();

        MessageLoader ml = new OldMessageLoaderAdaptor(i18FileManager);
        Snapshot snapshot = dfm.getOrCreateDataFile();
        SnapshotAdapter snapshotAdapter = new SnapshotAdapter(snapshot);
        MessageFileProcessor mfp = new MessageFileProcessor(snapshotAdapter);
        TranslationCollector translationCollector = new TranslationCollector(ml, mfp, snapshotAdapter, snapshotAdapter);
        GSheetsClient gsClient = new LegacyGoogleServiceClientAdaptor(gsApi);
        LightGSheetService lgss = new LightGSheetService(new GSheetApiRequestFactory(), gsClient);
        GoogleSheetExporterContract gsc = new LegacyGSheetExporterApiAdaptor(lgss, gsApi);
        newExporter = new NewExporter(translationCollector, dfm, gsc, springResLoader);
    }

    public void startTranslation(String spreadsheetId) throws IOException, GeneralSecurityException, InterruptedException {
        long stTime = System.currentTimeMillis();
        switch (action) {
            case EXPORT:
                log.info("New Babylon starting...");
                newExporter.go(configuration.getPath(), spreadsheetId, configuration);
//                exportProcessor.doExport(configuration.getMutations());
                break;
            case IMPORT:
                importProcessor.doImport();
                break;
        }
        log.info("Translation done in: " + (System.currentTimeMillis() - stTime) + "ms");
    }

}
