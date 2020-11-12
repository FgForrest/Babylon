package com.fg.util.babylon

class Exporter {

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
    fun export(translationLangs: List<Language>,
               primaryMsgBundle: MessageBundle,
               translationMsgBundles: Map<Language, MessageBundle>,
               keysOfMsgsChangedPrimaryMsgs: Map<MsgFilePath, List<MessageKey>>): Map<MsgFilePath, SheetRows> {

        /** when a new translation language is specified, it does not have a message bundle yet */
        val missingTranslationBundleLangs = translationLangs - translationMsgBundles.keys

        /** empty bundles for new translation languages */
        val emptyTranslationBundles = missingTranslationBundleLangs.associateWith { emptyMessageBundle() }

        /** translation bundles for all [translationLangs] */
        val allTranslationBundles = translationMsgBundles + emptyTranslationBundles


        /** for each translation language - message keys where translation is missing, associated by the files containing them */
        val missingKeys = determineMissingTranslatedMsgs(primaryMsgBundle, translationMsgBundles)

        /** for each message file - message keys where translation in some of the translation language is missing */
        val keysOfMissingTranslations = aggregateMissingKeysOfEachFile(missingKeys)


        return createTranslationSheets(primaryMsgBundle, allTranslationBundles, translationLangs, keysOfMissingTranslations, keysOfMsgsChangedPrimaryMsgs)
    }

    /**
     * map of message keys that are missing in translated messages TODO
     */
    private fun determineMissingTranslatedMsgs(primaryMsgBundle: MessageBundle,
                                               translationMsgBundles: Map<Language, MessageBundle>): Map<Language, Map<MsgFilePath, Set<MessageKey>>> =
            translationMsgBundles.mapValues { (language, msgBundle) ->
                msgBundle.mapValues { (msgFilePath, messages) ->
                    /** keys of non-empty messages in this translation file */
                    val nonEmptyTrnMsgKeys = messages.filterValues { msg -> msg != null }.keys

                    /**
                     *  difference between the set of primary keys and the set of already translated keys of this mutation
                     *  makes the set of keys whose messages need to be translated for this language
                     */
                    val thisLanguageMissingKeys = primaryMsgBundle[msgFilePath].orEmpty().keys - nonEmptyTrnMsgKeys
                    thisLanguageMissingKeys
                }
            }

    private fun aggregateMissingKeysOfEachFile(missingKeys: Map<Language, Map<MsgFilePath, Set<MessageKey>>>): Map<MsgFilePath, List<MessageKey>> =
            missingKeys.values.flatMap { pathToMsgKeys ->
                pathToMsgKeys.asSequence().flatMap { (path, msgKeys) ->
                    msgKeys.map { msgKey -> path to msgKey }
                }
            }.distinct().groupBy({ it.first }, { it.second })


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
    private fun createTranslationSheets(primaryBundle: MessageBundle,
                                        translationBundles: Map<Language, MessageBundle>,
                                        translationLangs: List<Language>,
                                        missingTranslations: Map<MsgFilePath, List<MessageKey>>,
                                        changedPrimaryMsgs: Map<MsgFilePath, List<MessageKey>>): Map<MsgFilePath, SheetRows> {
        val allFiles = missingTranslations.keys + changedPrimaryMsgs.keys
        return allFiles.map { msgFile ->
            val thisFileMissingTransKeys = missingTranslations[msgFile].orEmpty()
            val thisFileChangedMsgKeys = changedPrimaryMsgs[msgFile].orEmpty()
            val sheet = createTranslationSheet(primaryBundle, translationBundles, translationLangs, msgFile, thisFileMissingTransKeys, thisFileChangedMsgKeys)
            msgFile to sheet
        }.toMap()
    }

    /**
     * Create a translation sheet for a single message file.
     *
     * @param msgFile message file for that the translation sheet will be prepared
     */
    private fun createTranslationSheet(primaryBundle: MessageBundle,
                                       translationBundles: Map<Language, MessageBundle>,
                                       translationLangs: List<Language>,
                                       msgFile: MsgFilePath,
                                       thisFileMissingTransKeys: List<MessageKey>,
                                       thisFileChangedMsgKeys: List<MessageKey>): SheetRows {
        val populatedRows = thisFileMissingTransKeys.map { msgKey ->
            populateSheetRow(primaryBundle, translationBundles, translationLangs, msgFile, msgKey)
        }

        val blankRows = thisFileChangedMsgKeys.map { msgKey ->
            val primaryMsg = primaryBundle[msgFile]?.get(msgKey)
            listOf(primaryMsg)
        }

        return blankRows + populatedRows
    }

    /**
     * Creates a single row in a translation sheet.
     */
    private fun populateSheetRow(primaryBundle: MessageBundle,
                                 translationBundles: Map<Language, Map<MsgFilePath, Messages>>,
                                 translationLangs: List<Language>,
                                 msgFile: MsgFilePath,
                                 messageKey: MessageKey): SheetRow {
        val primaryMsg = primaryBundle[msgFile]?.get(messageKey)
        val translatedMsgs = translationLangs.map { lang ->
            translationBundles[lang]?.get(msgFile)?.get(messageKey)
        }
        // if the primary message is missing, there is nothing to translate
        // TODO log warning
        return if (primaryMsg !== null) listOf(primaryMsg) + translatedMsgs else emptyList()
    }

}

fun emptyMessageBundle(): MessageBundle = emptyMap()

typealias MessageBundle = Map<MsgFilePath, Messages>

typealias Messages = Map<MessageKey, Message>

typealias MsgFilePath = String

typealias Message = String?

typealias MessageKey = String

typealias Language = String

typealias SheetRows = List<SheetRow>

typealias SheetRow = List<String?>