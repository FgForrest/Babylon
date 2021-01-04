package com.fg.util.babylon.export

import com.fg.util.babylon.db.SnapshotManager
import com.fg.util.babylon.config.TranslationConfiguration
import com.fg.util.babylon.snapshot.SnapshotAdapter
import com.fg.util.babylon.util.spring.SpringResourceLoader
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Ignore
import org.junit.Test
import java.nio.file.Files

class NewExporterTest {

    val tempFile = Files.createTempFile("translation-test-db", ".properties");

    val sm = SnapshotManager(tempFile)
    val snapshot = sm.getOrCreateDataFile()
    val snapshotAdapter = SnapshotAdapter(snapshot)

    val fesci = FakeExporterSheetContractImpl()

    val ml = ApronMessageLoader()
    var springResLoader = SpringResourceLoader()

    val mfp = MessageFileProcessor(snapshotAdapter)
    val translationCollector = TranslationCollector(ml, mfp, snapshotAdapter, snapshotAdapter)

    val exporter = NewExporter(translationCollector, snapshotAdapter, fesci, springResLoader)

    @Test @Ignore
    fun `when empty sheets then `() {
        val config = TranslationConfiguration()
        config.mutations = listOf("TODO", "TODO")

        val paths = listOf("TODO", "TODO", "TODO")

        //exporter.walkPathsAndWriteSheets(paths, "test_spreadsheet", config)

        assertThat(fesci.sheets.size, equalTo(3))
    }

}