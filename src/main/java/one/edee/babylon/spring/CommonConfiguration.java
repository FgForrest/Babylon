package one.edee.babylon.spring;

import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.config.TranslationConfigurationReader;
import one.edee.babylon.db.SnapshotManager;
import one.edee.babylon.sheets.gsheets.GSheetApiRequestFactory;
import one.edee.babylon.sheets.gsheets.GSheetsClient;
import one.edee.babylon.sheets.gsheets.LightGSheetService;
import one.edee.babylon.sheets.gsheets.legacy.SheetsFactory;
import one.edee.babylon.sheets.gsheets.legacy.LegacyGoogleServiceClientAdaptor;
import one.edee.babylon.util.AntPathResourceLoader;
import one.edee.babylon.util.spring.SpringResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;

import static one.edee.babylon.maven.BabylonExpImpBaseMojo.CONFIG_FILE_PARAM;

@Configuration
public class CommonConfiguration {

    @Bean
    protected SnapshotManager snapshotManager(TranslationConfiguration configuration) throws IOException {
        return new SnapshotManager(configuration.getSnapshotPath());
    }

    @Bean
    AntPathResourceLoader antPathResourceLoader() {
        return new SpringResourceLoader();
    }

    @Bean
    LightGSheetService lightGSheetService(GSheetApiRequestFactory gSheetApiRequestFactory, GSheetsClient gSheetsClient) {
        return new LightGSheetService(gSheetApiRequestFactory, gSheetsClient);
    }

    @Bean
    GSheetApiRequestFactory gSheetApiRequestFactory() {
        return new GSheetApiRequestFactory();
    }

    @Bean
    GSheetsClient gSheetsClient(SheetsFactory sheetsFactory) {
        return new LegacyGoogleServiceClientAdaptor(sheetsFactory);
    }

    @Bean
    SheetsFactory sheetsFactory() {
        return new SheetsFactory();
    }

    @Bean
    protected TranslationConfiguration translationConfiguration(Environment environment) throws IOException {
        String configFileName = environment.getProperty(CONFIG_FILE_PARAM);
        TranslationConfigurationReader configReader = new TranslationConfigurationReader();
        return configReader.readAndCheckConfiguration(configFileName);
    }

}
