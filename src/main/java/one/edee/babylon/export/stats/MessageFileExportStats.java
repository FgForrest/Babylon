package one.edee.babylon.export.stats;

import lombok.Data;

/**
 * Holds translation statistics for a single message file.
 */
@Data
public class MessageFileExportStats {

    public MessageFileExportStats(String messageFilePath, int newPrimaryMsgKeyCount, int changedPrimaryMsgKeyCount, int missingTranslationMsgKeyCount, int sheetDataRows) {
        this.messageFilePath = messageFilePath;
        this.newPrimaryMsgKeyCount = newPrimaryMsgKeyCount;
        this.changedPrimaryMsgKeyCount = changedPrimaryMsgKeyCount;
        this.missingTranslationMsgKeyCount = missingTranslationMsgKeyCount;
        this.sheetDataRows = sheetDataRows;
    }

    /**
     * The message file in concern.
     */
    private String messageFilePath;

    /**
     * Number of new messages in the primary language.
     */
    private int newPrimaryMsgKeyCount;

    /**
     * Number of messages whose value in the primary language has changed.
     */
    private int changedPrimaryMsgKeyCount;

    /**
     * Number of messages with missing translation for some of the translation languages.
     */
    private int missingTranslationMsgKeyCount;

    /**
     * Total number of rows in the resulting translation sheet.
     */
    private int sheetDataRows;

}
