package com.fg.util.babylon.statistics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to giving meaningful name for the statistics fields.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldName {
    String value();
}
