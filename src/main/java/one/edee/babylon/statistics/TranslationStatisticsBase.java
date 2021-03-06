package one.edee.babylon.statistics;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Base class for collecting and presenting statistics from translation processing.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@CommonsLog
public class TranslationStatisticsBase {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("--- TRANSLATION STATISTICS ---").append(System.lineSeparator());
        for (Field field : getClass().getDeclaredFields()) {
            buildFieldStringValue(sb, field, this);
        }
        return sb.toString();
    }

    /**
     * Build String value from given field of given instance of object.
     * @param sb for appending field string values to whole target string value
     * @param field field with data to build string value
     * @param instance instance of object from where this field comes from
     */
    private void buildFieldStringValue(StringBuilder sb, Field field, Object instance) {
        field.setAccessible(true);
        String name = field.getName();
        try {
            // Collections is not necessary to be annotated with @StatisticsField.
            if (Collection.class.isAssignableFrom(field.getType())) {
                Collection<Object> collection = (Collection<Object>) field.get(instance);
                // Using of basic "for" loop to highlight recursive call.
                for (Object item : collection) {
                    for (Field itemField : item.getClass().getDeclaredFields()) {
                        buildFieldStringValue(sb, itemField, item);
                    }
                }
                return;
            }
            // Map key is printed as value of first row in [] followed by values from map value object.
            if (Map.class.isAssignableFrom(field.getType())) {
                Map<Object, Object> map = (Map<Object, Object>) field.get(instance);
                for (Object key : map.keySet()) {
                    sb.append("[").append(key.toString()).append("]").append(System.lineSeparator());
                    Object item = map.get(key);
                    for (Field itemField : item.getClass().getDeclaredFields()) {
                        buildFieldStringValue(sb, itemField, item);
                    }
                }
            }
            StatisticsField statisticsField = field.getDeclaredAnnotation(StatisticsField.class);
            // Only fields annotated by @StatisticsField annotation is valid as statistics value.
            if (statisticsField == null) {
                return;
            }
            name = statisticsField.value();
            Object valObj = field.get(instance);
            if (name.isEmpty()) {
                sb.append(valObj.toString()).append(System.lineSeparator());
            } else {
                sb.append(name).append(" = ").append(valObj.toString()).append(System.lineSeparator());
            }
        } catch (IllegalAccessException e) {
            log.error("Error while printing translation statistics value \"" + name + "\"", e);
        }
    }

}
