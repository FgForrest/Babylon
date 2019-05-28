package com.fg.util.translator.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing Json specification of one properties file with specified list of properties names in configuration which will not be translated.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PropertiesFile implements Serializable {

    private static final long serialVersionUID = 2426359297082283380L;

    /**
     * Source properties path relative to project root.
     */
    @NonNull
    private String propFilePath;

    /**
     * Excluded properties (which will not translated) like list of {@link String}
     */
    private List<String> excludedProperties = new ArrayList<>();

    public void addExcludedProperty(String value) {
        excludedProperties.add(value);
    }
}



