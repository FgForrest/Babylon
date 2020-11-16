package com.fg.util.babylon

class MessageFileProcessor(private val snapshotContract: TranslationSnapshotContract) {

    fun prepareTranslationSheet(msgFile: MsgFilePath,
                                primaryMsgs: Messages,
                                translations: Map<Language, Messages>,
                                translationLangs: List<Language>): SheetRows {
        val newMessageKeys = determineNewPrimaryMessages(msgFile, primaryMsgs)
        val existingMessages = primaryMsgs - newMessageKeys
        val keysOfChangedMsgs = determineChangedPrimaryMsgs(msgFile, existingMessages)
        val keysOfMissingTranslations = determineMissingTranslatedMsgs(existingMessages, translations.values)
        return createTranslationSheet(msgFile, primaryMsgs, translations, translationLangs, newMessageKeys, keysOfChangedMsgs, keysOfMissingTranslations)
    }

    private fun determineNewPrimaryMessages(msgFile: MsgFilePath,
                                            primaryMsgs: Map<MessageKey, Message>): Set<MessageKey> =
            // if message file is not present in snapshot, it is a new message file and all its messages are new
            if (!snapshotContract.includesMsgFile(msgFile)) {
                primaryMsgs.keys
            } else {
                primaryMsgs.keys.filter { msgKey ->
                    // if message is not present in snapshot, it is a new message
                    !snapshotContract.containsMessage(msgKey, msgFile)
                }.toSet()
            }

    /**
     * @return set of keys of messaged that changed since last translation
     */
    private fun determineChangedPrimaryMsgs(msgFile: String,
                                            existingPrimaryMsgs: Messages): Set<MessageKey> =
            existingPrimaryMsgs.filter { (msgKey, currentMsg) ->
                snapshotContract.getLastMessageValue(msgKey, msgFile) != currentMsg
            }.keys

    /**
     * Given primary language messages and corresponding translations, returns keys of messages that are missing
     * in at least one translation
     */
    private fun determineMissingTranslatedMsgs(primaryMsgs: Messages,
                                               translations: Collection<Messages>): Set<MessageKey> {
        /** keys of messages that are not empty */
        val nonEmptyMsgKeys = translations.map { msgs ->
            msgs.filterValues { !it.isNullOrEmpty() }.keys
        }
        val keysInEveryTranslationBundle = if (nonEmptyMsgKeys.isEmpty())
            // reduce doesn't work on empty collection, fold doesn't play well with intersection operation
            emptySet()
        else
            nonEmptyMsgKeys.reduce { acc: Set<MessageKey>, messageKeys ->
                acc.intersect(messageKeys)
            }

        return primaryMsgs.keys - keysInEveryTranslationBundle
    }

    /**
     * Create a translation sheet for a single message file.
     *
     * @param msgFile message file for that the translation sheet will be prepared
     */
    private fun createTranslationSheet(msgFile: MsgFilePath,
                                       primaryMsgs: Messages,
                                       translations: Map<Language, Messages>,
                                       translationLangs: List<Language>,
                                       newMsgKeys: Set<MessageKey>,
                                       changedMsgKeys: Set<MessageKey>,
                                       missingTransKeys: Set<MessageKey>): SheetRows {
        val populatedRows = missingTransKeys.map { msgKey ->
            populateSheetRow(msgFile, primaryMsgs, translations, translationLangs, msgKey)
        }

        val noUsableTranslations = changedMsgKeys + newMsgKeys
        val blankRows = noUsableTranslations.map { msgKey ->
            val primaryMsg = primaryMsgs[msgKey]
            val emptyCols = translationLangs.map { null }
            createRow(msgKey, primaryMsg, emptyCols)
        }

        return blankRows + populatedRows
    }

    /**
     * Creates a single row in a translation sheet.
     */
    private fun populateSheetRow(msgFile: MsgFilePath,
                                 primaryMsgs: Messages,
                                 translations: Map<Language, Messages>,
                                 translationLangs: List<Language>,
                                 messageKey: MessageKey): SheetRow {
        val primaryMsg = primaryMsgs[messageKey]
        val translatedMsgs = translationLangs.map { lang ->
            translations[lang]?.get(messageKey)
        }
        // TODO this should not happen, these keys are filtered out - exception? asi jo
        // if the primary message is missing, there is nothing to translate
        // TODO log.warn("Primary language message file 'msgFile' contains message key '$messageKey' with no value. Message key will be ignored.")
        return if (primaryMsg != null) createRow(messageKey, primaryMsg, translatedMsgs) else listOf(messageKey)
    }

    private fun createRow(msgKey: MessageKey, primaryMsg: Message, translations: List<Message>): SheetRow =
            listOf(msgKey, primaryMsg) + translations

}