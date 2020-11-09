package com.fg.util.babylon.service;

import com.fg.util.babylon.entity.Arguments;
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

    public TranslationService(GoogleSheetService gss) {
        exportProcessor = new ExportProcessor(gss);
        importProcessor = new ImportProcessor(gss);
    }

    public void startTranslation(Arguments arguments) throws IOException, GeneralSecurityException, InterruptedException {
        log.info("Translation started with arguments: " + arguments.toString());
        long stTime = System.currentTimeMillis();
        switch (arguments.getAction()) {
            case EXPORT:
                exportProcessor.startTranslation(arguments);
                break;
            case IMPORT:
                importProcessor.startTranslation(arguments);
                break;
        }
        log.info("Translation done in: " + (System.currentTimeMillis() - stTime) + "ms");
    }

}
