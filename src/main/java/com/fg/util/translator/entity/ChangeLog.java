package com.fg.util.translator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing translation change log (data file) in json file.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class ChangeLog implements Serializable {

    private static final long serialVersionUID = 4891061639828627492L;

    /**
     * Properties files records.
     */
    private List<PropertiesFileLog> propFilesLogs = new ArrayList<>();

    private void addPropertiesFile(PropertiesFileLog propFileLog) {
        propFilesLogs.add(propFileLog);
    }

}
