package com.fg.util.babylon.export;

import com.fg.util.babylon.todo.TranslationFileUtils;
import de.poiu.apron.PropertyFile;
import de.poiu.apron.entry.PropertyEntry;

import java.io.File;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApronMessageLoader implements MessageLoader {

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
        PropertyFile primaryMsgs = PropertyFile.from(fileFromPath(filePath));
        return dumpPropertyFile(primaryMsgs);
    }

    private Map<String, String> dumpPropertyFile(PropertyFile propertyFile) {
        return propertyFile.getAllEntries()
                .stream()
                .filter(entry -> entry instanceof PropertyEntry)
                .map(propEntry -> new AbstractMap.SimpleEntry<>(
                                ((PropertyEntry) propEntry).getKey().toString(),
                                cleanPropertyValue(
                                        ((PropertyEntry) propEntry).getValue().toString()
                                )
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
        File propFile = new File(path);
        if (!propFile.exists()) {
            throw new IllegalArgumentException("Message file '" + path + "' could not be found.");
        }
        return propFile;
    }

}
