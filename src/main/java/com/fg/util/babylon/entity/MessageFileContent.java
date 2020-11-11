package com.fg.util.babylon.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fg.util.babylon.enums.PropertyStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class representing Json specification of one properties fileName with list of properties (keys and values) in {@link Snapshot}.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@NoArgsConstructor
@JsonFilter("MessageFileFilter")
public class MessageFileContent implements Serializable {

    private static final long serialVersionUID = 2426359297082283380L;

    /**
     * Unique id of relative path to source/destination properties file. This code is used like the short unique identifier
     * of the path in google sheet.
     */
    private Integer id;

    /**
     * Properties like {@link PropertiesMap}
     */
    private PropertiesMap properties = new PropertiesMap();

    /**
     * Secondary mutations properties data like {@link Map&lt;String, PropertiesMap&gt;}. Property isn't serialized to Json file.<br>
     * Map is used for transfer translated values from google sheet to target mutation properties file. <br>
     * key - contains name of the mutation e.g. "en, fr, ..."<br>
     * value - contains {@link PropertiesMap}
     */
    @JsonIgnore
    private Map<String, PropertiesMap> mutationProperties = new LinkedHashMap<>();

    /**
     * Puts value for property for specified key and set logical working state of property like value of {@link PropertyStatus}: <br>
     * - {@link PropertyStatus#NEW} if key not exists<br>
     * - {@link PropertyStatus#CHANGED} if value of key is different than previous value<br>
     * - {@link PropertyStatus#UNCHANGED} if value of key is same<br>
     * @param key property key
     * @param value property value
     * @return Old value of property or null if no property exists for given key.
     */
    public String putProperty(String key, String value) {
        String result = properties.put(key, value);
        if (result == null) {
            putPropertyStatus(key, PropertyStatus.NEW);
        } else if (!result.equals(value)) {
            putPropertyStatus(key, PropertyStatus.CHANGED);
        } else {
            putPropertyStatus(key, PropertyStatus.UNCHANGED);
        }
        return result;
    }

    /**
     * See {@link PropertiesMap#put(String, String, PropertyStatus)}
     * @param key property key
     * @param value property value
     */
    public String putProperty(String key, String value, PropertyStatus propertyStatus) {
        return properties.put(key, value, propertyStatus);
    }

    public String putMutationProperty(String mutation, String key, String value) {
        PropertiesMap propertiesMap = mutationProperties.get(mutation);
        if (propertiesMap == null) {
            propertiesMap = new PropertiesMap();
            mutationProperties.put(mutation, propertiesMap);
        }
        return propertiesMap.put(key, value);
    }

    public String getPropertyValue(String propertyKey) {
        return properties.get(propertyKey);
    }

    public PropertyStatus putPropertyStatus(String key, PropertyStatus propertyStatus) {
        return properties.putPropertyStatus(key, propertyStatus);
    }

    public PropertyStatus getPropertyStatus(String key) {
        return properties.getPropertyStatus(key);
    }

    public PropertiesMap putMutationProperties(String mutation, PropertiesMap properties) {
        return mutationProperties.put(mutation, properties);
    }

    public PropertiesMap getMutationProperties(String mutation) {
        return mutationProperties.get(mutation);
    }
}



