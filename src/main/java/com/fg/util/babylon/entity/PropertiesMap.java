package com.fg.util.babylon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fg.util.babylon.enums.PropertyStatus;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Properties with its statuses like {@link PropertyStatus}
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class PropertiesMap extends LinkedHashMap<String, String> {

    /**
     * Statuses of all properties. Property isn't serialized to Json file.
     */
    @JsonIgnore
    private Map<String, PropertyStatus> propertiesStatus = new HashMap<>();

    /**
     * Puts value for property for specified key and set logical working state of property like value of {@link PropertyStatus}: <br>
     * - {@link PropertyStatus#NEW} if key not exists<br>
     * - {@link PropertyStatus#CHANGED} if value of key is different than previous value<br>
     * - {@link PropertyStatus#UNCHANGED} if value of key is same<br>
     * @param key
     * @param value
     * @return Old value of property or null if no property exists for given key.
     */
    @Override
    public String put(String key, String value) {
        String result = super.put(key, value);
        if (result == null) {
            propertiesStatus.put(key, PropertyStatus.NEW);
        } else if (!result.equals(value)) {
            propertiesStatus.put(key, PropertyStatus.CHANGED);
        } else {
            propertiesStatus.put(key, PropertyStatus.UNCHANGED);
        }
        return result;
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
        propertiesStatus.put(key, propertyStatus);
        return result;
    }

    /**
     * Changes state of property by specified key externally.
     * @param key
     * @param propertyStatus
     * @return Previous {@link PropertyStatus} of property.
     */
    public PropertyStatus putPropertyStatus(String key, PropertyStatus propertyStatus) {
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
