package one.edee.babylon.properties;

import one.edee.babylon.export.TsMessageLoader;

/**
 * Loads {@link TsFileLoader} from a file.
 */
public class TsFileLoader extends FileLoader {

    @Override
    public boolean canBeLoaded(String filePath) {
        return filePath.endsWith(TsMessageLoader.TS_FILE_EXTENSION);
    }
    @Override
    public FileActiveRecord createFileActiveRecord() {
        return new TsFileActiveRecord();
    }
}
