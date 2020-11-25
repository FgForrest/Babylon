package com.fg.util.babylon.export

import junit.framework.Assert.assertEquals
import org.junit.Test

class MessageFileProcessorTest {

    @Test
    fun `when no snapshot of previous translation and no translations then all messages are exported to translation sheet`() {
        val emptySnapshot = FakeTranslationSnapshot(emptyMap())

        val primaryMessages = mapOf(
                "pagination.prev" to "Previous",
                "pagination.next" to "Next",
                "price.zeroPriceString" to "Free")

        val translateTo = listOf("cz", "sk")
        val noTranslations = emptyMap<Language, Messages>()

        val expected = listOf(
                listOf("pagination.prev", "Previous", null, null),
                listOf("pagination.next", "Next", null, null),
                listOf("price.zeroPriceString", "Free", null, null))

        val mfProcessor = MessageFileProcessor(emptySnapshot)
        val sheet = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, noTranslations, translateTo)
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

        val expected = listOf(
                listOf("availability.text.ALWAYS_AVAILABLE", "Always in stock", null, null),
                listOf("availability.text.NOT_AVAILABLE", "Momentarily unavailable", null, null))

        val mfProcessor = MessageFileProcessor(snapshot)
        val sheet = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo)
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

        val expected = listOf(
                listOf("pagination.prev", "Previous", "Předchozí", null),
                listOf("pagination.next", "Next", null, "Nasledujúce", null),
                listOf("price.zeroPriceString", "Free", null, null))

        val mfProcessor = MessageFileProcessor(emptySnapshot)
        val sheet = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo)
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

        val expected = listOf(
                listOf("availability.text.ALWAYS_AVAILABLE", "Always in stock", null, null),
                listOf("availability.text.NOT_AVAILABLE", "Momentarily unavailable", null, null))

        val mfProcessor = MessageFileProcessor(snapshot)
        val sheet = mfProcessor.prepareTranslationSheet("i18n/common.properties", primaryMessages, translations, translateTo)
        assertEquals(expected, sheet)
    }

}