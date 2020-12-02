package com.fg.util.babylon.db;

import com.fg.util.babylon.snapshot.Snapshot;
import com.fg.util.babylon.entity.TranslationConfiguration;
import com.fg.util.babylon.util.JsonUtils;
import lombok.extern.apachecommons.CommonsLog;

import java.io.File;
import java.io.IOException;

/**
 * Manages Snapshot instance. TODO more
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
    private Snapshot snapshot; //FIXME nullable annotation

    //FIXME: OMG why is this needed?
    /** Original untouched DataFile loaded from json file on disk while configuration reading phase. */
    private Snapshot originalSnapshotOnDisk;

    public DataFileManager(String dataFileName) throws IOException {
        this.dataFileName = dataFileName;
        loadOriginalDataFile();
    }

    /**
     * This method loads the original DataFile and should be called as the first thing.
     */
    private void loadOriginalDataFile() throws IOException {
        originalSnapshotOnDisk = getExistingDataFileFromDisk(dataFileName);
        if (originalSnapshotOnDisk == null) {
            originalSnapshotOnDisk = new Snapshot();
        }
    }

    /**
     * Gets original {@link Snapshot} object (before modification). God knows why this is needed. FIXME
     */
    @Deprecated
    public Snapshot getOriginalDataFile() {
        return originalSnapshotOnDisk;
    }

    /**
     * Gets existing {@link Snapshot} object (from Json file on disk) or create new {@link Snapshot} object,
     * according to file name specified by  {@link TranslationConfiguration#getDataFileName()}
     * @return {@link Snapshot}
     * @throws IOException some exception derived from {@link IOException}
     */
    public Snapshot getOrCreateDataFile() throws IOException {
        if (snapshot == null) {
            snapshot = getExistingDataFileFromDisk(dataFileName);
            if (snapshot == null) {
                snapshot = new Snapshot();
            }
        }
        return snapshot;
    }

    private Snapshot getExistingDataFileFromDisk(String dataFileName) throws IOException {
        File file = new File(getDataFileName(dataFileName));
        if (file.exists() && file.length() != 0) {
            Snapshot df = JsonUtils.jsonObjFromFile(file, Snapshot.class);
            loadDataPropFilesIds(df);
            return df;
        } else {
            return null;
        }
    }

    /**
     * This map {@link Snapshot#getDataPropFilesById()} is excluded from Json serialization, so after deserialization of
     * {@link Snapshot} from file is necessary to load this map from loaded {@link Snapshot#getDataPropFiles()}.
     * @param df DataFile object with map to load in.
     */
    private void loadDataPropFilesIds(Snapshot df) {
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
     * @param snapshot data file to use instead of the managed data file
     */
    public void switchDataFileTo(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    /**
     * Used only for testing. This should be done in a way that doesn't break encapsulation, but for now we have to live with this.
     * @param snapshot data file to use instead of the original data file (why would that ever needed to be changed is beyond me).
     */
    public void switchOriginalDataFileTo(Snapshot snapshot) {
        this.originalSnapshotOnDisk = snapshot;
    }

}
