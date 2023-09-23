package one.edee.babylon.export;

import de.poiu.apron.java.util.Properties;
import one.edee.babylon.msgfile.TranslationFileUtils;
import one.edee.babylon.util.FileUtils;
import de.poiu.apron.PropertyFile;

import java.io.File;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApronMessageLoader implements MessageLoader {
    public static final String PROPERTIES_FILE_EXTENSION = ".properties";

    @Override
    public boolean canBeLoaded(String filePath) {
        return filePath.endsWith(PROPERTIES_FILE_EXTENSION);
    }

    @Override
    public Map<String, String> loadPrimaryMessages(String filePath) {
        return dumpPropertyFile(filePath);
    }

    @Override
    public Map<String, Map<String, String>> loadTranslations(String filePath, List<String> languages) {
        return languages
                .stream()
                .map(lang ->
                        new AbstractMap.SimpleEntry<>(
                                lang,
                                loadTranslations(filePath, lang)
                        )
                ).collect(Collectors.toMap(
                        AbstractMap.SimpleEntry::getKey,
                        AbstractMap.SimpleEntry::getValue)
                );
    }

    private Map<String, String> loadTranslations(String filePath, String language) {
        String translationFilePath = TranslationFileUtils.getFileNameForTranslation(filePath, language);
        return dumpPropertyFile(translationFilePath);
    }

    private Map<String, String> dumpPropertyFile(String filePath) {
        PropertyFile primaryMsgs;
        if (FileUtils.exists(filePath)) {
            primaryMsgs = PropertyFile.from(fileFromPath(filePath));
        } else {
            primaryMsgs = new PropertyFile();
        }
        return dumpPropertyFile(new Properties(primaryMsgs));
    }

    private Map<String, String> dumpPropertyFile(Properties properties) {
        return properties
                .entrySet()
                .stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(
                                (String) entry.getKey(),
                                cleanPropertyValue((String) entry.getValue())
                        )
                ).collect(Collectors.toMap(
                        AbstractMap.SimpleEntry::getKey,
                        AbstractMap.SimpleEntry::getValue)
                );
    }

    String cleanPropertyValue(String rawValue) {
        return rawValue.trim();
    }

    private File fileFromPath(String path) {
        return FileUtils.fileFromPathOrThrow(path);
    }

}
