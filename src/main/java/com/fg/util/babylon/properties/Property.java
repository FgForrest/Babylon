package com.fg.util.babylon.properties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Basic class for property value.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@AllArgsConstructor
public class Property {

    private String value;

    public final boolean isPropValue() {
        return this instanceof PropValue;
    }

    public final boolean isPropValueMultiLine() {
        return this instanceof PropValueMultiLine;
    }

    final boolean isPropEmptyLine() {
        return this instanceof PropEmptyLine;
    }

    final boolean isPropComment() {
        return this instanceof PropComment;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "value='" + value + '\'' +
                '}';
    }
}
