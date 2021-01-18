package one.edee.babylon.export;

import lombok.extern.apachecommons.CommonsLog;
import one.edee.babylon.msgfile.TranslationFileUtils;
import one.edee.babylon.properties.Property;
import one.edee.babylon.util.FileUtils;
import de.poiu.apron.PropertyFile;
import de.poiu.apron.entry.PropertyEntry;

import java.io.File;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@CommonsLog
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
        PropertyFile msgs;
        if (FileUtils.exists(filePath)) {
            msgs = PropertyFile.from(fileFromPath(filePath), Charset.defaultCharset());
            checkDuplicateKeys(msgs, filePath);
        } else {
            msgs = new PropertyFile();
        }
        return dumpPropertyFile(msgs);
    }

    private void checkDuplicateKeys(PropertyFile propertyFile, String filePath) {
        List<String> duplicateKeys = propertyFile.getAllEntries()
                .stream()
                .filter(entry -> entry instanceof PropertyEntry)
                .map(propEntry ->  ((PropertyEntry) propEntry).getKey().toString())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        List<PropertyEntry> dupEntries = duplicateKeys
                .stream()
                .map(propertyFile::getPropertyEntry)
                .collect(Collectors.toList());
        dupEntries.forEach(dupEntry ->
                log.error("Duplicate property with key '" + dupEntry.getKey() + "' and first occurrence value '" + dupEntry.getValue() + "' found in property file '" + filePath +"'."));
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
        return FileUtils.fileFromPathOrThrow(path);
    }

}
