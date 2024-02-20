package one.edee.babylon.spring;

import one.edee.babylon.db.SnapshotManager;
import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.imp0rt.ImportProcessor;
import one.edee.babylon.properties.FileLoader;
import one.edee.babylon.properties.PropertyFileLoader;
import one.edee.babylon.properties.TsFileLoader;
import one.edee.babylon.sheets.gsheets.LightGSheetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ImporterConfiguration {

    @Bean
    public ImportProcessor importProcessor(LightGSheetService lightGSheetService,
                                    SnapshotManager snapshotManager,
                                    List<FileLoader> propertyFileLoaders,
                                    TranslationConfiguration configuration) {
        return new ImportProcessor(lightGSheetService, snapshotManager, propertyFileLoaders, configuration);
    }

    @Bean
    public FileLoader propertyFileLoader() {
        return new PropertyFileLoader();
    }
    @Bean
    public FileLoader tsFileLoader() {
        return new TsFileLoader();
    }

}
