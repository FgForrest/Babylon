package com.fg.util.babylon.endtoend.export

import com.fg.util.babylon.db.DataFileManager
import com.fg.util.babylon.entity.Arguments
import com.fg.util.babylon.entity.TranslationConfiguration
import com.fg.util.babylon.enums.Action
import com.fg.util.babylon.processor.ExportProcessor
import com.fg.util.babylon.service.GoogleSheetService

class ExportTest {

    fun `when translation data file is empty (first time export) then all localized strings are exported for translation`() {
        val gss = GoogleSheetService()

        val trSettings = Arguments()
        trSettings.action = Action.EXPORT
        trSettings.googleSheetId = "???"
        trSettings.configFileName = "???"

        val trConfig = TranslationConfiguration()
        trConfig.dataFileName = "???"

        val dfm = DataFileManager(trConfig.dataFileName)
        val ep = ExportProcessor(gss, dfm, trSettings, trConfig)

        ep.startTranslation()


    }

}