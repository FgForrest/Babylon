package com.fg.util.translator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Class representing Json specification of one key and value for Json data file.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropKeyAndValue implements Serializable {

    private static final long serialVersionUID = -8850057565295541920L;

    private String key;
    private String value;
}
