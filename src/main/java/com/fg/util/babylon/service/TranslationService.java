package com.fg.util.babylon.service;

import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.enums.Action;
import com.fg.util.babylon.processor.AntPathResourceLoader;
import com.fg.util.babylon.processor.ExportProcessor;
import com.fg.util.babylon.processor.I18nFileManager;
import com.fg.util.babylon.processor.ImportProcessor;
import com.fg.util.babylon.processor.spring.SpringResourceLoader;
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

    public TranslationService(GoogleSheetApi gss, DataFileManager dfm, Arguments arguments, TranslationConfiguration configuration) {
        AntPathResourceLoader springResLoader = new SpringResourceLoader();
        I18nFileManager i18FileManager = new I18nFileManager();
        exportProcessor = new ExportProcessor(gss, dfm, i18FileManager, springResLoader, arguments.getGoogleSheetId(), configuration);
        importProcessor = new ImportProcessor(gss, dfm, i18FileManager, arguments.getGoogleSheetId(), configuration);
        this.action = arguments.getAction();
    }

    public void startTranslation() throws IOException, GeneralSecurityException, InterruptedException {
        long stTime = System.currentTimeMillis();
        switch (action) {
            case EXPORT:
                exportProcessor.doExport();
                break;
            case IMPORT:
                importProcessor.doImport();
                break;
        }
        log.info("Translation done in: " + (System.currentTimeMillis() - stTime) + "ms");
    }

}
