package com.fg.util.babylon.statistics;

import com.fg.util.babylon.enums.Action;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.apachecommons.CommonsLog;

import java.util.LinkedHashMap;

/**
 * Class for collecting and presenting statistics from {@link Action#EXPORT} processing.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@EqualsAndHashCode(callSuper = true)
@CommonsLog
public class TranslationStatisticsOfExport extends TranslationStatisticsBase {

    @StatisticsField("Total primary properties files processed")
    private int primaryPropFilesProcessed;

    @StatisticsField("Total properties files processed")
    private int totalPropFilesProcessed;

    @StatisticsField("Count of all new keys to translate")
    private int totalNewKeysCnt;

    @StatisticsField("Count of all keys to update translation")
    private int totalKeysToUpdateCnt;

    @StatisticsField("Count of all keys with missing translation")
    private int totalMissingKeysTranslationCnt;

    /**
     * Statistics data for each processed file.
     */
    private LinkedHashMap<String, ExportFileStatistic> fileStatistics = new LinkedHashMap<>();

    /**
     * Increment value of {@link TranslationStatisticsOfExport#getPrimaryPropFilesProcessed()} by inc value.
     * @param inc increment value
     */
    public void incPrimaryPropFilesProcessed(int inc) {
        primaryPropFilesProcessed += inc;
    }

    /**
     * Increment value of {@link TranslationStatisticsOfExport#getTotalPropFilesProcessed()} by inc value.
     */
    public void incTotalPropFilesProcessed() {
        totalPropFilesProcessed++;
    }

    public void incTotalNewKeysCnt() {
        totalNewKeysCnt++;
    }

    public void incTotalKeysToUpdateCnt() {
        totalKeysToUpdateCnt++;
    }

    public void incTotalMissingKeysTranslationCnt() {
        totalMissingKeysTranslationCnt++;
    }

    public ExportFileStatistic putFileStatistic(String fileName, ExportFileStatistic exportFileStatistic) {
        return fileStatistics.put(fileName, exportFileStatistic);
    }

    public ExportFileStatistic getFileStatistic(String fileName) {
        return fileStatistics.get(fileName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
