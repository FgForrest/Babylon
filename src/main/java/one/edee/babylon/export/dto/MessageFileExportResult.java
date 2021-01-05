package one.edee.babylon.export.dto;

import one.edee.babylon.export.stats.MessageFileExportStats;
import lombok.Data;

/**
 * Represent result of an export of a single message file, including the translation sheet data and
 * the number statistics explaining what happened during the processing.
 */
@Data
public class MessageFileExportResult {

    final TranslationSheet translationSheet;

    final MessageFileExportStats exportStats;

}
