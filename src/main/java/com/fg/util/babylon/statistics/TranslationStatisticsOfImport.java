package com.fg.util.babylon.statistics;

import com.fg.util.babylon.enums.Action;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;

/**
 * Class for collecting and presenting statistics from {@link Action#IMPORT} processing.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TranslationStatisticsOfImport extends TranslationStatisticsBase {

    @StatisticsField("Action")
    private Action action;

    @StatisticsField("Total updated keys")
    private int totalUpdatedCnt;

    @StatisticsField("Total keys not found in primary file")
    private int totalNotFoundInPrimaryFile;

    public void incTotalUpdatedCnt() {
        totalUpdatedCnt++;
    }

    public void incTotalNotFoundInPrimaryFile(int inc) {
        totalNotFoundInPrimaryFile += inc;
    }

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

    @Override
    public String toString() {
        return super.toString();
    }
}
