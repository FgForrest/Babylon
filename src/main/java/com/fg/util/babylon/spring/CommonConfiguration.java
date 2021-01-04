package com.fg.util.babylon.spring;

import com.fg.util.babylon.config.TranslationConfiguration;
import com.fg.util.babylon.config.TranslationConfigurationReader;
import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.sheets.gsheets.GSheetApiRequestFactory;
import com.fg.util.babylon.sheets.gsheets.GSheetsClient;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import com.fg.util.babylon.sheets.gsheets.legacy.SheetsFactory;
import com.fg.util.babylon.sheets.gsheets.legacy.LegacyGoogleServiceClientAdaptor;
import com.fg.util.babylon.util.AntPathResourceLoader;
import com.fg.util.babylon.util.spring.SpringResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;

import static com.fg.util.babylon.maven.BabylonExpImpBaseMojo.CONFIG_FILE_PARAM;

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
