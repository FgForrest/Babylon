package one.edee.babylon.imp0rt;

import one.edee.babylon.entity.MessageFileContent;
import one.edee.babylon.imp0rt.legacy.MessageFileContentMessageWriter;
import one.edee.babylon.snapshot.Snapshot;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.GridData;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.extern.apachecommons.CommonsLog;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

@CommonsLog
public class ImportSheetProcessor {

    public void processSheet(Sheet sheet, Snapshot snapshot) throws IOException {
        String sheetTitle = sheet.getProperties().getTitle();
        log.info("Processing sheet \"" + sheetTitle + "\"...");
        Integer fileId = parseFileIdFromSheetTitle(sheetTitle);
        MessageWriter messageWriter = new MessageFileContentMessageWriter(getPropFileById(fileId, snapshot));

        List<GridData> sheetData = sheet.getData();
        if (sheetData == null || sheetData.isEmpty()) {
            log.warn("Sheet " + sheetTitle + " not contains any data in grid.");
            return;
        }
        for (GridData gridData : sheetData) {
            processGridDataOfSheet(sheetTitle, gridData, messageWriter);
        }
    }

    /**
     * Gets {@link MessageFileContent} object for one properties file by your unique id in json DataFile.
     * @param fileId unique file ID
     * @return Found {@link MessageFileContent} object or null if not found.
     */
    private MessageFileContent getPropFileById(Integer fileId, Snapshot snapshot) {
        MessageFileContent propFile = snapshot.getPropFileById(fileId);
        if (propFile == null) {
            String msg = "No record found by id='" + fileId + "' in DB file";
            throw new IllegalArgumentException(msg);
        }
        return propFile;
    }

    private void processGridDataOfSheet(String sheetTitle, GridData gridData, MessageWriter messageWriter) throws IOException {
        List<RowData> rowsData = gridData.getRowData();
        if (rowsData == null) {
            log.warn("Sheet \"" + sheetTitle + " \" is empty");
            return;
        }
        // First row is header
        Map<Integer,String> header = createHeader(rowsData.get(0));
        for (RowData rowData : rowsData.subList(1, rowsData.size())) {
            if (rowData.getValues().stream().anyMatch(i-> i.getFormattedValue() != null && !Objects.equals(i.getFormattedValue(), "null"))){
                processRowData(header, rowData, messageWriter);
            }
        }
    }

    private Map<Integer,String> createHeader(RowData headerData) {
        int col = 0;
        Map<Integer,String> header = new LinkedHashMap<>();
        for (CellData cellData : headerData.getValues()) {
            String cellValue = cellData.getFormattedValue();
            header.put(col++, cellValue);
        }
        return header;
    }

    /**
     * Processes data of the one row in google sheet.
     * @param header header values with column numbers as keys
     * @param rowData data of the one row
     * @throws IOException some exception derived from {@link IOException}
     */
    private void processRowData(Map<Integer,String> header, RowData rowData, MessageWriter messageWriter) {
        int col = 0;
        List<CellData> values = rowData.getValues();
        String propKey = "";
        for (CellData cellData : values) {
            String colTitle = header.get(col);
            String propValue = cellData.getFormattedValue();

            if (col == 0) {
                // First column contains properties keys.
                propKey = propValue;
            } else if (col == 1) {
                // Second column contains text value of primary mutation.
                messageWriter.storePrimaryMessage(propKey, propValue);
            } else {
                // Next columns contains text values of secondary mutations. Column title contains name of the mutation.
                messageWriter.storeTranslation(colTitle, propKey, propValue);
            }
            col++;
        }
    }

    /**
     * Parse unique id of the target properties file from sheet title (title format is "FileName" + "#" + "UniqueId")
     * @param sheetTitle title of the sheet.
     * @return File ID parsed from sheet title.
     */
    private Integer parseFileIdFromSheetTitle(String sheetTitle) {
        try {
            String[] split = sheetTitle.split("#");
            if (split.length != 2) {
                throw new IllegalArgumentException("Cannot parse unique id from string \"" + sheetTitle + "\"");
            }
            return Integer.parseInt(split[1]);
        } catch (PatternSyntaxException | NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
