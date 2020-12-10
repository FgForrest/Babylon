package com.fg.util.babylon.export.debug;

import java.util.List;

public interface ExportStatsSheet {

    String getSheetName();

    List<String> getHeader();

    List<List<String>> getDataRows();

}
