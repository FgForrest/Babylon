package one.edee.babylon.export;

import lombok.Data;
import one.edee.babylon.sheets.gsheets.model.ASheet;

import java.util.*;

@Data
public class FakeExporterSheetContractImpl implements Exporter.SheetContract {

    private final Map<String, List<ASheet>> sheets = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<ASheet> listSheets(String spreadsheetId) {
        return sheets.getOrDefault(spreadsheetId, Collections.emptyList());
    }

    @Override
    public void deleteSheets(String spreadsheetId, Collection<Integer> sheetIds) {
        if (spreadsheetId == null || !sheets.containsKey(spreadsheetId)) return;
        List<ASheet> filteredSheets = new ArrayList<>();
        for (ASheet sheet : sheets.get(spreadsheetId)) {
            if (!sheetIds.contains(sheet.getId())) {
                filteredSheets.add(sheet);
            }
        }
        sheets.put(spreadsheetId, filteredSheets);
    }

    @Override
    public void createSheet(
            String spreadsheetId,
            String sheetTitle,
            List<List<String>> sheetRows,
            List<String> lockedCellEditors,
            Map<String, List<String>> changed) {

        List<ASheet> currentSheets = new ArrayList<>(sheets.getOrDefault(spreadsheetId, new ArrayList<>()));
        currentSheets.add(new FakeSheet(getAndIncId()));
        sheets.put(spreadsheetId, currentSheets);
    }

    private int getAndIncId() {
        return nextId++;
    }

    // Inner class for fake sheet
    public static class FakeSheet implements ASheet {
        private final int sheetId;

        public FakeSheet(int sheetId) {
            this.sheetId = sheetId;
        }

        @Override
        public Integer getId() {
            return sheetId;
        }
    }
}