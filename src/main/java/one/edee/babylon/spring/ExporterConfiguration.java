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
    public Exporter exporter(TranslationCollector translationCollector,
                             TranslationSnapshotWriteContract snapshot,
                             Exporter.SheetContract sheetContract,
                             AntPathResourceLoader resourceLoader) {
        return new Exporter(translationCollector, snapshot, sheetContract, resourceLoader);
    }

    @Bean
    public TranslationCollector translationCollector(MessageLoader messageLoader,
                                              MessageFileProcessor messageFileProcessor,
                                              TranslationSnapshotReadContract snapshotReadContract,
                                              TranslationSnapshotWriteContract snapshotWriteContract) {
        return new TranslationCollector(messageLoader, messageFileProcessor, snapshotReadContract, snapshotWriteContract);
    }

    @Bean
    public MessageLoader messageLoader() {
        return new ApronMessageLoader();
    }

    @Bean
    public MessageFileProcessor messageFileProcessor(TranslationSnapshotReadContract snapshotReadContract) {
        return new MessageFileProcessor(snapshotReadContract);
    }

    @Bean
    public SnapshotAdapter snapshotAdapter(SnapshotManager snapshotManager) throws IOException {
        return new SnapshotAdapter(snapshotManager.getOrCreateDataFile());
    }

    @Bean
    public Exporter.SheetContract sheetContract(LightGSheetService lightGSheetService) {
        return new LightGSheetServiceExporterContractAdaptor(lightGSheetService);
    }

}
