package com.fg.util.babylon;

import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.export.*;
import com.fg.util.babylon.imp0rt.ImportProcessor;
import com.fg.util.babylon.sheets.gsheets.legacy.GoogleSheetApi;
import com.fg.util.babylon.sheets.gsheets.legacy.LegacyGoogleServiceClientAdaptor;
import com.fg.util.babylon.properties.PropertyFileLoader;
import com.fg.util.babylon.sheets.gsheets.GSheetApiRequestFactory;
import com.fg.util.babylon.sheets.gsheets.GSheetsClient;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import com.fg.util.babylon.sheets.gsheets.LightGSheetServiceExporterContractAdaptor;
import com.fg.util.babylon.snapshot.Snapshot;
import com.fg.util.babylon.snapshot.SnapshotAdapter;
import com.fg.util.babylon.util.AntPathResourceLoader;
import lombok.extern.apachecommons.CommonsLog;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Main service for translation.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class MainService {

    private final ImportProcessor importProcessor;
    private final Action action;
    private final TranslationConfiguration configuration;

    private final NewExporter newExporter;

    public MainService(GoogleSheetApi gsApi, Arguments arguments, TranslationConfiguration configuration) throws IOException {
        GSheetsClient gsClient = new LegacyGoogleServiceClientAdaptor(gsApi);
        LightGSheetService lgss = new LightGSheetService(new GSheetApiRequestFactory(), gsClient);

        SnapshotManager sm = new SnapshotManager(configuration.getSnapshotPath());
        AntPathResourceLoader springResLoader = new com.fg.util.babylon.util.spring.SpringResourceLoader();
        PropertyFileLoader propertyFileLoader = new PropertyFileLoader();
        importProcessor = new ImportProcessor(lgss, sm, propertyFileLoader, arguments.getGoogleSheetId(), configuration);
        this.configuration = configuration;
        this.action = arguments.getAction();

        MessageLoader ml = new ApronMessageLoader();
        Snapshot snapshot = sm.getOrCreateDataFile();
        SnapshotAdapter snapshotAdapter = new SnapshotAdapter(snapshot);
        MessageFileProcessor mfp = new MessageFileProcessor(snapshotAdapter);
        TranslationCollector translationCollector = new TranslationCollector(ml, mfp, snapshotAdapter, snapshotAdapter);
        ExporterSheetContract esc = new LightGSheetServiceExporterContractAdaptor(lgss);
        newExporter = new NewExporter(translationCollector, sm, esc, springResLoader);
    }

    public void startTranslation(String spreadsheetId) throws IOException, GeneralSecurityException, InterruptedException {
        long stTime = System.currentTimeMillis();
        switch (action) {
            case EXPORT:
                log.info("New Babylon starting...");
                newExporter.walkPathsAndWriteSheets(configuration.getPath(), spreadsheetId, configuration);
                break;
            case IMPORT:
                importProcessor.doImport();
                break;
        }
        log.info("Translation done in: " + (System.currentTimeMillis() - stTime) + "ms");
    }

}
