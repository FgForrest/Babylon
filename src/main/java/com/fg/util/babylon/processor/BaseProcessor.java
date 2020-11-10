package com.fg.util.babylon.processor;

import com.fg.util.babylon.entity.TranslationConfiguration;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;

import java.io.*;
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

    protected TranslationConfiguration configuration;

    public BaseProcessor(TranslationConfiguration configuration) {
        this.configuration = configuration;
    }


    public void startTranslation() throws IOException, GeneralSecurityException, InterruptedException {
        processTranslation();
    }

    protected abstract void processTranslation() throws IOException, GeneralSecurityException, InterruptedException;

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
