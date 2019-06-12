package org.csu.jpetstore;

import lombok.Data;

/**
 * @author: sun
 * @date: 2019/6/13
 */
@Data
public class UserVo {

    public  static final String Table = "t_user";

    private String name;
    private String address;
    private Integer age;

}
