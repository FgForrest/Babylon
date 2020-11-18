package com.fg.util.babylon.export

import com.fg.util.babylon.processor.AntPathResourceLoader
import com.fg.util.babylon.util.PathUtils

class Exporter(private val messageLoader: MessageLoader,
               private val messageFileProcessor: MessageFileProcessor,
               private val resourceLoader: AntPathResourceLoader) {

    fun walk(patternPaths: List<String>,
             translateTo: List<Language>) {
        val allPaths = patternPaths.flatMap { path ->
            PathUtils().expandPath(path, resourceLoader)
        }
        val sheetRows = allPaths.map { msgFilePath ->
            processMessageFile(msgFilePath, translateTo)
        }
    }

    private fun processMessageFile(msgFile: String,
                                   translateTo: List<Language>): SheetRows { //FIXME: abstraction for sheet? includes name/id?
        val primaryMsgs = messageLoader.loadPrimaryMessages(msgFile)
        val translations = messageLoader.loadTranslations(msgFile, translateTo)

        val sheetRows = messageFileProcessor.prepareTranslationSheet(msgFile, primaryMsgs, translations, translateTo)
        return sheetRows
    }

    // TODO: what about ordering?
    /**
     * Given primary message bundle, translation message bundles and message keys of those messages that have been
     * changed in the primary message bundle (and thus these messages are inconsistent with their translation in the translation bundles),
     * produces a "translation sheet" for each file from the bundle.
     *
     * The translation sheet row contains the key of the message in the first column,
     * the message itself in the primary language in the second column.
     * For each language from [translationLangs] a column exists in the row. In the case the primary message key is
     * contained in [keysOfMsgsChangedPrimaryMsgs], the rest of this row is filled with null value (for each language).
     * Otherwise, for each language from [translationLangs], if the translation bundle for this language contains the message,
     * it is put in the column for this language. In case this translation bundle does not contain a message, null is put
     * in this language column.
     *
     * @param primaryMsgBundle primary language message bundle
     * @param translationMsgBundles message bundles of translation languages that should be compared with the primary language
     * @param keysOfMsgsChangedPrimaryMsgs message keys of messages that have changed in the primary language since last translation
     *
     * @return content of translation sheets as a list of rows
     */
//    fun export(translationLangs: List<Language>,
//               primaryMsgBundle: MessageBundle,
//               translationMsgBundles: Map<Language, MessageBundle>,
//               keysOfMsgsChangedPrimaryMsgs: Map<MsgFilePath, List<MessageKey>>): Map<MsgFilePath, SheetRows> {
//
//        /** when a new translation language is specified, it does not have a message bundle yet */
//        val missingTranslationBundleLangs = translationLangs - translationMsgBundles.keys
//
//        /** empty bundles for new translation languages */
//        val emptyTranslationBundles = missingTranslationBundleLangs.associateWith { emptyMessageBundle() }
//
//        /** translation bundles for all [translationLangs] */
//        val allTranslationBundles = translationMsgBundles + emptyTranslationBundles
//
//
//        /**
//         * for each translation language - message keys where translation to any of the languages is missing,
//         * associated by the files containing them
//         */
//        val missingKeys = determineMissingTranslatedMsgs(primaryMsgBundle, allTranslationBundles)
//
//        /** for each message file - message keys where translation in some of the translation language is missing */
//        val keysOfMissingTranslations = aggregateMissingKeysOfEachFile(missingKeys)
//
//
//        return createTranslationSheets(primaryMsgBundle, allTranslationBundles, translationLangs, keysOfMissingTranslations, keysOfMsgsChangedPrimaryMsgs)
//    }


    /**
     * Given missing messages of translation bundles [missingTranslations] and keys of messages changed in the primary
     * message bundle [changedPrimaryMsgs], produces a content for translation sheet.
     *
     * Each row of the sheet contains the message key, original message. In case a translated message is present in some
     * translation bundles but missing in other, the existing translated messages are contained in the order of [translationLangs]
     * with null values for the languages where translation is missing.
     *
     * The sheets are associated with the message file paths.
     *
     * @param primaryBundle primary language message bundle
     * @param translationBundles message bundles for all translated languages
     * @param translationLangs for each translation language, the sheet will contain a column (with existing translated
     *  message from [translationBundles] or empty)
     * @param missingTranslations key of messages that are missing translations in any of [translationLangs] languages
     * @param changedPrimaryMsgs keys of messages that changed in the primary translation, those translations have become invalid
     *
     * @return list of rows
     */
//    private fun createTranslationSheets(primaryBundle: MessageBundle,
//                                        translationBundles: Map<Language, MessageBundle>,
//                                        translationLangs: List<Language>,
//                                        missingTranslations: Map<MsgFilePath, List<MessageKey>>,
//                                        changedPrimaryMsgs: Map<MsgFilePath, List<MessageKey>>): Map<MsgFilePath, SheetRows> {
//        val allFiles = missingTranslations.keys + changedPrimaryMsgs.keys
//        return allFiles.map { msgFile ->
//            val thisFileMissingTransKeys = missingTranslations[msgFile].orEmpty()
//            val thisFileChangedMsgKeys = changedPrimaryMsgs[msgFile].orEmpty()
//            val sheet = createTranslationSheet(primaryBundle, translationBundles, translationLangs, msgFile, thisFileMissingTransKeys, thisFileChangedMsgKeys)
//            msgFile to sheet
//        }.toMap()
//    }

}

typealias Messages = Map<MessageKey, Message>

typealias MsgFilePath = String

typealias Message = String?

typealias MessageKey = String

typealias Language = String

typealias SheetRows = List<SheetRow>

typealias SheetRow = List<String?>