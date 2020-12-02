package com.fg.util.babylon.export.stats;

import lombok.Data;

@Data
public class MessageFileExportStats {

    public MessageFileExportStats(int newPrimaryMsgKeyCount, int changedPrimaryMsgKeyCount, int missingTranslationMsgKeyCount) {
        this.newPrimaryMsgKeyCount = newPrimaryMsgKeyCount;
        this.changedPrimaryMsgKeyCount = changedPrimaryMsgKeyCount;
        this.missingTranslationMsgKeyCount = missingTranslationMsgKeyCount;
    }

    private int newPrimaryMsgKeyCount;

    private int changedPrimaryMsgKeyCount;

    private int missingTranslationMsgKeyCount;

}
