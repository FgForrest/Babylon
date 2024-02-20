package one.edee.babylon.properties;

import one.edee.babylon.export.ApronMessageLoader;

/**
 * Loads {@link PropertyFileLoader} from a file.
 */
public class PropertyFileLoader extends FileLoader {

    @Override
    public boolean canBeLoaded(String filePath) {
        return filePath.endsWith(ApronMessageLoader.PROPERTIES_FILE_EXTENSION);
    }

    @Override
    public FileActiveRecord createFileActiveRecord() {
        return new PropertyFileActiveRecord();
    }
}
