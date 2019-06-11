package com.fg.util.babylon.properties;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Property value (key=value) with multi line value escaped by '\'. *
 * This class contains list of all values for each line of this multiline value.
 * {@link PropValueMultiLine#getValue()} method is overridden to return value as single string separated by '\' + line separator.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class PropValueMultiLine extends Property {

    static final String MULTILINE_SEPARATOR = "\\";

    private List<String> lines = new LinkedList<>();

    void addLine(String line) {
        lines.add(line.replace(System.lineSeparator(), ""));
    }

    Integer getRowCount() {
        return lines.size();
    }

    @Override
    public void setValue(String value) {
        if (StringUtils.isEmpty(value)) {
            lines.clear();
            return;
        }
        String[] split = value.split("\\\\\r\n");
        lines.clear();
        for (int i=0 ; i < split.length ; i++) {
            String line = split[i];
            if (i < split.length-1 && !line.endsWith(MULTILINE_SEPARATOR)) {
                line += MULTILINE_SEPARATOR;
            }
            lines.add(line);
        }
    }

    @Override
    public String getValue() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i < lines.size() ; i++) {
            String line = lines.get(i);
            sb.append(line);
            if (i < lines.size()-1 && !line.endsWith(System.lineSeparator())) {
                sb.append(System.lineSeparator());
            }
        }
        log.info(sb.toString());
        return sb.toString();
    }

    PropValueMultiLine(String value) {
        super(value);
    }
}
