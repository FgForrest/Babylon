package com.fg.util.babylon.export.data;

import lombok.Data;

import java.util.List;

@Data
public class TranslationSheet {

    private final String sheetName;
    private final List<List<String>> rows;

    public List<List<String>> getDataRows() {
        return rows.subList(1, rows.size());
    }

}
