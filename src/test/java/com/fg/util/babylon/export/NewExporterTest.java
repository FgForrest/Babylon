package com.fg.util.babylon.export;

import com.fg.util.babylon.config.TranslationConfiguration;
import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import com.fg.util.babylon.snapshot.TranslationSnapshotWriteContract;
import com.fg.util.babylon.spring.CommonConfiguration;
import com.fg.util.babylon.spring.ExporterConfiguration;
import com.fg.util.babylon.util.AntPathResourceLoader;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {NewExporterTest.CommonTestConfiguration.class, NewExporterTest.ExporterTestConfiguration.class})
public class NewExporterTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private FakeExporterSheetContractImpl fakeSheets;

    @Autowired
    private NewExporter exporter;
    
    @Test
    public void when_empty_sheets_then_HOVNO() throws IOException {
        val snapshotOutput = Files.createTempFile("translation-output-db", ".properties");
        val langs = Arrays.asList("sk", "en");
        val paths = Arrays.asList("TODO", "TODO", "TODO");

        exporter.walkPathsAndWriteSheets(paths, langs, "N/A", snapshotOutput);

        assertThat(fakeSheets.getSheets().size(), equalTo(3));
    }

    @Configuration
    static class CommonTestConfiguration extends CommonConfiguration {

        @Bean
        @Override
        protected SnapshotManager snapshotManager(TranslationConfiguration configuration) throws IOException {
            val tempFile = Files.createTempFile("translation-test-db", ".properties");
            return new SnapshotManager(tempFile);
        }

        @Bean
        @Override
        protected TranslationConfiguration translationConfiguration(Environment environment) {
            // empty configuration is OK for tests
            return new TranslationConfiguration();
        }

    }

    @Configuration
    static class ExporterTestConfiguration extends ExporterConfiguration {

        @Override
        protected NewExporter.SheetContract sheetContract(LightGSheetService lightGSheetService) {
            return new FakeExporterSheetContractImpl();
        }

    }


}
