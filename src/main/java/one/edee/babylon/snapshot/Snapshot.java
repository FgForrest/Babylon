package one.edee.babylon.snapshot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import one.edee.babylon.config.TranslationConfiguration;
import one.edee.babylon.entity.MessageFileContent;

import java.io.File;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class representing translation data file (snapshot) in json file. This data file keeps information about processing
 * of language properties files by given {@link TranslationConfiguration}.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class Snapshot implements Serializable {
    public static final String LINUX_DELIMITER = "/";
    public static final String ORIGINAL_DELIMITER = "\\";

    private static final long serialVersionUID = 4891061639828627492L;

    /**
     * Properties files data like {@link Map&lt;String, DataPropFile&gt;}<br>
     * key - relative path to message file of the primary language<br>, eg <code>lib_eshop_edee\\src\\main\\resources\\META-INF\\lib_eshop_edee\\i18n\\common.properties</code>
     * value - contains {@link MessageFileContent}
     */
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    @JsonProperty("dataPropFiles")
    private Map<String, MessageFileContent> dataPropFiles = new LinkedHashMap<>();

    /**
     * Properties files data like {@link Map&lt;String, DataPropFile&gt;} by unique id<br>
     * key - contains unique id of name and relative path to primary language properties file<br>
     * value - contains {@link MessageFileContent}
     */
    @JsonIgnore
    private Map<Integer, MessageFileContent> dataPropFilesById = new LinkedHashMap<>();

    public MessageFileContent putPropFile(String fileName, MessageFileContent messageFileContent) {
        MessageFileContent propFile = dataPropFiles.put(clearPath(fileName), messageFileContent);
        // Create unique id of filename and store same dataPropFile instance under this hash code as key into map.
        // Id is also stored into DataPropFile#id field.
        Integer fileNameId = getNextUniqueId();
        messageFileContent.setId(fileNameId);
        putDataPropFileById(fileNameId, messageFileContent);
        return propFile;
    }

    public MessageFileContent putDataPropFileById(Integer fileNameId, MessageFileContent messageFileContent) {
        return dataPropFilesById.put(fileNameId, messageFileContent);
    }

    /**
     * Get {@link MessageFileContent} by relative file name and path to the source/destination properties file.
     * @param fileName relative path to properties file.
     * @return existing {@link MessageFileContent} for specified fileName or create, add and return new {@link MessageFileContent} object for fileName.
     */
    public MessageFileContent getOrPutNewPropFileByFileName(String fileName) {
        fileName = clearPath(fileName);
        MessageFileContent messageFileContent = dataPropFiles.get(fileName);
        if (messageFileContent == null) {
            messageFileContent = new MessageFileContent();
            putPropFile(fileName, messageFileContent);
        }
        return messageFileContent;
    }

    public MessageFileContent getPropFileByFileName(String fileName) {
        return dataPropFiles.get(clearPath(fileName));
    }

    /**
     * Get {@link MessageFileContent} by id of the path.
     * @param id unique id of the relative file name and path to source/destination properties file.
     * @return get {@link MessageFileContent} if exists
     */
    public MessageFileContent getPropFileById(Integer id) {
        return dataPropFilesById.get(id);
    }

    public void removePaths(Collection<String> msgFilePaths) {
        msgFilePaths.forEach(path -> dataPropFiles.remove(clearPath(path)));
    }

    @JsonIgnore
    public Collection<String> getPaths() {
        return dataPropFiles.keySet().stream().map(Snapshot::normalizePath).collect(Collectors.toList());
    }

    @JsonIgnore
    public Map<String, MessageFileContent> getProps() {
        return dataPropFiles.entrySet().stream().collect(Collectors.toMap(i -> normalizePath(i.getKey()), Map.Entry::getValue));
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

    private static String clearPath(String fileName) {
        if (File.separator.equals(LINUX_DELIMITER))
            fileName = fileName.replace(LINUX_DELIMITER, ORIGINAL_DELIMITER);

        return fileName;
    }

    private static String normalizePath(String fileName) {
        if (File.separator.equals(LINUX_DELIMITER))
            fileName = fileName.replace(ORIGINAL_DELIMITER, LINUX_DELIMITER);

        return fileName;
    }
}
