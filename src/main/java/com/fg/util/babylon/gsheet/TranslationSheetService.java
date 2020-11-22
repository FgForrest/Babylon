package com.fg.util.babylon.gsheet;

import com.fg.util.babylon.SheetConstants;
import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.MessageFileContent;
import com.fg.util.babylon.entity.PropertiesMap;
import com.fg.util.babylon.entity.SheetParams;
import com.fg.util.babylon.enums.PropertyStatus;
import com.fg.util.babylon.exception.SheetExistsException;
import com.fg.util.babylon.service.GoogleSheetApi;
import com.fg.util.babylon.util.SheetUtils;
import com.google.api.services.sheets.v4.model.DimensionRange;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@CommonsLog
public class TranslationSheetService {

    private final GoogleSheetApi googleSheetApi;

    public final String googleSheetId;

    public TranslationSheetService(GoogleSheetApi googleSheetApi, String googleSheetId) {
        this.googleSheetApi = googleSheetApi;
        this.googleSheetId = googleSheetId;
    }

    /**
     * Uploads data {@link DataFileManager#getOrCreateDataFile()} into google spreadsheet specified by {@link Arguments#getGoogleSheetId()}.
     *
     * @throws GeneralSecurityException when authentication to Google sheets API problem is appeared.
     * @throws IOException              some exception derived from {@link IOException}
     */
    public void uploadDataToGoogleSpreadsheet(DataFileManager dataFileManager, List<String> changedMessageFilePaths, List<String> translationLangs) throws GeneralSecurityException, IOException {
        Map<String, MessageFileContent> messageBundle = dataFileManager.getOrCreateDataFile().getDataPropFiles();
        // FIXME: It would be more efficient to iterate over the identifiers of the List and look them up in the Map
        Map<String, MessageFileContent> changedMessages = messageBundle
                .entrySet()
                .stream()
                .filter(i -> changedMessageFilePaths.contains(i.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        doUploadDataToGoogleSpreadsheet(changedMessages, changedMessageFilePaths, translationLangs);
    }

    private void doUploadDataToGoogleSpreadsheet(Map<String, MessageFileContent> changedMessages, List<String> changedMessageFilePaths, List<String> translationLangs) throws GeneralSecurityException, IOException {
        // FIXME: why atomic?
        AtomicInteger processedCount = new AtomicInteger(0);
        // Gets all sheets existing at this moment.
        List<Sheet> prevAllSheets = googleSheetApi.getAllSheets(googleSheetId);
        for (Map.Entry<String, MessageFileContent> entry : changedMessages.entrySet()) {
            String fileNamePath = entry.getKey();
            MessageFileContent messageFileContent = entry.getValue();

            uploadDataToGoogleSheet(messageFileContent, fileNamePath, processedCount, translationLangs);
        }
        // Delete all previously existing sheets (usually default "Sheet 1" of new empty spreadsheet) if
        // current sheets count is greater then previous.
        List<Sheet> currAllSheets = googleSheetApi.getAllSheets(googleSheetId);
        if (currAllSheets.size() > prevAllSheets.size()) {
            googleSheetApi.deleteSheets(googleSheetId, prevAllSheets);
        }
    }

    private void uploadDataToGoogleSheet(MessageFileContent messageFileContent, String fileNamePath, AtomicInteger processedCount, List<String> translationLangs) throws IOException, GeneralSecurityException {
        // Add header into sheet
        List<List<Object>> sheetRows = new LinkedList<>(createSheetHeader(translationLangs));
        // Add data into sheet
        List<List<Object>> sheetData = createSheetData(messageFileContent, translationLangs);

        // If no data to upload return
        if (sheetData.isEmpty()) {
            log.info("No changed data for primary properties file and its mutation files: " + fileNamePath);
            return;
        }

        pauseProcessIfGoogleLimitExceed(sheetData.size(), processedCount);

        // Title of target google sheet is created from "properties fileName only" + "#" + "fileName id".
        String sheetTitle = new SheetUtils().getSheetName(fileNamePath, messageFileContent);
        log.info("Uploading data of \"" + fileNamePath + "\" into google sheet \"" + sheetTitle + "\"...");
        sheetRows.addAll(sheetData);
        Sheet sheet = createGoogleSheet(sheetRows, sheetTitle);
        if (sheet != null) {
            throw new SheetExistsException("Sheet \"" + sheetTitle + "\" already exists!");
        }

        googleSheetApi.writeDataIntoSheet(googleSheetId, sheetTitle, sheetRows);
        sheet = googleSheetApi.getSheet(googleSheetId, sheetTitle);
        googleSheetApi.setWrappingStrategy(googleSheetId, sheet.getProperties().getSheetId());
        googleSheetApi.resizeAllColumns(googleSheetId, sheet.getProperties().getSheetId());
        googleSheetApi.protectFirstColumns(googleSheetId, sheet.getProperties().getSheetId());
        hideSheetFirstColumn(sheet.getProperties().getSheetId());
    }

    private Sheet createGoogleSheet(List<List<Object>> sheetRows, String sheetTitle) throws GeneralSecurityException, IOException {
        Integer columnCount = sheetRows.get(0).size();
        Integer rowCount = sheetRows.size();
        SheetParams sheetParams = new SheetParams(sheetTitle, columnCount, rowCount);
        // Freezes first row (header) to prevent scrolling of this row with rest of data.
        if (rowCount > 1) {
            sheetParams.setFrozenRowCount(1);
            sheetParams.setFrozenColumnCount(2);
        }
        return googleSheetApi.addSheet(googleSheetId, sheetParams);
    }

    private void pauseProcessIfGoogleLimitExceed(int size, AtomicInteger processedCount) {
        // This sleep is cause of google limit where user cannot have more than 500 request in less than 100 secs
        // *2 is for updating styles :(
        int count = processedCount.addAndGet(size);
        // 300 is minus average keys that updates as frozen and protected cols
        if (count > 300) {
            try {
                log.info("Google has it's limits I have to go to bed for about two minutes, so sorry :( .");
                Thread.sleep(120 * 1000L);
                processedCount.set(0);
            } catch (Exception e) {
                // do nothing
            }
        }
    }

    private List<List<Object>> createSheetHeader(List<String> translationLangs) {
        List<List<Object>> sheetHeader = new LinkedList<>();
        List<Object> headerValues = new LinkedList<>(Arrays.asList(SheetConstants.COL_KEY, SheetConstants.COL_PRIMARY));
        headerValues.addAll(translationLangs);
        sheetHeader.add(headerValues);
        return sheetHeader;
    }

    private List<List<Object>> createSheetData(MessageFileContent messageFileContent, List<String> translationLangs) {
        List<List<Object>> sheetData = new LinkedList<>();
        for (Map.Entry<String, String> entry : messageFileContent.getProperties().entrySet()) {
            // Add row only if status != UNCHANGED
            PropertyStatus propertyStatus = messageFileContent.getPropertyStatus(entry.getKey());
            if (propertyStatus == PropertyStatus.UNCHANGED) {
                continue;
            }
            // Replace doubled quotes in case of variable in property
            String entryValue = entry.getValue();
            if (entryValue.matches(".*\\{.}.*")) {
                entryValue = entryValue.replace("''", "'");
            }

            // Add key name and primary mutation value
            List<Object> rowValues = new LinkedList<>(Arrays.asList(entry.getKey(), entryValue));
            // Add all secondary mutations values
            for (String mutation : translationLangs) {
                PropertiesMap mutationsPropsMap = messageFileContent.getMutationProperties(mutation);
                if (mutationsPropsMap == null) {
                    mutationsPropsMap = new PropertiesMap();
                    messageFileContent.putMutationProperties(mutation, mutationsPropsMap);
                }
                String mutationValue = mutationsPropsMap.get(entry.getKey());
                // Replace doubled quotes in case of variable in property
                if (mutationValue != null && mutationValue.matches(".*\\{.}.*")) {
                    mutationValue = mutationValue.replace("''", "'");
                }

                rowValues.add(mutationValue);
            }
            sheetData.add(rowValues);
        }
        return sheetData;
    }

    /**
     * Hiding of first column which contains properties keys, because it's not important for workers in translation agency.
     *
     * @param sheetId ID of the target sheet
     * @throws IOException              some exception derived from {@link IOException}
     * @throws GeneralSecurityException when authentication to Google sheets API problem is appeared.
     */
    private void hideSheetFirstColumn(Integer sheetId) throws IOException, GeneralSecurityException {
        DimensionRange dimensionRange = new DimensionRange()
                .setSheetId(sheetId)
                .setDimension("COLUMNS")
                .setStartIndex(0)
                .setEndIndex(1);
        googleSheetApi.hideDimensionRange(googleSheetId, dimensionRange);
    }

}
