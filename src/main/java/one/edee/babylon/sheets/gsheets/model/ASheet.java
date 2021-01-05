package one.edee.babylon.sheets.gsheets.model;

/**
 * Abstraction exposing only required properties of Sheet from GSheets client library model.
 * Shields the caller of services from library model classes.
 */
public interface ASheet {

    Integer getId();

}
