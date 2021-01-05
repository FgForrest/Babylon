package one.edee.babylon.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Crate class for transport of the sheet parameters.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@RequiredArgsConstructor
public class SheetParams {

    /** Name of the sheet. */
    @NonNull
    private String sheetTitle;

    /** Column count to be created */
    @NonNull
    private Integer columnCount;

    /** Row count to be created */
    @NonNull
    private Integer rowCount;

    private Integer frozenRowCount;
    private Integer frozenColumnCount;

}
