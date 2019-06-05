package com.fg.util.babylon.service;

import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.processor.ExportProcessor;
import com.fg.util.babylon.processor.ImportProcessor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Main service for translation.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Service
@CommonsLog
public class TranslationService {

    @Autowired
    private ApplicationContext context;

    public void startTranslation(Arguments arguments) throws IOException, GeneralSecurityException {
        log.info("Translation started with parameters: " + arguments.toString());
        long stTime = System.currentTimeMillis();
        switch (arguments.getAction()) {
            case EXPORT:
                ExportProcessor exportProcessor = context.getBean(ExportProcessor.class);
                exportProcessor.startTranslation(arguments);
                break;
            case IMPORT:
                ImportProcessor importProcessor = context.getBean(ImportProcessor.class);
                importProcessor.startTranslation(arguments);
                break;
        }
        log.info("Translation done in: " + (System.currentTimeMillis() - stTime) + "ms");
    }

}
