package org.csu.jpetstore.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@Data
public class Sequence implements Serializable {

    private static final long serialVersionUID = 8278780133180137281L;

    private String name;
    private int nextId;

    public Sequence() {
    }

    public Sequence(String name, int nextId) {
        this.name = name;
        this.nextId = nextId;
    }

}
