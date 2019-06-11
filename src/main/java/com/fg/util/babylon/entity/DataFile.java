package com.fg.util.babylon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Class representing translation data file (changelog) in json file. This data file keeps information about processing
 * of language properties files by given {@link Configuration}.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class DataFile implements Serializable {

    private static final long serialVersionUID = 4891061639828627492L;

    /**
     * Properties files data like {@link Map&lt;String, DataPropFile&gt;}<br>
     * key - contains name and relative path to primary language properties file<br>
     * value - contains {@link DataPropFile}
     */
    private Map<String, DataPropFile> dataPropFiles = new LinkedHashMap<>();

    /**
     * Properties files data like {@link Map&lt;String, DataPropFile&gt;} by unique id<br>
     * key - contains unique id of name and relative path to primary language properties file<br>
     * value - contains {@link DataPropFile}
     */
    @JsonIgnore
    private Map<Integer, DataPropFile> dataPropFilesById = new LinkedHashMap<>();

    public DataPropFile putPropFile(String fileName, DataPropFile dataPropFile) {
        DataPropFile propFile = dataPropFiles.put(fileName, dataPropFile);
        // Create unique id of filename and store same dataPropFile instance under this hash code as key into map.
        // Id is also stored into DataPropFile#id field.
        Integer fileNameId = getNextUniqueId();
        dataPropFile.setId(fileNameId);
        putDataPropFileById(fileNameId, dataPropFile);
        return propFile;
    }

    public DataPropFile putDataPropFileById(Integer fileNameId, DataPropFile dataPropFile) {
        return dataPropFilesById.put(fileNameId, dataPropFile);
    }

    /**
     * Get {@link DataPropFile} by relative file name and path to the source/destination properties file.
     * @param fileName relative path to properties file.
     * @return existing {@link DataPropFile} for specified fileName or create, add and return new {@link DataPropFile} object for fileName.
     */
    public DataPropFile getOrPutNewPropFileByFileName(String fileName) {
        DataPropFile dataPropFile = dataPropFiles.get(fileName);
        if (dataPropFile == null) {
            dataPropFile = new DataPropFile();
            putPropFile(fileName, dataPropFile);
        }
        return dataPropFile;
    }

    /**
     * Get {@link DataPropFile} by id of the path.
     * @param id unique id of the relative file name and path to source/destination properties file.
     * @return
     */
    public DataPropFile getPropFileById(Integer id) {
        return dataPropFilesById.get(id);
    }

    /**
     * Gets next unique ID for identification of one properties bundle in translation.
     * @return
     */
    private Integer getNextUniqueId() {
        Set<Integer> ids = dataPropFilesById.keySet();
        if (ids.isEmpty()) {
            return 0;
        }
        Optional<Integer> maxId = ids.stream().reduce(Integer::max);
        return maxId.get() + 1;
    }

}
