package com.fg.util.translator.service;

import com.fg.util.translator.entity.Arguments;
import com.fg.util.translator.entity.Configuration;
import com.fg.util.translator.util.JsonUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Service
@CommonsLog
public class TranslationService {

    private Arguments arguments;
    private Configuration configuration;

    public void startTranslation(Arguments arguments) throws IOException {
        log.info("Translation started with parameters: ");
        log.info(arguments.toString());
        this.arguments = arguments;
        readConfiguration();
        doTranslation();
    }

    private void readConfiguration() throws IOException {
        File file = new File(arguments.getConfigFileName());
        if (file.exists()) {
            throw new FileNotFoundException(arguments.getConfigFileName());
        }
        configuration = JsonUtils.jsonObjFromFile(file, Configuration.class);
    }

    private void doTranslation() {

    }

}
