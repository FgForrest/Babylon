package one.edee.babylon.statistics;

import one.edee.babylon.enums.Action;
import lombok.Data;

/**
 * Statistics data for one processed file while {@link Action#IMPORT} action.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class ImportFileStatistic {

    @StatisticsField("Count of updated keys")
    private int updatedCnt;

    @StatisticsField("Count of keys not found in primary file")
    private int notFoundInPrimaryFile;

    public void incUpdatedCnt() {
        updatedCnt++;
    }

}
