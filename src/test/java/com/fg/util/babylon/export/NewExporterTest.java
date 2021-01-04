package com.fg.util.babylon.export;

import com.fg.util.babylon.config.TranslationConfiguration;
import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import com.fg.util.babylon.snapshot.TranslationSnapshotWriteContract;
import com.fg.util.babylon.spring.CommonConfiguration;
import com.fg.util.babylon.spring.ExporterConfiguration;
import com.fg.util.babylon.util.AntPathResourceLoader;
import lombok.val;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

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

    private Path tempDir;

    @Before
    public void createTmpDir() throws IOException {
        tempDir = Files.createTempDirectory(NewExporterTest.class.getSimpleName());
    }

    @After
    public void deleteTmpDir() {
        FileUtils.deleteQuietly(tempDir.toFile());
    }

    @Test
    public void when_translation_file_does_not_exists_then_does_not_blow_up() throws IOException {
        Path snapshotOutput = Files.createTempFile(tempDir, "translation-output", ".db");
        List<String> langs = Arrays.asList("sk", "en");
        File msgFile = loadRelativeResourceAsFile("foo.properties");
        List<String> paths = Arrays.asList(msgFile.toString());

        exporter.walkPathsAndWriteSheets(paths, langs, "N/A", snapshotOutput);

        assertThat(fakeSheets.getSheets().size(), equalTo(3));
    }

    private File loadRelativeResourceAsFile(String resourceName) throws IOException {
        Resource msgFileResource = new ClassRelativeResourceLoader(this.getClass()).getResource(resourceName);
        return resourceToFile(msgFileResource, tempDir);
    }

    private File resourceToFile(Resource resource, Path tempDir) throws IOException {
        File tempFile = File.createTempFile(resource.getFilename(), ".tmp", tempDir.toFile());
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(resource.getInputStream(), out);
        }
        return tempFile;
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
