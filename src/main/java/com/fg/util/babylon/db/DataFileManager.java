package com.fg.util.babylon.db;

import com.fg.util.babylon.entity.DataFile;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.util.JsonUtils;
import lombok.extern.apachecommons.CommonsLog;

import java.io.File;
import java.io.IOException;

/**
 * Manages DataFile instance. TODO more
 */
@CommonsLog
public class DataFileManager {

    /**
     * Name of the DataFile in Json format which serves as working database for translation process.
     */
    private final String dataFileName;

    /**
     * Working DataFile object that changing during the export process. Initial state is given from existing json DataFile.
     * If DataFile not exists then new object DataFile is created.
     */
    private DataFile dataFile; //FIXME nullable annotation

    //FIXME: OMG why is this needed?
    /** Original untouched DataFile loaded from json file on disk while configuration reading phase. */
    private DataFile originalDataFileOnDisk;

    public DataFileManager(String dataFileName) throws IOException {
        this.dataFileName = dataFileName;
        loadOriginalDataFile();
    }

    /**
     * This method loads the original DataFile and should be called as the first thing.
     */
    private void loadOriginalDataFile() throws IOException {
        originalDataFileOnDisk = getExistingDataFileFromDisk(dataFileName);
        if (originalDataFileOnDisk == null) {
            originalDataFileOnDisk = new DataFile();
        }
    }

    /**
     * Gets original {@link DataFile} object (before modification). God knows why this is needed. FIXME
     */
    public DataFile getOriginalDataFile() {
        return originalDataFileOnDisk;
    }

    /**
     * Gets existing {@link DataFile} object (from Json file on disk) or create new {@link DataFile} object,
     * according to file name specified by  {@link TranslationConfiguration#getDataFileName()}
     * @return {@link DataFile}
     * @throws IOException some exception derived from {@link IOException}
     */
    public DataFile getOrCreateDataFile() throws IOException {
        if (dataFile == null) {
            dataFile = getExistingDataFileFromDisk(dataFileName);
            if (dataFile == null) {
                dataFile = new DataFile();
            }
        }
        return dataFile;
    }

    private DataFile getExistingDataFileFromDisk(String dataFileName) throws IOException {
        File file = new File(getDataFileName(dataFileName));
        if (file.exists() && file.length() != 0) {
            DataFile df = JsonUtils.jsonObjFromFile(file, DataFile.class);
            loadDataPropFilesIds(df);
            return df;
        } else {
            return null;
        }
    }

    /**
     * This map {@link DataFile#getDataPropFilesById()} is excluded from Json serialization, so after deserialization of
     * {@link DataFile} from file is necessary to load this map from loaded {@link DataFile#getDataPropFiles()}.
     * @param df DataFile object with map to load in.
     */
    private void loadDataPropFilesIds(DataFile df) {
        df.getDataPropFiles().forEach((key, value) -> {
            if (value.getId() != null) {
                df.putDataPropFileById(value.getId(), value);
            } else {
                log.warn("Id for path \"" + key + "\" not found.");
            }
        });
    }

    /**
     * Get data file name like {@link TranslationConfiguration#getDataFileName()} + .json extension if not appended.
     * @return correct file name.
     * FIXME: tohle asi neni potreba, ne??? to dela ten plugin mene predvidatelny, tyhle chytristiky
     */
    private String getDataFileName(String dataFileName) {
        String resultFileName = dataFileName;
        if (!resultFileName.endsWith(".json")) {
            resultFileName += ".json";
        }
        return resultFileName;
    }

    /**
     * Used only for testing. This should be done in a way that doesn't break encapsulation, but for now we have to live with this.
     * @param dataFile data file to use instead of the managed data file
     */
    public void switchDataFileTo(DataFile dataFile) {
        this.dataFile = dataFile;
    }

    /**
     * Used only for testing. This should be done in a way that doesn't break encapsulation, but for now we have to live with this.
     * @param dataFile data file to use instead of the original data file (why would that ever needed to be changed is beyond me).
     */
    public void switchOriginalDataFileTo(DataFile dataFile) {
        this.originalDataFileOnDisk = dataFile;
    }

}
