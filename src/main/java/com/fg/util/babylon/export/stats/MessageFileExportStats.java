package com.fg.util.babylon.export.stats;

import com.fg.util.babylon.export.debug.ExportStatsSheet;
import lombok.Data;

import java.util.List;

@Data
public class MessageFileExportStats {

    public MessageFileExportStats(String messageFilePath, int newPrimaryMsgKeyCount, int changedPrimaryMsgKeyCount, int missingTranslationMsgKeyCount, int sheetDataRows) {
        this.messageFilePath = messageFilePath;
        this.newPrimaryMsgKeyCount = newPrimaryMsgKeyCount;
        this.changedPrimaryMsgKeyCount = changedPrimaryMsgKeyCount;
        this.missingTranslationMsgKeyCount = missingTranslationMsgKeyCount;
        this.sheetDataRows = sheetDataRows;
    }

    private String messageFilePath;

    private int newPrimaryMsgKeyCount;

    private int changedPrimaryMsgKeyCount;

    private int missingTranslationMsgKeyCount;

    private int sheetDataRows;

}
