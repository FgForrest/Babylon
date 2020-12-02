package com.fg.util.babylon.export.data;

import lombok.Data;

import java.util.List;

@Data
public class ExportResult {

    private final Iterable<String> pathsOfNewMsgFiles;

    private final List<TranslationSheet> sheets;

}
