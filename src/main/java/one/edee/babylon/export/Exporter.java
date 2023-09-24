package one.edee.babylon.export;

import one.edee.babylon.db.SnapshotUtils;
import one.edee.babylon.export.dto.ExportResult;
import one.edee.babylon.export.dto.TranslationSheet;
import one.edee.babylon.sheets.gsheets.model.ASheet;
import one.edee.babylon.snapshot.TranslationSnapshotWriteContract;
import one.edee.babylon.util.AntPathResourceLoader;
import one.edee.babylon.sheets.SheetsException;
import one.edee.babylon.util.PathUtils;
import lombok.extern.apachecommons.CommonsLog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Performs the export phase that generates translation sheets.
 */
@CommonsLog
public class Exporter {
    private static final String COMBINING_SHEET_NAME = "ALL";


    private final TranslationCollector translationCollector;
    private final TranslationSnapshotWriteContract snapshot;
    private final SheetContract gsc;
    private final AntPathResourceLoader resourceLoader;
    private final PathUtils pu;

    public Exporter(TranslationCollector translationCollector, TranslationSnapshotWriteContract snapshot, SheetContract gsc, AntPathResourceLoader resourceLoader) {
        this.translationCollector = translationCollector;
        this.snapshot = snapshot;
        this.gsc = gsc;
        this.resourceLoader = resourceLoader;
        this.pu = new PathUtils();
    }

    /**
     * Walks message file paths, gathering messages and translations, producing translation sheets in given GSheet spreadsheet.
     *
     * @param patternPaths paths of message files to export
     * @param translationLangs languages to translate messages to
     * @param spreadsheetId id of GSheets spreadsheet, must be empty
     * @param snapshotPath path to the translation snapshot file
     */
    public void walkPathsAndWriteSheets(List<String> patternPaths,
                                        List<String> translationLangs,
                                        String spreadsheetId,
                                        Path snapshotPath,
                                        boolean combineSheets ) {
        walkPathsAndWriteSheets(patternPaths, translationLangs, spreadsheetId, snapshotPath, Collections.emptyList(), combineSheets);
    }

    /**
     * Walks message file paths, gathering messages and translations, producing translation sheets in given GSheet spreadsheet.
     *
     * @param patternPaths paths of message files to export
     * @param translationLangs languages to translate messages to
     * @param spreadsheetId id of GSheets spreadsheet, must be empty
     * @param snapshotPath path to the translation snapshot file
     * @param lockedCellEditors list of Google account emails, these account will have the permission to edit locked cells
     */
    public void walkPathsAndWriteSheets(List<String> patternPaths,
                                        List<String> translationLangs,
                                        String spreadsheetId,
                                        Path snapshotPath,
                                        List<String> lockedCellEditors,
                                        boolean combineSheets) {
        warnDuplicatePaths(patternPaths);

        List<ASheet> prevSheets = listAllSheets(spreadsheetId);

        Collection<String> allUniquePaths = expandsToUniquePaths(patternPaths);
        boolean pathsOk = checkPathsExist(allUniquePaths);
        if (!pathsOk) {
            throw new IllegalArgumentException("Please fix the message file paths in the configuration file.");
        }

        ExportResult result = translationCollector.walkPathsAndCollectTranslationSheets(allUniquePaths, translationLangs);

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

        uploadTranslations(result, spreadsheetId, lockedCellEditors);

        updateSnapshotAndWriteToDisk(this.snapshot, result, snapshotPath);

        List<Integer> prevSheetIds = prevSheets.stream().map(ASheet::getId).collect(Collectors.toList());
        deleteOldSheets(prevSheetIds, spreadsheetId);
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

    private void uploadTranslations(ExportResult exportResult, String spreadsheetId, List<String> lockedCellEditors) {
        exportResult.getSheets().stream()
                .filter(sheet -> !sheet.getDataRows().isEmpty())
                .forEach(sheet -> {
                    try {
                        log.info("Writing " + sheet.getDataRows().size() + " rows into sheet '" + sheet.getSheetName() + "'.");
                        gsc.createSheet(spreadsheetId, sheet.getSheetName(), sheet.getRows(), lockedCellEditors);
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
         * @throws SheetsException when unable to upload sheets
         */
        void createSheet(String spreadsheetId, String sheetTitle, List<List<String>> sheetRows, List<String> lockedCellEditors) throws SheetsException;

    }

}
