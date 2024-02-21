package one.edee.babylon.properties;

import lombok.Data;
import one.edee.babylon.enums.PropertyType;

/**
 * Common class for property values of all types by {@link PropertyType}
 *
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
public abstract class AbstractProperty {

    private PropertyType type;

    protected AbstractProperty(PropertyType type) {
        this.type = type;
    }

    public abstract String getValue();

    public String getQuotedValue(){
        return getValue();
    }

    public abstract void setValue(String value);

    public boolean isPropValue() {
        return type == PropertyType.VALUE;
    }

    public boolean isPropValueMultiLine() {
        return type == PropertyType.MULTILINE;
    }

    public boolean isPropEmptyLine() {
        return type == PropertyType.EMPTY;
    }

    public boolean isPropComment() {
        return type == PropertyType.COMMENT;
    }

    @Override
    public String toString() {
        return "Property{" +
                "type=" + getType() +
                ", value='" + getValue() + '\'' +
                '}';
    }

}
