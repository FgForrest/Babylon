package one.edee.babylon.properties;

import one.edee.babylon.enums.PropertyType;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Common class for property values of all types by {@link PropertyType}
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class Property extends AbstractProperty {

    static final String MULTILINE_SEPARATOR = "\\";

    private String value;

    /* Only for PropertyType#MULTILINE */
    private final List<String> lines = new LinkedList<>();

    public Property(PropertyType type, String value) {
        super(type);
        this.value = clearValue(value);
    }

    void addLine(String line) {
        lines.add(line.replace(System.lineSeparator(), ""));
    }

    public Integer getRowCount() {
        return lines.size();
    }

    public String getValue() {
        if (isPropValueMultiLine()) {
            return getMultilineValue();
        }
        if (isPropEmptyLine()) {
            return "";
        }
        return value;
    }

    public void setValue(String value) {
        value = clearValue(value);
        if (isPropValueMultiLine()) {
            setMultilineValue(value);
            return;
        }
        this.value = value;
    }

    private void setMultilineValue(String value) {
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

    private String getMultilineValue() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i < lines.size() ; i++) {
            String line = lines.get(i);
            sb.append(line);
            if (i < lines.size()-1 && !line.endsWith(System.lineSeparator())) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static String clearValue(String value){
        return value.replace("\n","\\n");
    }
}
