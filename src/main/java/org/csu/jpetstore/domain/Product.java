package org.csu.jpetstore.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = -7492639752670189553L;
    private String productId;
    private String categoryId;
    private String name;
    private String description;

}
