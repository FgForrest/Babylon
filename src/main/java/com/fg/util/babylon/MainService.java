package com.fg.util.babylon;

import com.fg.util.babylon.config.TranslationConfiguration;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.export.*;
import com.fg.util.babylon.imp0rt.ImportProcessor;
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
    private final NewExporter newExporter;

    @Autowired
    public MainService(NewExporter exporter,
                       ImportProcessor importProcessor) {
        this.newExporter = exporter;
        this.importProcessor = importProcessor;
    }
    
    public void startTranslation(Action action, TranslationConfiguration configuration, String spreadsheetId) throws IOException, GeneralSecurityException, InterruptedException {
        long stTime = System.currentTimeMillis();
        switch (action) {
            case EXPORT:
                log.info("New Babylon starting...");
                newExporter.walkPathsAndWriteSheets(configuration.getPath(), configuration.getMutations(), spreadsheetId, configuration.getDataFileName());
                break;
            case IMPORT:
                importProcessor.doImport(spreadsheetId);
                break;
        }
        log.info("Translation done in: " + (System.currentTimeMillis() - stTime) + "ms");
    }

}
