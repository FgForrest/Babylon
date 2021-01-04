package com.fg.util.babylon.spring;

import com.fg.util.babylon.db.SnapshotManager;
import com.fg.util.babylon.export.*;
import com.fg.util.babylon.sheets.gsheets.LightGSheetService;
import com.fg.util.babylon.sheets.gsheets.LightGSheetServiceExporterContractAdaptor;
import com.fg.util.babylon.snapshot.SnapshotAdapter;
import com.fg.util.babylon.snapshot.TranslationSnapshotReadContract;
import com.fg.util.babylon.snapshot.TranslationSnapshotWriteContract;
import com.fg.util.babylon.util.AntPathResourceLoader;
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
        //FIXME: this needs to go
        return new SnapshotAdapter(snapshotManager.getOrCreateDataFile());
    }

    @Bean
    protected NewExporter.SheetContract sheetContract(LightGSheetService lightGSheetService) {
        return new LightGSheetServiceExporterContractAdaptor(lightGSheetService);
    }

}
