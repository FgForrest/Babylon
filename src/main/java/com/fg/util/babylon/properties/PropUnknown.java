package com.fg.util.babylon.properties;

/**
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class PropUnknown extends Property {

    PropUnknown(String value) {
        super(value);
    }

    @Override
    public void setValue(String value) {
    }

    @Override
    public String getValue() {
        return "";
    }
}
