package com.fg.util.babylon.sheets;

import org.apache.commons.io.FilenameUtils;

/**
 * Deals with sheets, but outside of Google Sheets API. Only prepares data. Soon to be deprecated.
 */
public class SheetUtils {

    public String getSheetName(String msgFilePath, Integer msgFileId) {
        return FilenameUtils.getBaseName(msgFilePath) + "#" + msgFileId;
    }

}
