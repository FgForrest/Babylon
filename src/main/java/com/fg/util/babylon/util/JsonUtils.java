package com.fg.util.babylon.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.io.File;
import java.io.IOException;

/**
 * Utility class for Json manipulations.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils() {
    }

    static {
        // There must be added default filters (which serializing all properties) for all filters defined in annotations @JsonFilter above all Json entities.
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("MessageFileFilter", SimpleBeanPropertyFilter.serializeAll());
        OBJECT_MAPPER.setFilterProvider(filterProvider);
    }

    /**
     * Deserialization of File to Json object.
     * @param file {@link File} for deserialization
     * @param valueType type of the
     * @return Json representation of object as {@link String}
     */
    public static <T> T jsonObjFromFile(File file, Class<T> valueType) throws IOException {
        return OBJECT_MAPPER.readValue(file, valueType);
    }

    /**
     * Deserialization of String to Json object.
     * @param jsonString {@link String} for deserialization
     * @param valueType type of the
     * @return Json representation of object as {@link String}
     */
    public static <T> T jsonObjFromString(String jsonString, Class<T> valueType) throws IOException {
        return OBJECT_MAPPER.readValue(jsonString, valueType);
    }

    /**
     * Serialization of object to Json {@link File}.
     * @param file target {@link File}
     * @param value object for serialization
     * @param formatted format output string
     */
    public static void objToJsonFile(File file, Object value, boolean formatted) throws IOException {
        if (formatted) {
            OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(file, value);
        } else {
            OBJECT_MAPPER.writeValue(file, value);
        }
    }
    /**
     * Serialization of object to Json {@link File} with possibility to exclude some properties from serialization by name.
     * @param file target {@link File}
     * @param value object for serialization
     * @param formatted format output string
     * @param filters optionally filters to specify which properties will not serialize to file
     */
    public static void objToJsonFile(File file, Object value, boolean formatted, FilterProvider filters) throws IOException {
        if (filters == null) {
            if (formatted) {
                OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(file, value);
            } else {
                OBJECT_MAPPER.writeValue(file, value);
            }
        } else {
            if (formatted) {
                OBJECT_MAPPER.writer(filters).withDefaultPrettyPrinter().writeValue(file, value);
            } else {
                OBJECT_MAPPER.writer(filters).writeValue(file, value);
            }
        }
    }

    /**
     * Serialization of object to Json string
     * @param value object for serialization
     * @param formatted format output string
     * @return Json representation of object as {@link String}
     */
    public static String objToJsonString(Object value, boolean formatted) throws JsonProcessingException {
        if (formatted) {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } else {
            return OBJECT_MAPPER.writeValueAsString(value);
        }
    }
}
