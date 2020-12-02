package com.fg.util.babylon.export

import com.fg.util.babylon.db.SnapshotManager
import com.fg.util.babylon.entity.TranslationConfiguration
import com.fg.util.babylon.processor.AntPathResourceLoader
import com.fg.util.babylon.propfiles.PropertyFileLoader
import com.fg.util.babylon.processor.spring.SpringResourceLoader
import com.fg.util.babylon.snapshot.Snapshot
import com.fg.util.babylon.snapshot.SnapshotAdapter
import org.junit.Test

class ExporterTest {

//    //FIXME: tady neco jako File?
//    var sm = SnapshotManager(configuration.getDataFileName())
//    val ml: MessageLoader = OldMessageLoaderAdaptor(PropertyFileLoader())
//    var springResLoader: AntPathResourceLoader = SpringResourceLoader()
//    val snapshot: Snapshot = sm.getOrCreateDataFile()
//    val snapshotAdapter = SnapshotAdapter(snapshot)
//    val mfp = MessageFileProcessor(snapshotAdapter)
//    val translationCollector = TranslationCollector(ml, mfp, snapshotAdapter, snapshotAdapter)
//    val esc = FakeExporterSheetContractImpl()
//
//    val exporter = NewExporter(translationCollector, sm, esc, springResLoader)
//
//    @Test
//    fun `foo`() {
//        val config = TranslationConfiguration()
//        exporter.walkPathsAndWriteSheets(paths, "test_spreadsheet", config)
//    }

}