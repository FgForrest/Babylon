package one.edee.babylon.imp0rt;

import one.edee.babylon.msgfile.TranslationFileUtils;
import one.edee.babylon.snapshot.Snapshot;
import one.edee.babylon.util.FileUtils;
import de.poiu.apron.PropertyFile;
import de.poiu.apron.entry.PropertyEntry;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implements {@link MessageWriter} using Apron library.
 * This should replace {@link one.edee.babylon.imp0rt.legacy.MessageFileContentMessageWriter} after
 * {@link one.edee.babylon.db.SnapshotManager} is refactored so that it doesn't need two instances of {@link Snapshot}.
 */
public class ApronMessageWriter implements MessageWriter {

    private final PropertyFile primaryMessageFile;
    private final Map<String, PropertyFile> translationMessageFiles;

    public ApronMessageWriter(String filePath, Collection<String> translations) {
        primaryMessageFile = primaryMsgFileFromPath(filePath);
        translationMessageFiles = translations.stream()
                .map(lang -> new AbstractMap.SimpleEntry<>(
                                lang,
                                translationMsgFileFromPath(lang, filePath)
                        )
                ).collect(Collectors.toMap(
                        AbstractMap.SimpleEntry::getKey,
                        AbstractMap.SimpleEntry::getValue)
                );
    }

    public void storePrimaryMessage(String msgKey, String msgValue) {
        storeEntry(primaryMessageFile, msgKey, msgValue);
    }

    public void storeTranslation(String language, String msgKey, String msgValue) {
        PropertyFile translationFile = translationMessageFiles.get(language);
        if (translationFile == null) {
            throw new IllegalArgumentException("Unexpected translation '" + language + "'.");
        }

        storeEntry(translationFile, msgKey, msgValue);
    }

    private void storeEntry(PropertyFile propertyFile, String msgKey, String msgValue) {
        PropertyEntry entry = propertyFile.getPropertyEntry(msgKey);
        if (entry != null) {
            entry.setValue(msgValue);
        } else {
            PropertyEntry newEntry = new PropertyEntry(msgKey, msgValue);
            propertyFile.appendEntry(newEntry);
        }
    }

    private PropertyFile translationMsgFileFromPath(String language, String path) {
        String translationPath = TranslationFileUtils.getFileNameForTranslation(path, language);
        try {
            File existingOrNewFile = FileUtils.fileFromPathOrCreate(translationPath);
            return PropertyFile.from(existingOrNewFile, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Could not create file '" + path + "'", e);
        }
    }

    private PropertyFile primaryMsgFileFromPath(String path) {
        File existingFile = FileUtils.fileFromPathOrThrow(path);
        return PropertyFile.from(existingFile, Charset.defaultCharset());
    }

}
