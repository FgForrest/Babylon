package com.fg.util.babylon.properties;

public interface IProperty {

    boolean isPropValue();

    boolean isPropEmptyLine();

    boolean isPropComment();

    boolean isPropValueMultiLine();

    Integer getRowCount();

    String getValue();

    void setValue(String value);

}
