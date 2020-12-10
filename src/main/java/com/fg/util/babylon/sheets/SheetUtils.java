package com.fg.util.babylon.sheets;

import com.fg.util.babylon.SheetConstants;
import com.fg.util.babylon.entity.MessageFileContent;
import com.fg.util.babylon.entity.PropertiesMap;
import com.fg.util.babylon.enums.PropertyStatus;
import org.apache.commons.io.FilenameUtils;

import java.util.*;

/**
 * Deals with sheets, but outside of Google Sheets API. Only prepares data. Soon to be deprecated.
 */
public class SheetUtils {

    public String getSheetName(String msgFilePath, Integer msgFileId) {
        return FilenameUtils.getBaseName(msgFilePath) + "#" + msgFileId;
    }

}
