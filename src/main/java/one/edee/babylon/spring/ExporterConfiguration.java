package one.edee.babylon.spring;

import one.edee.babylon.db.SnapshotManager;
import one.edee.babylon.export.*;
import one.edee.babylon.sheets.gsheets.LightGSheetService;
import one.edee.babylon.sheets.gsheets.LightGSheetServiceExporterContractAdaptor;
import one.edee.babylon.snapshot.SnapshotAdapter;
import one.edee.babylon.snapshot.TranslationSnapshotReadContract;
import one.edee.babylon.snapshot.TranslationSnapshotWriteContract;
import one.edee.babylon.util.AntPathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ExporterConfiguration {

    @Bean
    NewExporter exporter(TranslationCollector translationCollector,
                                   TranslationSnapshotWriteContract snapshot,
                                   NewExporter.SheetContract sheetContract,
                                   AntPathResourceLoader resourceLoader) {
        return new NewExporter(translationCollector, snapshot, sheetContract, resourceLoader);
    }

    @Bean
    TranslationCollector translationCollector(MessageLoader messageLoader,
                                              MessageFileProcessor messageFileProcessor,
                                              TranslationSnapshotReadContract snapshotReadContract,
                                              TranslationSnapshotWriteContract snapshotWriteContract) {
        return new TranslationCollector(messageLoader, messageFileProcessor, snapshotReadContract, snapshotWriteContract);
    }

    @Bean
    MessageLoader messageLoader() {
        return new ApronMessageLoader();
    }

    @Bean
    MessageFileProcessor messageFileProcessor(TranslationSnapshotReadContract snapshotReadContract) {
        return new MessageFileProcessor(snapshotReadContract);
    }

    @Bean
    SnapshotAdapter snapshotAdapter(SnapshotManager snapshotManager) throws IOException {
        return new SnapshotAdapter(snapshotManager.getOrCreateDataFile());
    }

    @Bean
    protected NewExporter.SheetContract sheetContract(LightGSheetService lightGSheetService) {
        return new LightGSheetServiceExporterContractAdaptor(lightGSheetService);
    }

}
