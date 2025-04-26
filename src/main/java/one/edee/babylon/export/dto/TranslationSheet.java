package one.edee.babylon.export.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class TranslationSheet {

    private final String sheetName;
    private final List<List<String>> rows;
    private final Set<String> translatedHistorically;

    public List<List<String>> getDataRows() {
        return rows.subList(1, rows.size());
    }

    public int getDataRowCount() {
        return rows.size() - 1;
    }

}
