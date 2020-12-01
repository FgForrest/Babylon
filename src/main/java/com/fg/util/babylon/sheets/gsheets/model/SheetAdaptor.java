package com.fg.util.babylon.sheets.gsheets.model;

/**
 * Implements {@link ASheet} with {@link com.google.api.services.sheets.v4.model.Sheet} from Google Sheets client library.
 */
public class SheetAdaptor implements ASheet {

    private final com.google.api.services.sheets.v4.model.Sheet sheet;

    public SheetAdaptor(com.google.api.services.sheets.v4.model.Sheet sheet) {
        this.sheet = sheet;
    }

    @Override
    public Integer getId() {
        return sheet.getProperties().getSheetId();
    }

}
