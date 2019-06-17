package com.fg.util.babylon.statistics;

import com.fg.util.babylon.enums.Action;
import lombok.Data;

/**
 * Statistics data for one processed file while {@link Action#EXPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class ExportFileStatistic {

    @StatisticsField("Count of keys to update translation")
    private int keysToUpdateCnt;

    @StatisticsField("Count of new keys to translate")
    private int newKeysCnt;

    @StatisticsField("Count of keys with missing translation")
    private int missingKeysTranslationCnt;

    @StatisticsField("Count of all keys in file")
    private int totalKeysCnt;

    /**
     * Increment value of {@link ExportFileStatistic#getKeysToUpdateCnt()} by 1.
     */
    public void incKeysToUpdateCnt() {
        keysToUpdateCnt++;
    }

    /**
     * Increment value of {@link ExportFileStatistic#getNewKeysCnt()} by 1.
     */
    public void incNewKeysCnt() {
        newKeysCnt++;
    }

    /**
     * Increment value of {@link ExportFileStatistic#getMissingKeysTranslationCnt()} by 1.
     */
    public void incMissingKeysTranslationCnt() {
        missingKeysTranslationCnt++;
    }

    /**
     * Increment value of {@link ExportFileStatistic#getTotalKeysCnt()} by 1.
     */
    public void incTotalKeysCnt() {
        totalKeysCnt++;
    }
}
