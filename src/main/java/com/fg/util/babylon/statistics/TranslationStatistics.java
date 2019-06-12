package com.fg.util.babylon.statistics;

import com.fg.util.babylon.enums.Action;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.lang.reflect.Field;

/**
 * Class for collecting and presenting statistics from translation processing.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@CommonsLog
public class TranslationStatistics {

    @FieldName("Action")
    private Action action;

    @FieldName("Total primary properties files processed")
    private int primaryPropFilesProcessed;

    @FieldName("Total properties files processed")
    private int totalPropFilesProcessed;

    /**
     * Increment value of {@link TranslationStatistics#getPrimaryPropFilesProcessed()} by inc value.
     * @param inc
     */
    public void incPrimaryPropFilesProcessed(Integer inc) {
        primaryPropFilesProcessed += inc;
    }

    /**
     * Increment value of {@link TranslationStatistics#getTotalPropFilesProcessed()} by inc value.
     * @param inc
     */
    public void incTotalPropFilesProcessed(Integer inc) {
        totalPropFilesProcessed += inc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String lineEnd = System.lineSeparator();
        sb.append("--- TRANSLATION STATISTICS ---").append(lineEnd);
        for (Field field : getClass().getDeclaredFields()) {
            field.setAccessible(true);
            FieldName fieldName = field.getDeclaredAnnotation(FieldName.class);
            // Only fields annotated by @FieldName annotation is valid.
            if (fieldName == null) {
                continue;
            }
            String name = fieldName.value();
            try {
                Object valObj = field.get(this);
                sb.append(name).append(" = ").append(valObj.toString()).append(lineEnd);
            } catch (IllegalAccessException e) {
                log.error("Error while printing translation statistics value \"" + name + "\"", e);
            }
        }
        return sb.toString();
    }
}
