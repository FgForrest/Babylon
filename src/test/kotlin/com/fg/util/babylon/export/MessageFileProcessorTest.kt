package com.fg.util.babylon.export

import junit.framework.Assert.assertEquals
import org.junit.Test

class MessageFileProcessorTest {

    @Test
    fun `when a message has translations for all desired languages and has not changed from snaphost then it is not included in the translation sheet`() {
        val snapshot = FakeTranslationSnapshot(mapOf(
                "i18n/common.properties" to mapOf(
                        "pagination.prev" to "Previous",
                        "pagination.next" to "Next")))

        val primaryMessages = mapOf(
                "pagination.prev" to "Previous",
                "pagination.next" to "Next")

        val translateTo = listOf("cz", "sk")
        val translations = mapOf(
                "cz" to mapOf(
                        "pagination.prev" to "Předchozí",
                        "pagination.next" to "Následující"),
                "sk" to mapOf(
                        "pagination.prev" to "Predchádzajúce",
                        "pagination.next" to "Nasledujúce"))

        val expected = SheetContent(
                listOf("key", "primary", "cz", "sk"),
                emptyList()
        )

        val mfProcessor = MessageFileProcessor(snapshot)
        val (sheet, _) = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo)
        assertEquals(expected, sheet)
    }

    @Test
    fun `when no snapshot of previous translation and no translations then all messages are exported to translation sheet`() {
        val emptySnapshot = FakeTranslationSnapshot(emptyMap())

        val primaryMessages = mapOf(
                "pagination.prev" to "Previous",
                "pagination.next" to "Next",
                "price.zeroPriceString" to "Free")

        val translateTo = listOf("cz", "sk")
        val noTranslations = emptyMap<Language, Messages>()

        val expected = SheetContent(
                listOf("key", "primary", "cz", "sk"),
                listOf(
                        listOf("pagination.prev", "Previous", null, null),
                        listOf("pagination.next", "Next", null, null),
                        listOf("price.zeroPriceString", "Free", null, null)
                )
        )

        val mfProcessor = MessageFileProcessor(emptySnapshot)
        val (sheet, _) = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, noTranslations, translateTo)
        assertEquals(expected, sheet)
    }

    @Test
    fun `when there is a new primary message file then its messages are exported to translation sheet, but the messages already in snapshot are not`() {
        val snapshot = FakeTranslationSnapshot(
                mapOf("i18n/common.properties" to mapOf(
                        "pagination.prev" to "Previous",
                        "pagination.next" to "Next",
                        "price.zeroPriceString" to "Free")))

        val primaryMessages = mapOf(
                "pagination.prev" to "Previous",
                "pagination.next" to "Next",
                "price.zeroPriceString" to "Free",
                "availability.text.ALWAYS_AVAILABLE" to "Always in stock",
                "availability.text.NOT_AVAILABLE" to "Momentarily unavailable")

        val translateTo = listOf("cz", "sk")
        val translations = mapOf(
                "cz" to mapOf(
                        "pagination.prev" to "Předchozí",
                        "pagination.next" to "Následující",
                        "price.zeroPriceString" to "Zdarma"),
                "sk" to mapOf(
                        "pagination.prev" to "Predchádzajúce",
                        "pagination.next" to "Nasledujúce",
                        "price.zeroPriceString" to "Zadarmo"))

        val expected = SheetContent(
                listOf("key", "primary", "cz", "sk"),
                listOf(
                        listOf("availability.text.ALWAYS_AVAILABLE", "Always in stock", null, null),
                        listOf("availability.text.NOT_AVAILABLE", "Momentarily unavailable", null, null)
                )
        )

        val mfProcessor = MessageFileProcessor(snapshot)
        val (sheet, _) = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo)
        assertEquals(expected, sheet)
    }

    @Test
    fun `when a message is missing some translations then the message values existing translations are included in the translation sheet`() {
        val emptySnapshot = FakeTranslationSnapshot(emptyMap())

        val primaryMessages = mapOf(
                "pagination.prev" to "Previous",
                "pagination.next" to "Next",
                "price.zeroPriceString" to "Free")

        val translateTo = listOf("cz", "sk")
        val translations = mapOf(
                "cz" to mapOf(
                        "pagination.prev" to "Předchozí"),
                "sk" to mapOf(
                        "pagination.next" to "Nasledujúce")
        )

        val expected = SheetContent(
                listOf("key", "primary", "cz", "sk"),
                listOf(
                        listOf("pagination.prev", "Previous", "Předchozí", null),
                        listOf("pagination.next", "Next", null, "Nasledujúce"),
                        listOf("price.zeroPriceString", "Free", null, null)
                )
        )

        val mfProcessor = MessageFileProcessor(emptySnapshot)
        val (sheet, _) = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo)
        assertEquals(expected, sheet)
    }

    @Test
    fun `when a message is present in snapshot but is missing from primary message file then it is not exported to translation sheet`() {
        val snapshot = FakeTranslationSnapshot(mapOf(
                "i18n/common.properties" to mapOf(
                        "pagination.prev" to "Previous",
                        "pagination.next" to "Next",
                        "price.zeroPriceString" to "Free")))

        val primaryMessages = mapOf(
                "pagination.prev" to "Previous",
                "pagination.next" to "Next",
                "availability.text.ALWAYS_AVAILABLE" to "Always in stock",
                "availability.text.NOT_AVAILABLE" to "Momentarily unavailable")

        val translateTo = listOf("cz", "sk")
        val translations = mapOf(
                "cz" to mapOf(
                        "pagination.prev" to "Předchozí",
                        "pagination.next" to "Následující"),
                "sk" to mapOf(
                        "pagination.prev" to "Predchádzajúce",
                        "pagination.next" to "Nasledujúce"))

        val expected = SheetContent(
                listOf("key", "primary", "cz", "sk"),
                listOf(
                        listOf("availability.text.ALWAYS_AVAILABLE", "Always in stock", null, null),
                        listOf("availability.text.NOT_AVAILABLE", "Momentarily unavailable", null, null)
                )
        )

        val mfProcessor = MessageFileProcessor(snapshot)
        val (sheet, _) = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo)
        assertEquals(expected, sheet)
    }

    @Test
    fun `when a message differs from the value in snapshot then all translations for this messages are empty in the translation sheet`() {
        val snapshot = FakeTranslationSnapshot(mapOf(
                "i18n/common.properties" to mapOf(
                        "pagination.prev" to "Previous",
                        "pagination.next" to "Next",
                        "price.zeroPriceString" to "Free")))

        val primaryMessages = mapOf(
                "pagination.prev" to "Prev",
                "pagination.next" to "Next",
                "price.zeroPriceString" to "Free")

        val translateTo = listOf("cz", "sk")
        val translations = mapOf(
                "cz" to mapOf(
                        "pagination.prev" to "Předchozí",
                        "pagination.next" to "Následující"),
                "sk" to mapOf(
                        "pagination.prev" to "Predchádzajúce",
                        "pagination.next" to "Nasledujúce"))

        val expected = SheetContent(
                listOf("key", "primary", "cz", "sk"),
                listOf(
                        listOf("pagination.prev", "Prev", null, null),
                        listOf("price.zeroPriceString", "Free", null, null)
                )
        )

        val mfProcessor = MessageFileProcessor(snapshot)
        val (sheet, _) = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo)
        assertEquals(expected, sheet)
    }

    @Test
    fun `when translation is missing a value for a language then the missing value is in correct place`() {
        val snapshot = FakeTranslationSnapshot(mapOf(
                "i18n/errors.properties" to mapOf(
                        "error.command.securityBreach" to "Zdá se, že jste delší dobu nebyli aktivní. Zkontrolujte, zda jste nebyli automaticky odhlášeni a opět se přihlaste nebo případně vyplňte formulář znovu.",
                        "error.exceptionhandler.missingMandatoryValue" to "Vyžadována povinná hodnota, ale ta chybí!")))

        val primaryMessages = mapOf(
                "error.command.securityBreach" to "Zdá se, že jste delší dobu nebyli aktivní. Zkontrolujte, zda jste nebyli automaticky odhlášeni a opět se přihlaste nebo případně vyplňte formulář znovu.",
                "error.exceptionhandler.missingMandatoryValue" to "Vyžadována povinná hodnota, ale ta chybí!")

        val translateTo = listOf("de", "sk")
        val translations = mapOf(
                "de" to mapOf(
                        "error.exceptionhandler.missingMandatoryValue" to "Pflichtfeld erforderlich, fehlt aber!"),
                "sk" to mapOf(
                        "error.command.securityBreach" to "Zdá sa, že ste dlhšiu dobu neboli aktívni. Skontrolujte, či ste neboli automaticky odhlásení, a opäť sa prihláste, prípadne vyplňte formulár odznova.",
                        "error.exceptionhandler.missingMandatoryValue" to "Vyžaduje sa povinná hodnota, ale tá chýba!"))

        val expected = SheetContent(
                listOf("key", "primary", "de", "sk"),
                listOf(
                listOf("error.command.securityBreach",
                        "Zdá se, že jste delší dobu nebyli aktivní. Zkontrolujte, zda jste nebyli automaticky odhlášeni a opět se přihlaste nebo případně vyplňte formulář znovu.",
                        null,
                        "Zdá sa, že ste dlhšiu dobu neboli aktívni. Skontrolujte, či ste neboli automaticky odhlásení, a opäť sa prihláste, prípadne vyplňte formulár odznova.")
                )
        )

        val mfProcessor = MessageFileProcessor(snapshot)
        val (sheet, _) = mfProcessor.prepareTranslationSheet("i18n/errors.properties", primaryMessages, translations, translateTo)
        assertEquals(expected, sheet)
    }

}