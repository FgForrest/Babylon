package com.fg.util.babylon.service;

import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.processor.ExportProcessor;
import com.fg.util.babylon.processor.ImportProcessor;
import lombok.extern.apachecommons.CommonsLog;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Main service for translation.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class TranslationService {

    private final ExportProcessor exportProcessor;
    private final ImportProcessor importProcessor;
    private final Action action;

    public TranslationService(GoogleSheetService gss, DataFileManager dfm, Arguments arguments, TranslationConfiguration configuration) {
        exportProcessor = new ExportProcessor(gss, dfm, arguments, configuration);
        importProcessor = new ImportProcessor(gss, dfm, arguments, configuration);
        this.action = arguments.getAction();
    }

    public void startTranslation() throws IOException, GeneralSecurityException, InterruptedException {
        long stTime = System.currentTimeMillis();
        switch (action) {
            case EXPORT:
                exportProcessor.startTranslation();
                break;
            case IMPORT:
                importProcessor.startTranslation();
                break;
        }
        log.info("Translation done in: " + (System.currentTimeMillis() - stTime) + "ms");
    }

}
