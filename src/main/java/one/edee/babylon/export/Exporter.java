package one.edee.babylon.export;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import one.edee.babylon.config.SupportedTranslators;
import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.db.SnapshotUtils;
import one.edee.babylon.export.dto.ExportResult;
import one.edee.babylon.export.dto.TranslationSheet;
import one.edee.babylon.export.translator.Translator;
import one.edee.babylon.sheets.SheetsException;
import one.edee.babylon.sheets.gsheets.model.ASheet;
import one.edee.babylon.snapshot.TranslationSnapshotWriteContract;
import one.edee.babylon.util.AntPathResourceLoader;
import one.edee.babylon.util.PathUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Performs the export phase that generates translation sheets.
 */
@CommonsLog
@RequiredArgsConstructor
public class Exporter {
    private static final String COMBINING_SHEET_NAME = "ALL";


    private final ApplicationContext applicationContext;
    private final TranslationCollector translationCollector;
    private final TranslationSnapshotWriteContract snapshot;
    private final SheetContract gsc;
    private final AntPathResourceLoader resourceLoader;
    private final PathUtils pu = new PathUtils();


    /**
     * Walks message file paths, gathering messages and translations, producing translation sheets in given GSheet spreadsheet.
     *
     * @param configuration     configuration of translation run
     * @param spreadsheetId     id of GSheets spreadsheet, must be empty
     */
    public void walkPathsAndWriteSheets(TranslationConfiguration configuration,
                                        String spreadsheetId,
                                        boolean combineSheets) {
        List<String> patternPaths = configuration.getPath();
        warnDuplicatePaths(patternPaths);

        List<ASheet> prevSheets = listAllSheets(spreadsheetId);

        Collection<String> allUniquePaths = expandsToUniquePaths(patternPaths);
        boolean pathsOk = checkPathsExist(allUniquePaths);
        if (!pathsOk) {
            throw new IllegalArgumentException("Please fix the message file paths in the configuration file.");
        }

        ExportResult result = translationCollector.walkPathsAndCollectTranslationSheets(allUniquePaths, configuration.getMutations());

        if (combineSheets) {
            // only for translation debugging
            List<TranslationSheet> original = result.getSheets();
            List<TranslationSheet> sheets = new ArrayList<>(original);
            original.clear();

            List<List<String>> combine = new LinkedList<>();
            for (int i = 0; i < sheets.size(); i++) {
                TranslationSheet sheet = sheets.get(i);
                List<List<String>> rows = sheet.getRows();
                if (i != 0){
                    rows.remove(0);
                }
                combine.addAll(rows);
            }

            original.add(new TranslationSheet(COMBINING_SHEET_NAME,combine));
        }

        Map<String, List<String>> changed = translateTextsByExternalTool(configuration, result);

        uploadTranslations(result, spreadsheetId, configuration.getLockedCellEditors(), changed);

        updateSnapshotAndWriteToDisk(this.snapshot, result, configuration.getSnapshotPath());

        List<Integer> prevSheetIds = prevSheets.stream().map(ASheet::getId).collect(Collectors.toList());
        deleteOldSheets(prevSheetIds, spreadsheetId);
    }

    @NotNull
    private Map<String, List<String>> translateTextsByExternalTool(TranslationConfiguration configuration, ExportResult result) {
        Map<String, List<String>> changed = new HashMap<>();

        if (configuration.getTranslatorApiKey() != null) {
            SupportedTranslators translatorType = ofNullable(configuration.getTranslator()).orElse(SupportedTranslators.GOOGLE);

            Translator translator = applicationContext.getBeansOfType(Translator.class)
                    .values()
                    .stream()
                    .filter(i -> i.getSupportedTranslator().equals(translatorType))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Cannot find translator bean for type" + translatorType));
            translator.init(configuration.getTranslatorApiKey());

            try {
                for (TranslationSheet sheet : result.getSheets()) {

                    List<List<String>> rows = sheet.getRows();
                    if (rows.size() == 1)
                        continue;

                    log.info("Translating sheet " + sheet.getSheetName());
                    List<String> header = rows.get(0);
                    List<String> originals = rows.stream().map(i->i.get(1)).map(i->StringUtils.hasText(i) ? i : "____DUMMY").collect(Collectors.toList());
                    Map<String, List<String>> translations = new HashMap<>();

                    for (String lang : header.stream().skip(2).collect(Collectors.toList())) {
                        translations.put(lang, translator.translate(configuration.getDefaultLang(), originals, lang));
                    }

                    for (int i = 1; i < rows.size(); i++) {
                        Map<Integer, String> toChange = new HashMap<>();

                        List<String> cells = rows.get(i);
                        String original = cells.get(1);
                        for (int l = 2; l < cells.size(); l++) {
                            if (StringUtils.isEmpty(cells.get(l))) {

                                String lang = header.get(l);

                                if (StringUtils.hasText(original)) {
                                    String transOriginal = originals.get(i);
                                    if (!Objects.equals(original, "____DUMMY")){
                                        Assert.isTrue(Objects.equals(transOriginal, original), "Originals does not equals!");
                                        String translatedText = translations.get(lang).get(i);
                                        toChange.put(l, translatedText);

                                        changed
                                                .computeIfAbsent(sheet.getSheetName(), key -> new LinkedList<>())
                                                .add(i + "_" + l);
                                    }
                                }
                            }
                        }

                        for (Entry<Integer, String> entry : toChange.entrySet()) {
                            cells.remove((int) entry.getKey());
                            cells.add(entry.getKey(), entry.getValue());
                        }

                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return changed;
    }

    private void warnDuplicatePaths(List<String> patternPaths) {
        List<String> duplicatePaths = detectDuplicatePatternPaths(patternPaths);
        if (!duplicatePaths.isEmpty()) {
            log.warn("Detected duplicate message file paths in configuration file:");
            duplicatePaths.forEach(dup -> log.warn("'" + dup + "' is defined more than once."));
        }
    }

    private List<String> detectDuplicatePatternPaths(List<String> patternPaths) {
        return patternPaths.stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .map(Entry::getKey)
                .collect(Collectors.toList());
    }

    private Collection<String> expandsToUniquePaths(List<String> patternPaths) {
        return patternPaths.stream()
                .map(this::expandPath)
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private List<String> expandPath(String patternPath) {
        try {
            return pu.expandPath(patternPath, resourceLoader);
        } catch (IOException e) {
            throw new RuntimeException("Error when expanding path '" + patternPath + "'", e);
        }
    }

    private boolean checkPathsExist(Collection<String> paths) {
        boolean pathsOk = true;
        for (String path : paths) {
            if (!new File(path).exists()) {
                log.error("File '" + path + "' could not be found.");
                pathsOk = false;
            }
        }
        return pathsOk;
    }

    private List<ASheet> listAllSheets(String spreadsheetId) {
        try {
            return gsc.listSheets(spreadsheetId);
        } catch (SheetsException e) {
            String errMsg = "Error when listing sheets of spreadsheet '" + spreadsheetId + "'";
            throw new RuntimeException(errMsg, e);
        }
    }

    private void uploadTranslations(ExportResult exportResult, String spreadsheetId, List<String> lockedCellEditors, Map<String, List<String>> changed) {
        exportResult.getSheets().stream()
                .filter(sheet -> !sheet.getDataRows().isEmpty())
                .forEach(sheet -> {
                    try {
                        log.info("Writing " + sheet.getDataRows().size() + " rows into sheet '" + sheet.getSheetName() + "'.");
                        gsc.createSheet(spreadsheetId, sheet.getSheetName(), sheet.getRows(), lockedCellEditors, changed);
                    } catch (SheetsException e) {
                        String errMsg = "Error when uploading data to spreadsheet '" + spreadsheetId + "'";
                        throw new RuntimeException(errMsg, e);
                    }
                });
    }

    private void updateSnapshotAndWriteToDisk(TranslationSnapshotWriteContract snapshot, ExportResult exportResult, Path snapshotFile) {
        try {
            Iterable<String> newMsgFiles = exportResult.getPathsOfNewMsgFiles();
            newMsgFiles.forEach(snapshot::registerMsgFile);
            File snapshotFileName = snapshotFile.toFile();
            SnapshotUtils.writeSnapshot(snapshot.getUnderlyingSnapshot(), snapshotFileName);
        } catch (IOException e) {
            String errMsg = "Error when updating translation snapshot '" + snapshotFile + "' with new message file paths.";
            throw new RuntimeException(errMsg, e);
        }
    }

    private void deleteOldSheets(Collection<Integer> sheetIds, String spreadsheetId) {
        try {
            gsc.deleteSheets(spreadsheetId, sheetIds);
        } catch (SheetsException e) {
            String errMsg = "Error when deleting sheets '" + sheetIds + "'";
            throw new RuntimeException(errMsg, e);
        }
    }

    /**
     * Defines sheet operations required by {@link Exporter}.
     */
    public interface SheetContract {

        /**
         * Lists all sheets of spreadsheet {@code spreadsheetId}. Does not fetch actual cells of the sheets.
         *
         * @param spreadsheetId id of spreadsheet
         * @return sheets from {@code spreadsheetId}
         * @throws SheetsException when unable to list sheets
         */
        List<ASheet> listSheets(String spreadsheetId) throws SheetsException;

        /**
         * Deletes specified sheets from given spreadsheet.
         *
         * @param spreadsheetId spreadsheet to delete sheets from
         * @param sheetIds      ids of sheets to delete
         * @throws SheetsException when unable to delete sheets
         */
        void deleteSheets(String spreadsheetId, Collection<Integer> sheetIds) throws SheetsException;

        /**
         * Creates a new sheet a fills it with provided data.
         *
         * @param spreadsheetId     id of spreadsheet where new sheet should be created
         * @param sheetTitle        name to use for the new sheet
         * @param sheetRows         rows with data cells to fill the sheet with
         * @param lockedCellEditors list of email accounts that will be able to edit locked cells
         * @param changed
         * @throws SheetsException when unable to upload sheets
         */
        void createSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows, List<String> lockedCellEditors, Map<String, List<String>> changed) throws SheetsException;

    }


}
