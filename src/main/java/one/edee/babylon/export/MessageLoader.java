package one.edee.babylon.export;

import java.util.List;
import java.util.Map;

public interface MessageLoader {

    /**
     * Loads primary language messages for given message file path.
     *
     * @param filePath path to message file to load messages from
     * @return messages loaded from {@code filePath}, mapped by message keys
     */
    Map<String, String> loadPrimaryMessages(String filePath);

    /**
     * Loads translations of messages for given message file path {@code filePath}, searching for translations to
     * languages given in {@code languages}. For languages where the translation is missing, the translations are empty.
     *
     * @param filePath path to primary message file to load translated messages for
     * @param languages languages of translations to fetch
     * @return mapping of language to its translated messages, where translated messages is a message key -> message
     * value mapping.
     */
    Map<String, Map<String, String>> loadTranslations(String filePath, List<String> languages);

}
