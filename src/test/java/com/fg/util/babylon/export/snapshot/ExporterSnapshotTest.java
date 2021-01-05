package com.fg.util.babylon.export.snapshot;

import com.fg.util.babylon.config.TranslationConfiguration;
import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.db.SnapshotManagerTestUtils;
import com.fg.util.babylon.db.SnapshotUtils;
import com.fg.util.babylon.entity.MessageFileContent;
import com.fg.util.babylon.export.FakeExporterSheetContractImpl;
import com.fg.util.babylon.export.NewExporter;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import com.fg.util.babylon.snapshot.Snapshot;
import com.fg.util.babylon.spring.CommonConfiguration;
import com.fg.util.babylon.spring.ExporterConfiguration;
import com.fg.util.babylon.util.ResourceUtils;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ExporterSnapshotTest.CommonTestConfiguration.class, ExporterSnapshotTest.ExporterTestConfiguration.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) //to get a fresh instance of SnapshotManager
public class ExporterSnapshotTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private FakeExporterSheetContractImpl fakeSheets;

    @Autowired
    private NewExporter exporter;

    /**
     * we need to change paths of snapshot in tests, unlike in production
     */
    @Autowired
    private SnapshotManager snapshotManager;

    /**
     * root temp directory for test dirs
     */
    private static Path testRootDir;

    /**
     * temp directory for individual tests makes it possible to easily locate the files during test
     */
    private Path testDir;

    @BeforeClass
    public static void createTmpRootDir() throws IOException {
        testRootDir = Files.createTempDirectory(ExporterSnapshotTest.class.getSimpleName());
    }

    @Before
    public void createTempDir() throws IOException {
        testDir = Files.createTempDirectory(testRootDir, ExporterSnapshotTest.class.getSimpleName());
    }

    @AfterClass
    public static void deleteTmpRootDir() {
        FileUtils.deleteQuietly(testRootDir.toFile());
    }

    @After
    public void deleteTempDir() {
        FileUtils.deleteQuietly(testDir.toFile());
    }

    @Test
    public void when_snapshot_does_not_exist_yet__then_new_snapshot_contains_empty_content_of_message_files__01() throws IOException {
        Path newSnapshot = Paths.get("empty-snapshot.json");
        File msgFile = ResourceUtils.loadRelativeResourceAsFile("01-single.properties", testDir, this.getClass());
        List<String> paths = Arrays.asList(msgFile.toString());
        List<String> langs = Arrays.asList("sk", "en");

        exporter.walkPathsAndWriteSheets(paths, langs, "N/A", newSnapshot);

        assertThat("When a single message file was processed, then there should be one sheet created", fakeSheets.getSheets().size(), equalTo(1));

        // manually load resulting snapshot file to examine it
        Snapshot resultingSnapshot = SnapshotUtils.readSnapshot(newSnapshot);
        Map<String, MessageFileContent> msgFiles = resultingSnapshot.getDataPropFiles();

        String msgFilePath = msgFile.getAbsolutePath();
        assertThat("When single message file is exported and the snapshot is empty, then the snapshot must contain exactly one record", msgFiles, is(aMapWithSize(1)));
        assertThat("...then the snapshot must contain the message file", msgFiles, hasKey(msgFilePath));
        assertThat("...then the message file must must be stored under id=0", msgFiles.get(msgFilePath).id, equalTo(0));
        assertThat("...then the content of the message file in snapshot must be empty (until it is imported back)", msgFiles.get(msgFilePath).properties, is(anEmptyMap()));
    }

    private Path getSnapshotAndReplacePlaceholder(String snapshotPath, String placeholder, String replaceWith) throws IOException {
        Path snapshotFile = ResourceUtils.loadRelativeResourceAsFile(snapshotPath, testDir, this.getClass()).toPath();
        // replace placeholder for message file name in snapshot
        String content = new String(Files.readAllBytes(snapshotFile), StandardCharsets.UTF_8);
        content = content.replaceAll(placeholder, replaceWith);
        Files.write(snapshotFile, content.getBytes(StandardCharsets.UTF_8));
        return snapshotFile;
    }

    @Test
    public void when_snapshot_exists_and_additional_messages_in_message_file__then_snapshot_content_of_message_file_is_updated__02() throws IOException {
        Path snapshotOutput = Files.createTempFile(testDir, "translation-test-output-db", ".json");
        File msgFile = ResourceUtils.loadRelativeResourceAsFile("02-additional.properties", testDir, this.getClass());
        List<String> paths = Arrays.asList(msgFile.toString());
        List<String> langs = Arrays.asList("sk", "en");

        Path existingSnapshotFile = getSnapshotAndReplacePlaceholder("02-nonempty-snapshot.json", "XXX", msgFile.getAbsolutePath());
        SnapshotManagerTestUtils.setSnapshotFile(existingSnapshotFile, snapshotManager);
        assumeThat("When a snapshot is loaded from existing snapshot file containing translations, then it is not empty", snapshotManager.getOrCreateDataFile().getDataPropFiles(), not(anEmptyMap()));
        String existingMsgFilePath = msgFile.getAbsolutePath();
        assumeThat("...it already contains some messages", snapshotManager.getOrCreateDataFile().getDataPropFiles(), hasKey(existingMsgFilePath));

        exporter.walkPathsAndWriteSheets(paths, langs, "N/A", snapshotOutput);

        assertThat("When existing snapshot contained the same message file as the message file processed, then there should be exactly one sheet created", fakeSheets.getSheets().size(), equalTo(1));

        // manually load resulting snapshot file to examine it
        Snapshot resultingSnapshot = SnapshotUtils.readSnapshot(snapshotOutput);
        Map<String, MessageFileContent> msgFiles = resultingSnapshot.getDataPropFiles();

        String msgFilePath = msgFile.getAbsolutePath();
        assertThat("When a message file is exported and snapshot already contains it, then the snapshot must contain exactly one record", msgFiles, is(aMapWithSize(1)));
        assertThat("...then the snapshot must contain the message file", msgFiles, hasKey(msgFilePath));
        assertThat("...then the id of the stored message file must not change", msgFiles.get(msgFilePath).id, equalTo(0));
        // this is the "exported" snapshot
        assertThat("...then the content of the message remains empty)", msgFiles.get(msgFilePath).properties, is(anEmptyMap()));
    }

    @Configuration
    static class CommonTestConfiguration extends CommonConfiguration {

        @Bean
        @Override
        protected SnapshotManager snapshotManager(TranslationConfiguration configuration) throws IOException {
            Path tempFile = Files.createTempFile(testRootDir, "translation-test-db", ".json");
            return new SnapshotManager(tempFile);
        }

        @Bean
        @Override
        protected TranslationConfiguration translationConfiguration(Environment environment) {
            // empty configuration is OK for tests, path to snapshot is  explicitly
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
