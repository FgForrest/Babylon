package com.fg.util.babylon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fg.util.babylon.enums.PropertyStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class representing Json specification of one properties fileName with list of properties (keys and values) in {@link DataFile}.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@NoArgsConstructor
public class DataPropFile implements Serializable {

    private static final long serialVersionUID = 2426359297082283380L;

    /**
     * Hash code of relative path to source/destination properties file. This code is used like the short unique identifier of the path.
     */
    private String code;

    /**
     * Properties like {@link PropertiesMap}
     */
    private PropertiesMap properties = new PropertiesMap();

    /**
     * Secondary mutations properties data like {@link Map<String, PropertiesMap>}. Property isn't serialized to Json file.<br>
     * key - contains name of the mutation e.g. "en, fr, ..."<br>
     * value - contains {@link PropertiesMap}
     */
    @JsonIgnore
    private Map<String, PropertiesMap> mutationProperties = new LinkedHashMap<>();

    /**
     * See {@link PropertiesMap#put(String, String)}
     * @param key
     * @param value
     */
    public String putProperty(String key, String value) {
        return properties.put(key, value);
    }

    /**
     * See {@link PropertiesMap#put(String, String, PropertyStatus)}
     * @param key
     * @param value
     */
    public String putProperty(String key, String value, PropertyStatus propertyStatus) {
        return properties.put(key, value, propertyStatus);
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



