package one.edee.babylon.export;

import one.edee.babylon.export.MessageFileProcessor.Pair;
import one.edee.babylon.export.MessageFileProcessor.SheetContent;
import one.edee.babylon.export.stats.MessageFileExportStats;
import one.edee.babylon.snapshot.TranslationSnapshotReadContract;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MessageFileProcessorTest {

    @Test
    public void testWhenAllTranslationsExistAndUnchanged_thenNotIncludedInSheet() {
        Map<String, String> keys1 = new HashMap<>();
        keys1.put("pagination.prev", "Previous");
        keys1.put("pagination.next", "Next");

        Map<String, Map<String, String>> map1 = new HashMap<>();
        map1.put("i18n/common.properties", keys1);
        TranslationSnapshotReadContract snapshot = new FakeTranslationSnapshot(map1);

        Map<String, String> primaryMessages = new HashMap<>();
        keys1.put("pagination.prev", "Previous");
        keys1.put("pagination.next", "Next");

        List<String> translateTo = Arrays.asList("cz", "sk");

        Map<String, String> keysCz = new HashMap<>();
        keys1.put("pagination.prev", "Předchozí");
        keys1.put("pagination.next", "Následující");
        Map<String, String> keysSk = new HashMap<>();
        keys1.put("pagination.prev", "Predchádzajúce");
        keys1.put("pagination.next", "Nasledujúce");

        Map<String, Map<String, String>> translations = new HashMap<>();
        translations.put("cz", keysCz);
        translations.put("sk", keysSk);

        SheetContent expected = new SheetContent(
                Arrays.asList("key", "primary", "cz", "sk"),
                Collections.emptyList()
        );

        MessageFileProcessor mfProcessor = new MessageFileProcessor(snapshot);
        SheetContent sheet = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo).getFirst();

        assertEquals(expected, sheet);
    }

    @Test
    public void whenNoSnapshotOfPreviousTranslationAndNoTranslationsThenAllMessagesAreExportedToTranslationSheet() {
        FakeTranslationSnapshot emptySnapshot = new FakeTranslationSnapshot(new HashMap<>());

        Map<String, String> primaryMessages = BMap.of(
                "pagination.prev", "Previous",
                "pagination.next", "Next",
                "price.zeroPriceString", "Free");

        List<String> translateTo = Arrays.asList("cz", "sk");
        Map<String, Map<String, String>> noTranslations = new HashMap<>();

        SheetContent expected = new SheetContent(
                Arrays.asList("key", "primary", "cz", "sk"),
                Arrays.asList(
                        Arrays.asList("pagination.prev", "Previous", null, null),
                        Arrays.asList("pagination.next", "Next", null, null),
                        Arrays.asList("price.zeroPriceString", "Free", null, null)
                )
        );

        MessageFileProcessor mfProcessor = new MessageFileProcessor(emptySnapshot);
        Pair<SheetContent, MessageFileExportStats> result = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, noTranslations, translateTo);
        assertEquals(expected, result.getFirst());
    }

    @Test
    public void whenThereIsANewPrimaryMessageFileThenItsMessagesAreExportedToTranslationSheetButTheMessagesAlreadyInSnapshotAreNot() {
        FakeTranslationSnapshot snapshot = new FakeTranslationSnapshot(BMap.of(
                "i18n/common.properties", BMap.of(
                        "pagination.prev", "Previous",
                        "pagination.next", "Next",
                        "price.zeroPriceString", "Free")));

        Map<String, String> primaryMessages = BMap.of(
                "pagination.prev", "Previous",
                "pagination.next", "Next",
                "price.zeroPriceString", "Free",
                "availability.text.ALWAYS_AVAILABLE", "Always in stock",
                "availability.text.NOT_AVAILABLE", "Momentarily unavailable");

        List<String> translateTo = Arrays.asList("cz", "sk");
        Map<String, Map<String, String>> translations = BMap.of(
                "cz", BMap.of(
                        "pagination.prev", "Předchozí",
                        "pagination.next", "Následující",
                        "price.zeroPriceString", "Zdarma"),
                "sk", BMap.of(
                        "pagination.prev", "Predchádzajúce",
                        "pagination.next", "Nasledujúce",
                        "price.zeroPriceString", "Zadarmo"));

        SheetContent expected = new SheetContent(
                Arrays.asList("key", "primary", "cz", "sk"),
                Arrays.asList(
                        Arrays.asList("availability.text.ALWAYS_AVAILABLE", "Always in stock", null, null),
                        Arrays.asList("availability.text.NOT_AVAILABLE", "Momentarily unavailable", null, null)
                )
        );

        MessageFileProcessor mfProcessor = new MessageFileProcessor(snapshot);
        Pair<SheetContent, MessageFileExportStats> result = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo);
        assertEquals(expected, result.getFirst());
    }

    @Test
    public void whenMessageIsMissingSomeTranslationsThenTheMessageValuesExistingTranslationsAreIncludedInTheTranslationSheet() {
        FakeTranslationSnapshot emptySnapshot = new FakeTranslationSnapshot(new HashMap<>());

        Map<String, String> primaryMessages = BMap.of(
                "pagination.prev", "Previous",
                "pagination.next", "Next",
                "price.zeroPriceString", "Free");

        List<String> translateTo = Arrays.asList("cz", "sk");
        Map<String, Map<String, String>> translations = BMap.of(
                "cz", BMap.of(
                        "pagination.prev", "Předchozí"),
                "sk", BMap.of(
                        "pagination.next", "Nasledujúce")
        );

        SheetContent expected = new SheetContent(
                Arrays.asList("key", "primary", "cz", "sk"),
                Arrays.asList(
                        Arrays.asList("pagination.prev", "Previous", "Předchozí", null),
                        Arrays.asList("pagination.next", "Next", null, "Nasledujúce"),
                        Arrays.asList("price.zeroPriceString", "Free", null, null)
                )
        );

        MessageFileProcessor mfProcessor = new MessageFileProcessor(emptySnapshot);
        Pair<SheetContent, MessageFileExportStats> result = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo);
        assertEquals(expected, result.getFirst());
    }

    @Test
    public void whenMessageIsPresentInSnapshotButIsMissingFromPrimaryMessageFileThenItIsNotExportedToTranslationSheet() {
        FakeTranslationSnapshot snapshot = new FakeTranslationSnapshot(BMap.of(
                "i18n/common.properties", BMap.of(
                        "pagination.prev", "Previous",
                        "pagination.next", "Next",
                        "price.zeroPriceString", "Free")));

        Map<String, String> primaryMessages = BMap.of(
                "pagination.prev", "Previous",
                "pagination.next", "Next",
                "availability.text.ALWAYS_AVAILABLE", "Always in stock",
                "availability.text.NOT_AVAILABLE", "Momentarily unavailable");

        List<String> translateTo = Arrays.asList("cz", "sk");
        Map<String, Map<String, String>> translations = BMap.of(
                "cz", BMap.of(
                        "pagination.prev", "Předchozí",
                        "pagination.next", "Následující"),
                "sk", BMap.of(
                        "pagination.prev", "Predchádzajúce",
                        "pagination.next", "Nasledujúce"));

        SheetContent expected = new SheetContent(
                Arrays.asList("key", "primary", "cz", "sk"),
                Arrays.asList(
                        Arrays.asList("availability.text.ALWAYS_AVAILABLE", "Always in stock", null, null),
                        Arrays.asList("availability.text.NOT_AVAILABLE", "Momentarily unavailable", null, null)
                )
        );

        MessageFileProcessor mfProcessor = new MessageFileProcessor(snapshot);
        Pair<SheetContent, MessageFileExportStats> result = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo);
        assertEquals(expected, result.getFirst());
    }

    @Test
    public void whenMessageDiffersFromTheValueInSnapshotThenAllTranslationsForThisMessageAreEmptyInTheTranslationSheet() {
        FakeTranslationSnapshot snapshot = new FakeTranslationSnapshot(BMap.of(
                "i18n/common.properties", BMap.of(
                        "pagination.prev", "Previous",
                        "pagination.next", "Next",
                        "price.zeroPriceString", "Free")));

        Map<String, String> primaryMessages = BMap.of(
                "pagination.prev", "Prev",
                "pagination.next", "Next",
                "price.zeroPriceString", "Free");

        List<String> translateTo = Arrays.asList("cz", "sk");
        Map<String, Map<String, String>> translations = BMap.of(
                "cz", BMap.of(
                        "pagination.prev", "Předchozí",
                        "pagination.next", "Následujúce"),
                "sk", BMap.of(
                        "pagination.prev", "Predchádzajúce",
                        "pagination.next", "Nasledujúce"));

        SheetContent expected = new SheetContent(
                Arrays.asList("key", "primary", "cz", "sk"),
                Arrays.asList(
                        Arrays.asList("pagination.prev", "Prev", null, null),
                        Arrays.asList("price.zeroPriceString", "Free", null, null)
                )
        );

        MessageFileProcessor mfProcessor = new MessageFileProcessor(snapshot);
        Pair<SheetContent, MessageFileExportStats> result = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo);
        assertEquals(expected, result.getFirst());
    }

    @Test
    public void whenTranslationIsMissingAValueForALanguageThenTheMissingValueIsInCorrectPlace() {
        FakeTranslationSnapshot snapshot = new FakeTranslationSnapshot(BMap.of(
                "i18n/errors.properties", BMap.of(
                        "error.command.securityBreach", "Zdá se, že jste delší dobu nebyli aktivní. Zkontrolujte, zda jste nebyli automaticky odhlášeni a opět se přihlaste nebo případně vyplňte formulář znovu.",
                        "error.exceptionhandler.missingMandatoryValue", "Vyžadována povinná hodnota, ale ta chybí!")));

        Map<String, String> primaryMessages = BMap.of(
                "error.command.securityBreach", "Zdá se, že jste delší dobu nebyli aktivní. Zkontrolujte, zda jste nebyli automaticky odhlášeni a opět se přihlaste nebo případně vyplňte formulář znovu.",
                "error.exceptionhandler.missingMandatoryValue", "Vyžadována povinná hodnota, ale ta chybí!");

        List<String> translateTo = Arrays.asList("de", "sk");
        Map<String, Map<String, String>> translations = BMap.of(
                "de", BMap.of(
                        "error.exceptionhandler.missingMandatoryValue", "Pflichtfeld erforderlich, fehlt aber!"),
                "sk", BMap.of(
                        "error.command.securityBreach", "Zdá sa, že ste dlhšiu dobu neboli aktívni. Skontrolujte, či ste neboli automaticky odhlásení, a opäť sa prihláste, prípadne vyplňte formulár odznova.",
                        "error.exceptionhandler.missingMandatoryValue", "Vyžaduje sa povinná hodnota, ale tá chýba!"));

        SheetContent expected = new SheetContent(
                Arrays.asList("key", "primary", "de", "sk"),
                Collections.singletonList(
                        Arrays.asList("error.command.securityBreach",
                                "Zdá se, že jste delší dobu nebyli aktivní. Zkontrolujte, zda jste nebyli automaticky odhlášeni a opět se přihlaste nebo případně vyplňte formulář znovu.",
                                null,
                                "Zdá sa, že ste dlhšiu dobu neboli aktívni. Skontrolujte, či ste neboli automaticky odhlásení, a opäť sa prihláste, prípadne vyplňte formulár odznova.")
                )
        );

        MessageFileProcessor mfProcessor = new MessageFileProcessor(snapshot);
        Pair<SheetContent, MessageFileExportStats> result = mfProcessor.prepareTranslationSheet("i18n/errors.properties", primaryMessages, translations, translateTo);
        assertEquals(expected, result.getFirst());
    }

    private static class BMap {
        public static <T> Map<String, T> of(Object... values) {
            Map<String, T> map = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                if (i % 2 == 0) {
                    String key = (String) values[i];
                    T value = (T) values[i + 1];
                    map.put(key, value);
                }
            }


            return map;
        }

    }
}