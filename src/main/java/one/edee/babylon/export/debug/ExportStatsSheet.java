package one.edee.babylon.export.debug;

import java.util.List;

public interface ExportStatsSheet {

    String getSheetName();

    List<String> getHeader();

    List<List<String>> getDataRows();

}
