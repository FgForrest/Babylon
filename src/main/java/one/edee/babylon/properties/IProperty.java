package one.edee.babylon.properties;

/**
 * TODO VKR get rid of interface with single implementation ... merge it with Property class please
 * or is there an expectation that someone will need to exchange this?
 */
public interface IProperty {

    boolean isPropValue();

    boolean isPropEmptyLine();

    boolean isPropComment();

    boolean isPropValueMultiLine();

    Integer getRowCount();

    String getValue();

    void setValue(String value);

}
