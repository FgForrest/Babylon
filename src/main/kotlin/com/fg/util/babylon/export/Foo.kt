package com.fg.util.babylon.export

import com.fg.util.babylon.gsheet.TranslationSheetService
import java.util.concurrent.atomic.AtomicInteger

class Foo(private val exporter: Exporter,
          private val tss: TranslationSheetService) {

    fun foo(patternPaths: List<String>,
            translateTo: List<Language>) {
        val result = exporter.walkPathsAndCollectTranslationSheets(patternPaths, translateTo)
        val processed = AtomicInteger()
        result.sheets.forEach { sheet ->
            tss.uploadDataToGoogleSheet(sheet.rows, sheet.sheetName, processed)
        }
    }

}