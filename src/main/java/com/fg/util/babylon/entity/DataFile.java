package com.fg.util.babylon.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Class representing translation data file (changelog) in json file. This data file keeps information about processing
 * of language properties files by given {@link Configuration}.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class DataFile implements Serializable {

    private static final long serialVersionUID = 4891061639828627492L;

    /**
     * Properties files data like {@link Map<String, DataPropFile>}<br>
     * key - contains name and relative path to primary language properties file<br>
     * value - contains {@link DataPropFile}
     */
    private Map<String, DataPropFile> dataPropFiles = new LinkedHashMap<>();

    public DataPropFile putPropFile(String fileName, DataPropFile dataPropFile) {
        return dataPropFiles.put(fileName, dataPropFile);
    }

    public DataPropFile getOrPutNewDataPropFile(String fileName) {
        DataPropFile dataPropFile = dataPropFiles.get(fileName);
        if (dataPropFile == null) {
            dataPropFile = new DataPropFile();
            dataPropFiles.put(fileName, dataPropFile);
        }
        return dataPropFile;
    }

}
