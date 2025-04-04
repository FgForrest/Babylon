package one.edee.babylon.export;

import lombok.Data;
import one.edee.babylon.sheets.SheetConstants;
import one.edee.babylon.export.stats.MessageFileExportStats;
import one.edee.babylon.snapshot.TranslationSnapshotReadContract;

import java.util.*;
import java.util.stream.Collectors;

public class MessageFileProcessor {

    private final TranslationSnapshotReadContract snapshotReadContract;

    public MessageFileProcessor(TranslationSnapshotReadContract snapshotReadContract) {
        this.snapshotReadContract = snapshotReadContract;
    }

    public static class SheetContent {
        private final List<String> header;
        private final List<List<String>> dataRows;
        private final int dataRowCount;

        public SheetContent(List<String> header, List<List<String>> dataRows) {
            this.header = header;
            this.dataRows = dataRows;
            this.dataRowCount = dataRows.size();
        }

        public List<String> getHeader() {
            return header;
        }

        public List<List<String>> getDataRows() {
            return dataRows;
        }

        public int getDataRowCount() {
            return dataRowCount;
        }
    }

    public Pair<SheetContent, MessageFileExportStats> prepareTranslationSheet(
            String msgFile,
            Map<String, String> primaryMsgs,
            Map<String, Map<String, String>> translations,
            List<String> translationLangs) {

        Set<String> newMessageKeys = determineNewMessageKeysUsingComparisonWithTranslation(primaryMsgs, translations);
        Map<String, String> existingMessages = new HashMap<>(primaryMsgs);
        newMessageKeys.forEach(existingMessages::remove);

        Set<String> changedKeys = determineChangedPrimaryMsgs(msgFile, existingMessages);
        Set<String> missingTranslations = determineMissingTranslatedMsgs(existingMessages, translations.values());

        Map<String, Integer> primaryMsgKeyOrdering = new LinkedHashMap<>();
        int index = 0;
        for (String key : primaryMsgs.keySet()) {
            primaryMsgKeyOrdering.put(key, index++);
        }

        SheetContent translationSheet = createTranslationSheet(
                primaryMsgs,
                translations,
                translationLangs,
                newMessageKeys,
                changedKeys,
                missingTranslations,
                primaryMsgKeyOrdering
        );

        MessageFileExportStats stats = new MessageFileExportStats(
                msgFile,
                newMessageKeys.size(),
                changedKeys.size(),
                missingTranslations.size(),
                translationSheet.getDataRowCount()
        );

        return new Pair<>(translationSheet, stats);
    }

    private Set<String> determineNewMessageKeysUsingComparisonWithTranslation(
            Map<String, String> primaryMsgs,
            Map<String, Map<String, String>> translations) {

        Set<String> allTranslationKeys = translations.values().stream()
                .flatMap(map -> map.keySet().stream())
                .collect(Collectors.toSet());

        return primaryMsgs.keySet().stream()
                .filter(k -> !allTranslationKeys.contains(k))
                .collect(Collectors.toSet());
    }

    private Set<String> determineChangedPrimaryMsgs(String msgFile, Map<String, String> existingPrimaryMsgs) {
        if (!snapshotReadContract.includesMsgFile(msgFile)) {
            return Collections.emptySet();
        }

        return existingPrimaryMsgs.entrySet().stream()
                .filter(entry ->
                        snapshotReadContract.containsMessage(entry.getKey(), msgFile) &&
                                !snapshotReadContract.hasSameMessage(entry.getKey(), msgFile, entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    private Set<String> determineMissingTranslatedMsgs(Map<String, String> primaryMsgs,
                                                       Collection<Map<String, String>> translations) {
        List<Set<String>> translationKeys = translations.stream()
                .map(Map::keySet)
                .collect(Collectors.toList());

        Set<String> keysInEveryTranslation = translationKeys.isEmpty() ?
                Collections.emptySet() :
                new HashSet<>(translationKeys.get(0));

        for (int i = 1; i < translationKeys.size(); i++) {
            keysInEveryTranslation.retainAll(translationKeys.get(i));
        }

        return primaryMsgs.keySet().stream()
                .filter(key -> !keysInEveryTranslation.contains(key))
                .collect(Collectors.toSet());
    }

    private SheetContent createTranslationSheet(
            Map<String, String> primaryMsgs,
            Map<String, Map<String, String>> translations,
            List<String> translationLangs,
            Set<String> newMsgKeys,
            Set<String> changedMsgKeys,
            Set<String> missingTransKeys,
            Map<String, Integer> msgKeyOrdering) {

        List<List<String>> populatedRows = missingTransKeys.stream()
                .map(key -> populateSheetRow(primaryMsgs, translations, translationLangs, key))
                .collect(Collectors.toList());

        Set<String> noUsableTranslations = new HashSet<>(newMsgKeys);
        noUsableTranslations.addAll(changedMsgKeys);

        List<List<String>> blankRows = noUsableTranslations.stream()
                .map(key -> {
                    String primaryMsg = primaryMsgs.get(key);
                    List<String> emptyCols = translationLangs.stream().filter(Objects::isNull).collect(Collectors.toList());
                    return createRow(key, primaryMsg, emptyCols);
                })
                .collect(Collectors.toList());

        List<List<String>> allRows = new ArrayList<>();
        allRows.addAll(blankRows);
        allRows.addAll(populatedRows);

        allRows.sort(Comparator.comparing(row -> msgKeyOrdering.get(row.get(0))));

        List<String> header = createSheetHeader(translationLangs);
        return new SheetContent(header, allRows);
    }

    private List<String> populateSheetRow(Map<String, String> primaryMsgs,
                                          Map<String, Map<String, String>> translations,
                                          List<String> translationLangs,
                                          String messageKey) {
        String primaryMsg = primaryMsgs.get(messageKey);
        List<String> translatedMsgs = translationLangs.stream()
                .map(lang -> {
                    Map<String, String> langMap = translations.get(lang);
                    return langMap != null ? langMap.get(messageKey) : null;
                }).collect(Collectors.toList());

        return primaryMsg != null ? createRow(messageKey, primaryMsg, translatedMsgs)
                : Collections.singletonList(messageKey);
    }

    private List<String> createRow(String msgKey, String primaryMsg, List<String> translations) {
        List<String> row = new ArrayList<>();
        row.add(msgKey);
        row.add(primaryMsg);
        row.addAll(translations);
        return row;
    }

    private List<String> createSheetHeader(List<String> targetLangs) {
        List<String> header = new ArrayList<>();
        header.add(SheetConstants.COL_KEY);
        header.add(SheetConstants.COL_PRIMARY);
        header.addAll(targetLangs);
        return header;
    }

    @Data
    public static class Pair<K, V> {
        public final K first;
        public final V second;
        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}