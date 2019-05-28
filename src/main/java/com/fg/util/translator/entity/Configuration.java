package com.fg.util.translator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing translation configuration in json file.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class Configuration implements Serializable {

    private static final long serialVersionUID = -5822894615320804365L;

    /**
     * Name of the primary ChangeLog JSON (data file) with values of all keys for primary language mutation.
     */
    private String primaryDataFile;

    /**
     * List of all mutations to translate (e.g. CZ,EN,...).
     */
    private List<String> mutations = new ArrayList<>();

    /**
     * Properties files definitions.
     */
    private List<PropertiesFile> propertiesFiles = new ArrayList<>();

    public void addFile(PropertiesFile value) {
        propertiesFiles.add(value);
    }

}
