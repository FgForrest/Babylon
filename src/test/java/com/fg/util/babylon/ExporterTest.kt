package com.fg.util.babylon

import junit.framework.Assert.assertEquals
import org.junit.Test

class ExporterTest {

    @Test
    fun `when translation bundle is empty then all messages are exported for translation`() {
        val exporter = Exporter()
        val primaryMsgBundle: Map<MsgFilePath, Messages> =
                mapOf(
                        "i18n/common.properties" to mapOf(
                                "pagination.prev" to "Previous",
                                "pagination.next" to "Next",
                                "price.zeroPriceString" to "Free"),
                        "i18n/country.properties" to mapOf(
                                "country.CZ" to "Czech Republic",
                                "country.SK" to "Slovakia",
                                "country.AT" to "Austria",
                        )
                )
        val emptyBundles = emptyMap<Language, MessageBundle>()
        val noChanges = emptyMap<MsgFilePath, List<MessageKey>>()

        val expected = mapOf(
                "i18n/common.properties" to listOf(
                        listOf("pagination.prev", "Previous", null),
                        listOf("pagination.next", "Next", null),
                        listOf("price.zeroPriceString", "Free", null)
                ),
                "i18n/country.properties" to listOf(
                        listOf("country.CZ", "Czech Republic", null),
                        listOf("country.SK", "Slovakia", null),
                        listOf("country.AT", "Austria", null)
                )
        )

        val sheets = exporter.export(listOf("sk"), primaryMsgBundle, emptyBundles, noChanges)
        assertEquals(expected, sheets)
    }

}