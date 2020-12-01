//package com.fg.util.babylon.export;
//
//import com.fg.util.babylon.snapshot.TranslationSnapshotReadContract;
//import com.fg.util.babylon.snapshot.TranslationSnapshotWriteContract;
//import lombok.extern.apachecommons.CommonsLog;
//import lombok.val;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
//
///**
// * Collects messages from primary language message files and from translation message files.
// */
//@CommonsLog
//public class TranslationCollectur {
//
//    private MessageLoader messageLoader;
//    private MessageFileProcessor messageFileProcessor;
//    private TranslationSnapshotReadContract snapshotReadContract;
//    private TranslationSnapshotWriteContract snapshotWriteContract;
//
//    public TranslationCollectur(MessageLoader messageLoader,
//                                MessageFileProcessor messageFileProcessor,
//                                TranslationSnapshotReadContract snapshotReadContract,
//                                TranslationSnapshotWriteContract snapshotWriteContract) {
//        this.messageLoader = messageLoader;
//        this.messageFileProcessor = messageFileProcessor;
//        this.snapshotReadContract = snapshotReadContract;
//        this.snapshotWriteContract = snapshotWriteContract;
//    }
//
//    /**
//     * Collects message files and given a list of languages to translate to, generates a translation sheet
//     * that contains messages in primary language and possibly existing translated messages, if the translated message
//     * exists for given language and unless invalidated by the change to its primary message.
//     *
//     * @param allPaths    paths to message files
//     * @param translateTo list of languages to translate to
//     */
//    TranslationCollector.ExportResult walkPathsAndCollectTranslationSheets(Collection<String> allPaths,
//                                                                           List<String> translateTo) {
//        val newMsgFilesPaths = allPaths.stream()
//                .filter(msgFilePath -> !snapshotReadContract.includesMsgFile(msgFilePath))
//                .collect(Collectors.toList());
//
//        val sheets = allPaths.stream()
//                .map(msgFilePath -> processMsgFile(msgFilePath, translateTo))
//                .collect(Collectors.toList());
//
//        //FIXME: move up?
//        val obsoleteFilePaths = snapshotReadContract.listMsgFiles().stream()
//                .filter(msgFilePath -> !allPaths.contains(msgFilePath))
//                .collect(Collectors.toList());
//        snapshotWriteContract.removeMsgFilePaths(obsoleteFilePaths);
//
//        return new TranslationCollector.ExportResult(newMsgFilesPaths, sheets);
//    }
//
//    private TranslationCollector.TranslationSheet processMsgFile(String msgFilePath, List<String> translateTo) {
//        val sheetRows = computeTranslationSheetRows(msgFilePath, translateTo);
//        val sheetId = snapshotWriteContract.registerMsgFile(msgFilePath);
//        val translationSheet = newTranslationSheet(sheetRows, sheetId, msgFilePath, translateTo);
//        log.info("Gathered '" + translationSheet.dataRows.size + "' translation rows from message file '$msgFilePath'.");
//        return translationSheet
//    }
//
//    private SheetRows computeTranslationSheetRows(String msgFilePath, List<String> translateTo) {
//        val primaryMsgs = messageLoader.loadPrimaryMessages(msgFilePath);
//        val translations = messageLoader.loadTranslations(msgFilePath, translateTo);
//
//        return messageFileProcessor.prepareTranslationSheet(msgFilePath, primaryMsgs, translations, translateTo);
//    }
//
//    private TranslationSheet newTranslationSheet(SheetRows sheetRows, Integer sheetId, String msgFilePath, List<String> translateTo) {
//        val header = createSheetHeader(msgFilePath, translateTo);
//        val sheetName = SheetUtils().getSheetName(msgFilePath, sheetId);
//        val allRows = listOf(header) + sheetRows
//        return TranslationSheet(sheetName, allRows);
//    }
//
//    private SheetRow createSheetHeader(String msgFilePath, List<String> targetLangs) {
//        List
//        return listOf("key", "primary") + targetLangs;
//    }
//
//}
