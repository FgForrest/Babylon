package com.fg.util.babylon.export

import com.fg.util.babylon.gsheet.SheetUtils
import com.fg.util.babylon.processor.AntPathResourceLoader
import com.fg.util.babylon.util.PathUtils

/**
 * Performs the "export" part of the translation synchronization.
 */
class Exporter(private val messageLoader: MessageLoader,
               private val messageFileProcessor: MessageFileProcessor,
               private val resourceLoader: AntPathResourceLoader,
               private val snapshotReadContract: TranslationSnapshotReadContract,
               private val snapshotWriteContract: TranslationSnapshotWriteContract) {

    /**
     * Collects message files and given a list of languages to translate to, generates a translation sheet
     * that contains messages in primary language and possibly existing translated messages, if the translated message
     * exists for given language and unless invalidated by the change to its primary message.
     *
     * @param patternPaths paths to message files, might contain Ant-style patterns
     * @param translateTo list of languages to translate to
     */
    fun walkPathsAndCollectTranslationSheets(patternPaths: List<String>,
                                             translateTo: List<Language>): ExportResult {
        val allPaths = patternPaths.flatMap { path ->
            PathUtils().expandPath(path, resourceLoader)
        }
        val newMsgFilesPaths = allPaths.filter { msgFilePath ->
            !snapshotReadContract.includesMsgFile(msgFilePath)
        }

        val sheets = allPaths.map { msgFilePath ->
            processMsgFile(msgFilePath, translateTo)
        }
        
        return ExportResult(newMsgFilesPaths, sheets)
    }

    private fun processMsgFile(msgFilePath: String, translateTo: List<Language>): TranslationSheet {
        val sheetRows = computeTranslationSheetRows(msgFilePath, translateTo)
        val sheetId = snapshotWriteContract.registerMsgFile(msgFilePath)
        return newTranslationSheet(sheetRows, sheetId, msgFilePath, translateTo)
    }

    private fun computeTranslationSheetRows(msgFilePath: String, translateTo: List<Language>): SheetRows {
        val primaryMsgs = messageLoader.loadPrimaryMessages(msgFilePath)
        val translations = messageLoader.loadTranslations(msgFilePath, translateTo)

        return messageFileProcessor.prepareTranslationSheet(msgFilePath, primaryMsgs, translations, translateTo)
    }

    private fun newTranslationSheet(sheetRows: SheetRows, sheetId: Int, msgFilePath: String, translateTo: List<Language>): TranslationSheet {
        val header = createSheetHeader(msgFilePath, translateTo)
        val sheetName = SheetUtils().getSheetName(msgFilePath, sheetId)
        val allRows = listOf(header) + sheetRows
        return TranslationSheet(sheetName, allRows)
    }

    private fun createSheetHeader(msgFilePath: String, targetLangs: List<Language>): SheetRow =
            listOf("key", "primary") + targetLangs

    data class ExportResult(val pathsOfNewMsgFiles: Iterable<String>,
                            val sheets: List<TranslationSheet>)

    data class TranslationSheet(val sheetName: String,
                                val rows: SheetRows) {

        val dataRows: SheetRows
            get() = rows.subList(1, rows.size)

        val header: SheetRows
            get() = rows.subList(0, 1)

    }

}

typealias Messages = Map<MessageKey, Message>

typealias MsgFilePath = String

typealias Message = String?

typealias MessageKey = String

typealias Language = String

typealias SheetRows = List<SheetRow>

typealias SheetRow = List<String?>