package com.fg.util.babylon.statistics;

import com.fg.util.babylon.enums.Action;

import java.util.LinkedHashMap;

/**
 * Class for collecting and presenting statistics from {@link Action#IMPORT} processing.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class TranslationStatisticsOfImport extends TranslationStatisticsBase {

    /**
     * Statistics data for each processed file.
     */
    private LinkedHashMap<String, ImportFileStatistic> fileStatistics = new LinkedHashMap<>();

    public ImportFileStatistic putFileStatistic(String fileName, ImportFileStatistic exportFileStatistic) {
        return fileStatistics.put(fileName, exportFileStatistic);
    }

    public ImportFileStatistic getFileStatistic(String fileName) {
        return fileStatistics.get(fileName);
    }

    //TODO pouzit

    @Override
    public String toString() {
        return super.toString();
    }
}
