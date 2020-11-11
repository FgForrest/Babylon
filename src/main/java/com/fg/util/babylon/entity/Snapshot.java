package com.fg.util.babylon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Class representing translation data file (snapshot) in json file. This data file keeps information about processing
 * of language properties files by given {@link TranslationConfiguration}.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public class Snapshot implements Serializable {

    private static final long serialVersionUID = 4891061639828627492L;

    /**
     * Properties files data like {@link Map&lt;String, DataPropFile&gt;}<br>
     * key - contains name and relative path to primary language properties file<br>
     * value - contains {@link MessageFile}
     */
    private Map<String, MessageFile> dataPropFiles = new LinkedHashMap<>();

    /**
     * Properties files data like {@link Map&lt;String, DataPropFile&gt;} by unique id<br>
     * key - contains unique id of name and relative path to primary language properties file<br>
     * value - contains {@link MessageFile}
     */
    @JsonIgnore
    private Map<Integer, MessageFile> dataPropFilesById = new LinkedHashMap<>();

    public MessageFile putPropFile(String fileName, MessageFile messageFile) {
        MessageFile propFile = dataPropFiles.put(fileName, messageFile);
        // Create unique id of filename and store same dataPropFile instance under this hash code as key into map.
        // Id is also stored into DataPropFile#id field.
        Integer fileNameId = getNextUniqueId();
        messageFile.setId(fileNameId);
        putDataPropFileById(fileNameId, messageFile);
        return propFile;
    }

    public MessageFile putDataPropFileById(Integer fileNameId, MessageFile messageFile) {
        return dataPropFilesById.put(fileNameId, messageFile);
    }

    /**
     * Get {@link MessageFile} by relative file name and path to the source/destination properties file.
     * @param fileName relative path to properties file.
     * @return existing {@link MessageFile} for specified fileName or create, add and return new {@link MessageFile} object for fileName.
     */
    public MessageFile getOrPutNewPropFileByFileName(String fileName) {
        MessageFile messageFile = dataPropFiles.get(fileName);
        if (messageFile == null) {
            messageFile = new MessageFile();
            putPropFile(fileName, messageFile);
        }
        return messageFile;
    }

    public MessageFile getPropFileByFileName(String fileName) {
        return dataPropFiles.get(fileName);
    }

    /**
     * Get {@link MessageFile} by id of the path.
     * @param id unique id of the relative file name and path to source/destination properties file.
     * @return get {@link MessageFile} if exists
     */
    public MessageFile getPropFileById(Integer id) {
        return dataPropFilesById.get(id);
    }

    /**
     * Gets next unique ID for identification of one properties bundle in translation.
     * @return Get unique ID
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
