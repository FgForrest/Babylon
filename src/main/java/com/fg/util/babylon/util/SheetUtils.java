package com.fg.util.babylon.util;

import com.fg.util.babylon.entity.MessageFileContent;
import org.apache.commons.io.FilenameUtils;

public class SheetUtils {

    public String getSheetName(String msgFilePath, Integer msgFileId) {
        return FilenameUtils.getBaseName(msgFilePath) + "#" + msgFileId;
    }

    public String getSheetName(String msgFilePath, MessageFileContent msgFileContent) {
        return getSheetName(msgFilePath, msgFileContent.getId());
    }

}
