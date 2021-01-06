package one.edee.babylon.spring;

import one.edee.babylon.db.SnapshotManager;
import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.imp0rt.ImportProcessor;
import one.edee.babylon.properties.PropertyFileLoader;
import one.edee.babylon.sheets.gsheets.LightGSheetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImporterConfiguration {

    @Bean
    public ImportProcessor importProcessor(LightGSheetService lightGSheetService,
                                    SnapshotManager snapshotManager,
                                    PropertyFileLoader propertyFileLoader,
                                    TranslationConfiguration configuration) {
        return new ImportProcessor(lightGSheetService, snapshotManager, propertyFileLoader, configuration);
    }

    @Bean
    public PropertyFileLoader propertyFileLoader() {
        return new PropertyFileLoader();
    }

}
