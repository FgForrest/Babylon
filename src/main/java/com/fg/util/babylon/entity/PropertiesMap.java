package com.fg.util.babylon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fg.util.babylon.enums.PropertyStatus;
import lombok.extern.apachecommons.CommonsLog;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Properties with its statuses like {@link PropertyStatus} and protection from null values.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@CommonsLog
public class PropertiesMap extends LinkedHashMap<String, String> {

    /**
     * Statuses of all properties. Property isn't serialized to Json file.
     */
    @JsonIgnore
    private Map<String, PropertyStatus> propertiesStatus = new HashMap<>();

    @Override
    public String put(String key, String value) {
        if (value == null) {
            value = "";
        }
        return super.put(key, value);
    }

    /**
     * Puts property value and its status at once.
     * @param key
     * @param value
     * @param propertyStatus State to be set.
     * @return Old value of property or null if no property exists for given key.
     */
    public String put(String key, String value, PropertyStatus propertyStatus) {
        String result = super.put(key, value);
        putPropertyStatus(key, propertyStatus);
        return result;
    }

    /**
     * Changes state of property by specified key externally.
     * @param key
     * @param propertyStatus
     * @return Previous {@link PropertyStatus} of property.
     */
    public PropertyStatus putPropertyStatus(String key, PropertyStatus propertyStatus) {
        log.debug("Put property status: " + key + " -> " + propertyStatus.name());
        return propertiesStatus.put(key, propertyStatus);
    }

    /**
     * Get {@link PropertyStatus} by key.
     * @param key
     * @return Actual {@link PropertyStatus} of property.
     */
    public PropertyStatus getPropertyStatus(String key) {
        return propertiesStatus.get(key);
    }

}
