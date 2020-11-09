package com.fg.util.babylon.processor;

import com.fg.util.babylon.db.DataFileManager;
import com.fg.util.babylon.entity.Arguments;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.properties.FileProperties;
import com.fg.util.babylon.service.GoogleSheetService;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/**
 * Base class for all processors.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public abstract class BaseProcessor {

    /** Name of the column with names of the properties in google sheet. */
    static final String COL_KEY = "key";
    /** Name of the column with text values of the primary mutation in google sheet. */
    static final String COL_PRIMARY = "primary";
    static final String EMPTY_VAL = "";

    protected GoogleSheetService googleSheetService;

    protected DataFileManager dataFileManager;

    /**
     * Id of the target google spreadsheet.
     */
    protected final String googleSheetId;

    protected TranslationConfiguration configuration;

    public BaseProcessor(GoogleSheetService googleSheetService, DataFileManager dataFileManager, Arguments arguments, TranslationConfiguration configuration) {
        this.googleSheetService = googleSheetService;
        this.dataFileManager = dataFileManager;
        this.googleSheetId = arguments.getGoogleSheetId();

        this.configuration = configuration;
    }

    PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();


    public void startTranslation() throws IOException, GeneralSecurityException, InterruptedException {
        processTranslation();
    }

    protected abstract void processTranslation() throws IOException, GeneralSecurityException, InterruptedException;

    /**
     * Loads properties from file.
     * @param fileNamePath path to existing properties file
     * @return Returns loaded file {@link FileProperties} or null if file not exists.
     * @throws IOException some exception derived from {@link IOException}
    */
    FileProperties loadPropertiesFromFile(String fileNamePath) throws IOException {
        if (!new File(fileNamePath).exists()) {
            return null;
        }
        FileProperties fileProperties = new FileProperties();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileNamePath), StandardCharsets.UTF_8)) {
            fileProperties.load(inputStreamReader);
        }
        return fileProperties;
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
