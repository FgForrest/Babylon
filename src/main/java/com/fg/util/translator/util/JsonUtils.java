package com.fg.util.translator.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fg.util.translator.entity.PropertiesFile;
import com.fg.util.translator.entity.PropKeyAndValue;
import com.fg.util.translator.entity.PropertiesFileLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Utility class for JSON manipulations.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Deserialization of File to Json object.
     * @param file {@link File} for deserialization.
     * @param valueType type of the
     * @return Json representation of object as {@link String}
     */
    public static <T> T jsonObjFromFile(File file, Class<T> valueType) throws IOException {
        return OBJECT_MAPPER.readValue(file, valueType);
    }

    /**
     * Deserialization of String to Json object.
     * @param jsonString {@link String} for deserialization.
     * @param valueType type of the
     * @return Json representation of object as {@link String}
     */
    public static <T> T jsonObjFromString(String jsonString, Class<T> valueType) throws IOException {
        return OBJECT_MAPPER.readValue(jsonString, valueType);
    }

    /**
     * Serialization of object to Json {@link File}.
     * @param file Target {@link File}
     * @param value Object for serialization.
     * @param formatted format output string.
     */
    public static void objToJsonFile(File file, Object value, boolean formatted) throws IOException {
        if (formatted) {
            OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(file, value);
        } else {
            OBJECT_MAPPER.writeValue(file, value);
        }
    }

    /**
     * Serialization of object to Json string.
     * @param value Object for serialization.
     * @param formatted format output string.
     * @return Json representation of object as {@link String}
     */
    public static String objToJsonString(Object value, boolean formatted) throws JsonProcessingException {
        if (formatted) {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } else {
            return OBJECT_MAPPER.writeValueAsString(value);
        }
    }

    /**
     * Method creates PropertiesFile Json entity by information from given properties file.
     * @param relativeFilePath Relative path (starts on root folder of project) to source properties file to store into {@link PropertiesFile} object.
     * @param propertiesFile Source properties {@link File}. Usually in some resource folder.
     * @return {@link PropertiesFile}
     */
    public static PropertiesFile createPropertiesFileObj(String relativeFilePath, File propertiesFile) throws IOException {
        PropertiesFile result = new PropertiesFile(relativeFilePath);
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(propertiesFile);
        properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        properties.forEach((key, value) -> result.addExcludedProperty((String)key));
        return result;
    }

    /**
     * Method creates PropertiesFileLog Json entity by information from given properties file.
     * @param relativeFilePath Relative path (starts on root folder of project) to source properties file to store into {@link PropertiesFile} object.
     * @param propertiesFile Source properties {@link File}. Usually in some resource folder.
     * @return {@link PropertiesFile}
     */
    public static PropertiesFileLog createPropertiesFileLogObj(String relativeFilePath, File propertiesFile) throws IOException {
        PropertiesFileLog result = new PropertiesFileLog(relativeFilePath);
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(propertiesFile);
        properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        properties.forEach((key, value) -> result.addProperty(new PropKeyAndValue((String)key, (String)value)));
        return result;
    }


}
