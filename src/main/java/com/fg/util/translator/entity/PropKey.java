package com.fg.util.translator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Class representing Json specification of one key in properties file.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropKey implements Serializable {

    private static final long serialVersionUID = -8850057565295541920L;

    private String key;
}
