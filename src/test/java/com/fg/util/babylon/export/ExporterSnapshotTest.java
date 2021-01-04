package com.fg.util.babylon.export;

import com.fg.util.babylon.config.TranslationConfiguration;
import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.db.SnapshotUtils;
import com.fg.util.babylon.entity.MessageFileContent;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import com.fg.util.babylon.snapshot.Snapshot;
import com.fg.util.babylon.spring.CommonConfiguration;
import com.fg.util.babylon.spring.ExporterConfiguration;
import com.fg.util.babylon.util.ResourceUtils;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ExporterSnapshotTest.CommonTestConfiguration.class, ExporterSnapshotTest.ExporterTestConfiguration.class})
public class ExporterSnapshotTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private FakeExporterSheetContractImpl fakeSheets;

    @Autowired
    private NewExporter exporter;

    private Path tempDir;

    @Before
    public void createTmpDir() throws IOException {
        tempDir = Files.createTempDirectory(ExporterSnapshotTest.class.getSimpleName());
    }

    @After
    public void deleteTmpDir() {
        FileUtils.deleteQuietly(tempDir.toFile());
    }

    @Test
    public void when_snapshot_does_not_exist_yet__then_new_snapshot_contains_empty_content_of_message_files() throws IOException {
        Path snapshotOutput = Files.createTempFile(tempDir, "translation-test-output-db", ".json");
        List<String> langs = Arrays.asList("sk", "en");
        File msgFile = ResourceUtils.loadRelativeResourceAsFile("foo.properties", tempDir, this.getClass());
        List<String> paths = Arrays.asList(msgFile.toString());

        exporter.walkPathsAndWriteSheets(paths, langs, "N/A", snapshotOutput);

        assertThat(fakeSheets.getSheets().size(), equalTo(1));

        Snapshot resultingSnapshot = SnapshotUtils.readSnapshot(snapshotOutput);
        Map<String, MessageFileContent> msgFiles = resultingSnapshot.getDataPropFiles();

        String msgFilePath = msgFile.getAbsolutePath();
        assertThat("When single message file is exported, then snapshot must contain exactly one", msgFiles, is(aMapWithSize(1)));
        assertThat("When a message file is exported, then snapshot must contain it", msgFiles, hasKey(msgFilePath));
        assertThat("When a fresh snapshot is exported, the only message file must be stored with id=0", msgFiles.get(msgFilePath).id, equalTo(0));
        assertThat("When a file is exported for the first time, the content of stored message file must be empty", msgFiles.get(msgFilePath).properties, is(anEmptyMap()));
    }

    @Configuration
    static class CommonTestConfiguration extends CommonConfiguration {

        @Bean
        @Override
        protected SnapshotManager snapshotManager(TranslationConfiguration configuration) throws IOException {
            Path tempFile = Files.createTempFile("translation-test-db", ".json");
            tempFile.toFile().deleteOnExit();
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
