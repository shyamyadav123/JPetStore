package org.csu.jpetstore.common.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenModel {

    // 用户id
    private String userId;

    // 随机生成的 uuid
    private String token;

    // 创建的时间
    private Timestamp createTime;


}
