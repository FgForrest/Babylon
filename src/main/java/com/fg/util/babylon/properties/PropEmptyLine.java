package com.fg.util.babylon.properties;

/**
 * Empty line in properties file.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class PropEmptyLine extends Property {

    PropEmptyLine(String value) {
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
