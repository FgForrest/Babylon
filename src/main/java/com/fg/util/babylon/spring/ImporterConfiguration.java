package com.fg.util.babylon.spring;

import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.config.TranslationConfiguration;
import com.fg.util.babylon.imp0rt.ImportProcessor;
import com.fg.util.babylon.properties.PropertyFileLoader;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ImporterConfiguration {

    @Bean
    ImportProcessor importProcessor(LightGSheetService lightGSheetService,
                                    SnapshotManager snapshotManager,
                                    PropertyFileLoader propertyFileLoader,
                                    TranslationConfiguration configuration) {
        return new ImportProcessor(lightGSheetService, snapshotManager, propertyFileLoader, configuration);
    }

    @Bean
    PropertyFileLoader propertyFileLoader() {
        return new PropertyFileLoader();
    }

}
