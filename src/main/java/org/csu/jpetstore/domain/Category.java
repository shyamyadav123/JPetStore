package org.csu.jpetstore.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 3992469837058393712L;

    private String categoryId;
    private String name;
    private String description;

}
