package one.edee.babylon.properties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import one.edee.babylon.enums.PropertyType;

/**
 * TypeScript class for property values of all types by {@link PropertyType}
 *
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Getter
@EqualsAndHashCode(callSuper = false)
public class TsAttribute extends AbstractProperty {
    public static final String MULTI_LINE_DELIMITER = "`";
    public static final String SINGLE_LINE_DELIMITER = "'";

    @Setter
    private String value;

    public TsAttribute(PropertyType type, String value) {
        super(type);
        this.value = value;
    }

    @Override
    public String getQuotedValue() {
        String delimiter = isPropValueMultiLine() ? MULTI_LINE_DELIMITER : SINGLE_LINE_DELIMITER;

        if (isPropEmptyLine()) {
            return "";
        }
        return delimiter + value + delimiter;
    }

    @Override
    public boolean isPropValueMultiLine() {
        return getType() == PropertyType.MULTILINE
                || getValue().contains("\n")
                || getValue().contains("\r");
    }
}
