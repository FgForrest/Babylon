package com.fg.util.babylon.entity;

import com.fg.util.babylon.enums.Action;
import lombok.Data;

/**
 * Crate for program arguments.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class Arguments {

    /**
     * See {@link Action}
     */
    private Action action;

    /**
     * FileName and relative path to the Json configuration file.
     */
    private String configFileName;

    /**
     * Id of the target google spreadsheet.
     */
    private String googleSheetId;
}
