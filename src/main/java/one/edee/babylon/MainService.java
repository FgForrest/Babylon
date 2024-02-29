package one.edee.babylon;

import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.enums.Action;
import one.edee.babylon.export.*;
import one.edee.babylon.imp0rt.ImportProcessor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Main service for translation.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Service
@CommonsLog
public class MainService {

    private final ImportProcessor importProcessor;
    private final Exporter exporter;

    @Autowired
    public MainService(Exporter exporter,
                       ImportProcessor importProcessor) {
        this.exporter = exporter;
        this.importProcessor = importProcessor;
    }

    public void startTranslation(Action action, TranslationConfiguration configuration, String spreadsheetId, boolean combineSheets, String deeplApiKey) throws IOException, GeneralSecurityException, InterruptedException {
        long stTime = System.currentTimeMillis();
        switch (action) {
            case EXPORT:
                log.info("Babylon starting...");
                exporter.walkPathsAndWriteSheets(
                        configuration.getPath(),
                        configuration.getMutations(),
                        spreadsheetId,
                        configuration.getSnapshotPath(),
                        configuration.getLockedCellEditors(),
                        combineSheets,
                        deeplApiKey,
                        configuration.getDefaultLang());
                break;
            case IMPORT:
                importProcessor.doImport(spreadsheetId);
                break;
        }
        log.info("Translation done in: " + (System.currentTimeMillis() - stTime) + "ms");
    }

}
