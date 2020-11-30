package com.fg.util.babylon.export

import com.fg.util.babylon.processor.I18nFileManager
import com.fg.util.babylon.propfiles.Property
import com.fg.util.babylon.todo.TranslationFileUtils
import java.lang.IllegalArgumentException

class OldMessageLoaderAdaptor(private val i18nFileManager: I18nFileManager) : MessageLoader {

    override fun loadPrimaryMessages(filePath: String): Messages {
        val propertyFileAR = i18nFileManager.loadPropertiesFromFile(filePath)
                ?: throw IllegalArgumentException("Message file '$filePath' could not be found.")
        return dumpPropertyFile(propertyFileAR)
    }

    override fun loadTranslations(primaryFilePath: String, languages: List<Language>): Map<Language, Messages> =
            languages.map { lang ->
                val translationFilePath = TranslationFileUtils.getFileNameForTranslation(primaryFilePath, lang)!!
                val translationFileAR = i18nFileManager.loadPropertiesFromFile(translationFilePath) ?: emptyMap()
                val translationFileContent = dumpPropertyFile(translationFileAR)
                lang to translationFileContent
            }.associateBy({ it.first }, { it.second })

    private fun dumpPropertyFile(propertyFile: Map<String?, Property?>): Messages =
            propertyFile
                    .filterKeys { it != null }
                    .filterValues { it != null }
                    .filterValues { msgProperty -> msgProperty!!.isPropValue or msgProperty.isPropValueMultiLine }
                    .map { (msgKey, msgProperty) -> msgKey!! to msgProperty?.value!! }
                    .associateBy({ it.first }, { it.second })

}