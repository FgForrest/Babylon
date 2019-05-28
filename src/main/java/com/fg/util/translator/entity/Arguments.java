package com.fg.util.translator.entity;

import lombok.Data;

/**
 * Crate for program arguments.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class Arguments {
    /**
     * FileName and relative path to the JSON configuration file.
     */
    private String configFileName;
    /**
     * Id of the target google sheet.
     */
    private String googleSheetId;
}
