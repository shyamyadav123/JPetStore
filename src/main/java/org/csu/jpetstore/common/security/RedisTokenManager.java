package org.csu.jpetstore.common.security;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@Component
public class RedisTokenManager implements TokenManager {

    private static final Integer tokenExpireTime = 7200;


    @Override
    public TokenModel createToken(String userId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token, new Timestamp(new Date().getTime()));
        // 存储到redis并设置过期时间
        return model;
    }

    @Override
    public boolean checkToken(TokenModel token) {
        return false;
    }

    @Override
    public TokenModel getToken(String authentication) {
        return null;
    }

    @Override
    public void deleteToken(String userId) {

    }
}
