package com.fg.util.translator.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing Json specification of one properties file with list of properties (keys and values).
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PropertiesFileLog implements Serializable {

    private static final long serialVersionUID = 2426359297082283380L;

    /**
     * Source properties file name with path relative to project root.
     */
    @NonNull
    private String fileName;

    /**
     * Properties like list of {@link PropKeyAndValue}
     */
    private List<PropKeyAndValue> properties = new ArrayList<>();

    public void addProperty(PropKeyAndValue value) {
        properties.add(value);
    }
}



