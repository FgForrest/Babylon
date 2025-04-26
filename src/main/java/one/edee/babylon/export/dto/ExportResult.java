package one.edee.babylon.export.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExportResult {

    private final List<String> pathsOfNewMsgFiles;

    private final List<TranslationSheet> sheets;

}
