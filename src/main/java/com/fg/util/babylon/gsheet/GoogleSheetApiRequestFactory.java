package com.fg.util.babylon.gsheet;

import com.google.api.services.sheets.v4.model.*;

import java.util.List;

public class GoogleSheetApiRequestFactory {

    public Request addSheet(String newSheetTitle,
                                    Integer rowCount, Integer colCount,
                                    Integer rowsToFreeze, Integer colsToFreeze) {
        return new Request()
                .setAddSheet(doAddSheet(newSheetTitle, rowCount, colCount, rowsToFreeze, colsToFreeze));
    }

    //TODO: neresim, co se ma stat, pokud uz existuje sheet
    private AddSheetRequest doAddSheet(String newSheetTitle,
                                       Integer rowCount, Integer colCount,
                                       Integer rowsToFreeze, Integer colsToFreeze) {

        GridProperties gridProperties = new GridProperties()
                .setRowCount(rowCount)
                .setColumnCount(colCount)
                .setFrozenRowCount(rowsToFreeze)
                .setFrozenColumnCount(colsToFreeze);

        SheetProperties sheetProperties = new SheetProperties()
                .setTitle(newSheetTitle)
                .setGridProperties(gridProperties);

        return new AddSheetRequest()
                .setProperties(sheetProperties);
    }

    public Request setWrapWrappingStrategyForAllCells(Integer sheetId) {
        return new Request()
                .setRepeatCell(wrappingStrategyCellUpdate(allCellsRange(sheetId)));
    }

    private RepeatCellRequest wrappingStrategyCellUpdate(GridRange gridRange) {
        return new RepeatCellRequest()
                .setFields("userEnteredFormat.wrapStrategy")
                .setCell(new CellData()
                        .setUserEnteredFormat(new CellFormat()
                                .setWrapStrategy("WRAP")))
                .setRange(gridRange);
    }

    private GridRange allCellsRange(Integer sheetId) {
        return new GridRange()
                .setSheetId(sheetId)
                .setStartRowIndex(0)
                .setStartColumnIndex(0);
    }

    /**
     * Resizes all columns in given sheet
     *
     * @param sheetId   id of the sheet
     * @param pixelSize size of pixels to resize columns to
     * @return API request
     */

    public Request resizeAllColumns(Integer sheetId, Integer pixelSize) {
        return new Request()
                .setUpdateDimensionProperties(
                        resizeDimension(allColumns(sheetId), pixelSize));
    }

    private UpdateDimensionPropertiesRequest resizeDimension(DimensionRange dimensionRange, Integer pixelSize) {
        return new UpdateDimensionPropertiesRequest()
                .setRange(dimensionRange)
                .setFields("pixelSize")
                .setProperties(new DimensionProperties()
                        .setPixelSize(pixelSize));
    }

    public Request hideFirstColumn(Integer sheetId) {
        return new Request()
                .setUpdateDimensionProperties(
                        hideDimension(firstColumn(sheetId)));
    }

    private UpdateDimensionPropertiesRequest hideDimension(DimensionRange dimensionRange) {
        return new UpdateDimensionPropertiesRequest()
                .setRange(dimensionRange)
                .setFields("hiddenByUser")
                .setProperties(new DimensionProperties()
                        .setHiddenByUser(Boolean.TRUE));
    }

    private static final String DIMENSION_RANGE__DIMENSION__COLUMNS = "COLUMNS";

    private DimensionRange allColumns(Integer sheetId) {
        return new DimensionRange()
                .setSheetId(sheetId)
                .setDimension(DIMENSION_RANGE__DIMENSION__COLUMNS);
    }

    private DimensionRange firstColumn(Integer sheetId) {
        return new DimensionRange()
                .setSheetId(sheetId)
                .setDimension(DIMENSION_RANGE__DIMENSION__COLUMNS)
                .setStartIndex(0)
                .setEndIndex(1);
    }

    public Request protectCellsInFirstTwoColumns(Integer sheetId, List<String> lockedCellEditors) {
        return new Request()
                .setAddProtectedRange(
                        protectCells(firstTwoColsCellsRange(sheetId), lockedCellEditors));
    }

    private AddProtectedRangeRequest protectCells(GridRange gridRange, List<String> lockedCellEditors) {
        return new AddProtectedRangeRequest()
                .setProtectedRange(lockCells(gridRange, lockedCellEditors));
    }

    /**
     * @param gridRange      range of cells to lock
     * @param editorAccounts accounts allowed to edit locked cells
     */
    private ProtectedRange lockCells(GridRange gridRange, List<String> editorAccounts) {
        return new ProtectedRange()
                .setRange(gridRange)
                .setRequestingUserCanEdit(false)
                .setWarningOnly(false)
                .setEditors(new Editors()
                        .setUsers(editorAccounts));
    }

    private GridRange firstTwoColsCellsRange(Integer sheetId) {
        return new GridRange()
                .setSheetId(sheetId)
                .setStartColumnIndex(0)
                .setEndColumnIndex(2)
                .setStartRowIndex(0);
    }

}
