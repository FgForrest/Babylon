package com.fg.util.babylon.processor;

import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.Configuration;
import com.fg.util.babylon.entity.DataFile;
import com.fg.util.babylon.exception.EmptyDbFileException;
import com.fg.util.babylon.properties.FileProperties;
import com.fg.util.babylon.service.GoogleSheetService;
import com.fg.util.babylon.util.JsonUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/**
 * Base class for all processors.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Component
@CommonsLog
public abstract class BaseProcessor {

    /** Name of the column with names of the properties in google sheet. */
    static final String COL_KEY = "key";
    /** Name of the column with text values of the primary mutation in google sheet. */
    static final String COL_PRIMARY = "primary";
    static final String EMPTY_VAL = "";

    @Autowired
    protected GoogleSheetService googleSheetService;

    protected Arguments arguments;
    protected Configuration configuration;
    PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
    private DataFile dataFile;

    public void startTranslation(Arguments arguments) throws IOException, GeneralSecurityException {
        this.arguments = arguments;
        readConfiguration();
        processTranslation();
    }

    protected abstract void processTranslation() throws IOException, GeneralSecurityException;

    private void readConfiguration() throws IOException {
        File file = new File(arguments.getConfigFileName());
        if (!file.exists()) {
            throw new FileNotFoundException("Cannot find configuration file: " + file.getAbsolutePath());
        }
        configuration = JsonUtils.jsonObjFromFile(file, Configuration.class);
    }

    /**
     * Loads properties from file.
     * @param fileNamePath
     * @return Returns loaded file {@link FileProperties} or null if file not exists.
     * @throws IOException some exception derived from {@link IOException}
    */
    FileProperties loadPropertiesFromFile(String fileNamePath) throws IOException {
        if (!new File(fileNamePath).exists()) {
            return null;
        }
        FileProperties fileProperties = new FileProperties();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileNamePath), StandardCharsets.UTF_8);
        fileProperties.load(inputStreamReader);
        return fileProperties;
    }

    /**
     * Gets existing {@link DataFile} object (from Json file on disk) or create new {@link DataFile} object,
     * according to file name specified by  {@link Configuration#getDataFileName()}
     * @return {@link DataFile}
     * @throws IOException some exception derived from {@link IOException}
    */
    protected DataFile getOrCreateDataFile() throws IOException {
        if (dataFile == null) {
            File file = new File(getDataFileName());
            if (file.exists()) {
                if (file.length() == 0) {
                    throw new EmptyDbFileException("Db file \"" + file.getAbsolutePath() + "\" is empty");
                }
                dataFile = JsonUtils.jsonObjFromFile(file, DataFile.class);
                loadDataPropFilesIds();
            } else {
                dataFile = new DataFile();
            }
        }
        return dataFile;
    }

    /**
     * This map {@link DataFile#getDataPropFilesById()} is excluded from Json serialization, so after deserialization of
     * {@link DataFile} from file is necessary to load this map from loaded {@link DataFile#getDataPropFiles()}.
     */
    private void loadDataPropFilesIds() {
        dataFile.getDataPropFiles().forEach((key, value) -> {
            if (value.getId() != null) {
                dataFile.putDataPropFileById(value.getId(), value);
            } else {
                log.warn("Id for path \"" + key + "\" not found.");
            }
        });
    }

    /**
     * Get data file name like {@link Configuration#getDataFileName()} + .json extension if not appended.
     * @return correct file name.
     */
    private String getDataFileName() {
        String resultFileName = configuration.getDataFileName();
        if (!resultFileName.endsWith(".json")) {
            resultFileName += ".json";
        }
        return resultFileName;
    }

    /**
     * Get file name like primaryPropFilePath + ("_" + mutation if is not null or empty) + possible original extension of primaryPropFilePath.
     * @param primaryPropFilePath path to the primary mutation file
     * @param mutation mutation of the file what you want
     * @return correct file name for mutation
     */
    String getFileNameForMutation(String primaryPropFilePath, String mutation) {
        if (StringUtils.isEmpty(mutation)) {
            return primaryPropFilePath;
        }
        String fileExtension = FilenameUtils.getExtension(primaryPropFilePath);
        if (!StringUtils.isEmpty(fileExtension)) {
            fileExtension = "." + fileExtension;
        }
        String fileMutation = "_" + mutation;
        String mutationFileName = FilenameUtils.removeExtension(primaryPropFilePath);
        mutationFileName += fileMutation + fileExtension;
        return mutationFileName;
    }

}
