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
        /* TODO TLN ... tohle je z pohledu inheritance dost divné */
        return this instanceof PropValue;
    }

    public final boolean isPropValueMultiLine() {
        /* TODO TLN ... tohle je z pohledu inheritance dost divné */
        return this instanceof PropValueMultiLine;
    }

    final boolean isPropEmptyLine() {
        /* TODO TLN ... tohle je z pohledu inheritance dost divné */
        return this instanceof PropEmptyLine;
    }

    final boolean isPropComment() {
        /* TODO TLN ... tohle je z pohledu inheritance dost divné */
        return this instanceof PropComment;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "value='" + value + '\'' +
                '}';
    }
}
