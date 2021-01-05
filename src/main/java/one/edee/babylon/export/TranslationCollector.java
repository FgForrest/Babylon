package one.edee.babylon.export;

import one.edee.babylon.export.dto.ExportResult;
import one.edee.babylon.export.dto.MessageFileExportResult;
import one.edee.babylon.export.dto.TranslationSheet;
import one.edee.babylon.export.stats.MessageFileExportStats;
import one.edee.babylon.sheets.SheetUtils;
import one.edee.babylon.snapshot.TranslationSnapshotReadContract;
import one.edee.babylon.snapshot.TranslationSnapshotWriteContract;
import kotlin.Pair;
import lombok.extern.apachecommons.CommonsLog;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Collects messages from primary language message files and from translation message files.
 */
@CommonsLog
public class TranslationCollector {

    private MessageLoader messageLoader;
    private MessageFileProcessor messageFileProcessor;
    private TranslationSnapshotReadContract snapshotReadContract;
    private TranslationSnapshotWriteContract snapshotWriteContract;

    public TranslationCollector(MessageLoader messageLoader,
                                MessageFileProcessor messageFileProcessor,
                                TranslationSnapshotReadContract snapshotReadContract,
                                TranslationSnapshotWriteContract snapshotWriteContract) {
        this.messageLoader = messageLoader;
        this.messageFileProcessor = messageFileProcessor;
        this.snapshotReadContract = snapshotReadContract;
        this.snapshotWriteContract = snapshotWriteContract;
    }

    /**
     * Collects message files and given a list of languages to translate to, generates a translation sheet
     * that contains messages in primary language and possibly existing translated messages, if the translated message
     * exists for given language and unless invalidated by the change to its primary message.
     *
     * @param allPaths    paths to message files
     * @param translateTo list of languages to translate to
     */
    public ExportResult walkPathsAndCollectTranslationSheets(Collection<String> allPaths,
                                                             List<String> translateTo) {
        List<String> newMsgFilesPaths = allPaths.stream()
                .filter(msgFilePath -> !snapshotReadContract.includesMsgFile(msgFilePath))
                .collect(Collectors.toList());

        List<MessageFileExportResult> sheetsAndStats = allPaths.stream()
                .map(msgFilePath -> processMsgFile(msgFilePath, translateTo))
                .collect(Collectors.toList());

        List<TranslationSheet> sheets = getSheets(sheetsAndStats);
        List<MessageFileExportStats> exportStats = getStats(sheetsAndStats);

        logMsgFileStats(exportStats);

        List<String> obsoleteFilePaths = snapshotReadContract.listMsgFiles().stream()
                .filter(msgFilePath -> !allPaths.contains(msgFilePath))
                .collect(Collectors.toList());
        snapshotWriteContract.removeMsgFilePaths(obsoleteFilePaths);

        return new ExportResult(newMsgFilesPaths, sheets);
    }

    /** Collects only {@link TranslationSheet}s from {@link MessageFileExportResult} - for lack of tuples and unzip function */
    private List<TranslationSheet> getSheets(List<MessageFileExportResult> sheetsAndStats) {
        return sheetsAndStats.stream().map(MessageFileExportResult::getTranslationSheet).collect(Collectors.toList());
    }

    /** Collects only {@link MessageFileExportStats}s from {@link MessageFileExportResult} - for lack of tuples and unzip function */
    private List<MessageFileExportStats> getStats(List<MessageFileExportResult> sheetsAndStats) {
        return sheetsAndStats.stream().map(MessageFileExportResult::getExportStats).collect(Collectors.toList());
    }

    private MessageFileExportResult processMsgFile(String msgFilePath, List<String> translateTo) {
        Pair<SheetContent, MessageFileExportStats> msgFileResult = computeTranslationSheetRows(msgFilePath, translateTo);
        SheetContent sheetData = msgFileResult.getFirst();
        MessageFileExportStats msgFileStats = msgFileResult.getSecond();

        Integer sheetId = snapshotWriteContract.registerMsgFile(msgFilePath);
        TranslationSheet translationSheet = newTranslationSheet(sheetData, sheetId, msgFilePath, translateTo);

        return new MessageFileExportResult(translationSheet, msgFileStats);
    }

    private Pair<SheetContent, MessageFileExportStats> computeTranslationSheetRows(String msgFilePath, List<String> translateTo) {
        Map<String, String> primaryMsgs = messageLoader.loadPrimaryMessages(msgFilePath);
        Map<String, Map<String, String>> translations = messageLoader.loadTranslations(msgFilePath, translateTo);

        return messageFileProcessor.prepareTranslationSheet(msgFilePath, primaryMsgs, translations, translateTo);
    }

    private TranslationSheet newTranslationSheet(SheetContent sheetContent, Integer sheetId, String msgFilePath, List<String> translateTo) {
        String sheetName = new SheetUtils().getSheetName(msgFilePath, sheetId);

        List<List<String>> allRows = new ArrayList<>();
        allRows.addAll(Collections.singletonList(sheetContent.getHeader()));
        allRows.addAll(sheetContent.getDataRows());
        return new TranslationSheet(sheetName, allRows);
    }

    private void logMsgFileStats(Iterable<MessageFileExportStats> exportStats) {
        exportStats.forEach(msgFileStats -> logMsgFileStats(msgFileStats));
    }

    private void logMsgFileStats(MessageFileExportStats msgFileStats) {
        String msg = msgFileStats.getMessageFilePath() + ": " + "\n\t"
                + msgFileStats.getNewPrimaryMsgKeyCount() + " new messages, " + "\n\t"
                + msgFileStats.getChangedPrimaryMsgKeyCount() + " messages with changed values in primary language, " + "\n\t"
                + msgFileStats.getMissingTranslationMsgKeyCount() + " messages with some translations missing." + "\n\t"
                + msgFileStats.getSheetDataRows() + " total rows in translation sheet.";
        log.info(msg);
    }

}
