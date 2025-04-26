package one.edee.babylon.spring;

import one.edee.babylon.SpringBootConsoleApplication;
import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.config.TranslationConfigurationReader;
import one.edee.babylon.db.SnapshotManager;
import one.edee.babylon.sheets.gsheets.GSheetApiRequestFactory;
import one.edee.babylon.sheets.gsheets.GSheetsClient;
import one.edee.babylon.sheets.gsheets.LightGSheetService;
import one.edee.babylon.sheets.gsheets.legacy.AuthorizedGSheetsClient;
import one.edee.babylon.util.AntPathResourceLoader;
import one.edee.babylon.util.spring.SpringResourceLoader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.Optional;

import static one.edee.babylon.maven.BabylonExpImpBaseMojo.CONFIG_FILE_PARAM;

@Configuration
public class CommonConfiguration {

    @Bean
    public SnapshotManager snapshotManager(TranslationConfiguration configuration) throws IOException {
        return new SnapshotManager(configuration.getSnapshotPath());
    }

    @Bean
    public AntPathResourceLoader antPathResourceLoader() {
        return new SpringResourceLoader();
    }

    @Bean
    public LightGSheetService lightGSheetService(GSheetApiRequestFactory gSheetApiRequestFactory, GSheetsClient gSheetsClient) {
        return new LightGSheetService(gSheetApiRequestFactory, gSheetsClient);
    }

    @Bean
    public GSheetApiRequestFactory gSheetApiRequestFactory() {
        return new GSheetApiRequestFactory();
    }

    @Bean
    public GSheetsClient gSheetsClient() {
        return new AuthorizedGSheetsClient();
    }

    @Bean
    public TranslationConfiguration translationConfiguration(Environment environment, Optional<ApplicationArguments> applicationArguments) throws IOException {
        String configFileName;
        if (applicationArguments.isPresent()){
            String[] array = applicationArguments.get().getNonOptionArgs().toArray(new String[0]);
            SpringBootConsoleApplication.Arguments arguments = SpringBootConsoleApplication.parseArguments(array);

            configFileName = arguments.getConfigFileName();
        }else {
            configFileName = environment.getProperty(CONFIG_FILE_PARAM);
        }
        TranslationConfigurationReader configReader = new TranslationConfigurationReader();
        return configReader.readAndCheckConfiguration(configFileName);
    }

}
