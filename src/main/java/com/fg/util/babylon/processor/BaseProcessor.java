package com.fg.util.babylon.processor;

import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.Configuration;
import com.fg.util.babylon.entity.DataFile;
import com.fg.util.babylon.service.GoogleSheetService;
import com.fg.util.babylon.util.JsonUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Base class for all processors.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Component
public abstract class BaseProcessor {

    protected static final String EMPTY_VAL = "";

    @Autowired
    protected GoogleSheetService googleSheetService;

    protected Arguments arguments;
    protected Configuration configuration;
    protected PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
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
     * @return Returns loaded file properties or null if file not exists.
     * @throws IOException
     */
    protected Properties loadPropertiesFromFile(String fileNamePath) throws IOException {
        if (!new File(fileNamePath).exists()) {
            return null;
        }
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(fileNamePath);
        properties.load(fileReader);
        return properties;
    }

    /**
     * Gets existing or create new {@link DataFile} according to physically existence of file with name specified by {@link Configuration#getDataFileName()}{@link DataFile}
     * @return {@link DataFile}
     * @throws IOException
     */
    protected DataFile getOrCreateDataFile() throws IOException {
        if (dataFile == null) {
            File file = new File(getDataFileName());
            if (file.exists()) {
                dataFile = JsonUtils.jsonObjFromFile(file, DataFile.class);
            } else {
                dataFile = new DataFile();
            }
        }
        return dataFile;
    }

    /**
     * Get data file name like {@link Configuration#getDataFileName()} .json extension if not appended.
     * @return
     */
    private String getDataFileName() {
        String resultFileName = configuration.getDataFileName();
        if (!resultFileName.endsWith(".json")) {
            resultFileName += ".json";
        }
        return resultFileName;
    }

    /**
     * Get file name like primaryPropertyFilePath + ("_" + mutation if is not null or empty) + possible original extension of primaryPropertyFilePath.
     * @param primaryPropertyFilePath
     * @param mutation
     * @return
     */
    protected String getFileNameForMutation(String primaryPropertyFilePath, String mutation) {
        if (StringUtils.isEmpty(mutation)) {
            return primaryPropertyFilePath;
        }
        String fileExtension = FilenameUtils.getExtension(primaryPropertyFilePath);
        if (!StringUtils.isEmpty(fileExtension)) {
            fileExtension = "." + fileExtension;
        }
        String fileMutation = "_" + mutation;
        String mutationFileName = FilenameUtils.removeExtension(primaryPropertyFilePath);
        mutationFileName += fileMutation + fileExtension;
        return mutationFileName;
    }

}
