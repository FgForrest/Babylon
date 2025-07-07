package one.edee.babylon.sheets;

import org.apache.commons.io.FilenameUtils;

/**
 * Deals with sheets, but outside of Google Sheets API. Only prepares data. Soon to be deprecated.
 */
public class SheetUtils {

    public String getSheetName(String msgFilePath, Integer msgFileId) {
        return msgFileId  + "#" + FilenameUtils.getBaseName(msgFilePath);
    }

}
