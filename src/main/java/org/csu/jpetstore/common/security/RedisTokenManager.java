package org.csu.jpetstore.common.security;

import org.csu.jpetstore.uitls.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@Component
public class RedisTokenManager implements TokenManager {

    private static final Integer TOKEN_EXPIRE_TIME = 60 * 60 * 2;

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private ValueOperations<String, Object> valueOperations;
    @Resource
    private JwtToken jwtToken;

    @Override
    public TokenModel createToken(String userId) {
//        String token = UUID.randomUUID().toString().replace("-", "");
        String token = jwtToken.createToken(userId);
        TokenModel model = new TokenModel(userId, token);
        String key = JwtToken.REDIS_JWT_PREFIX + jwtToken.getJwtId(token);
        // 存储到redis并设置过期时间
        redisTemplate.boundValueOps(key).set(model, TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = model.getToken();
        String key = JwtToken.REDIS_JWT_PREFIX + jwtToken.getJwtId(token);
        TokenModel cacheModel = (TokenModel) valueOperations.get(key);
        if (jwtToken.verifyToken(token, cacheModel.getToken())) {
            redisTemplate.boundValueOps(key).set(model, TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
            return true;
        }
        return false;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if (StringUtils.isEmpty(authentication)) {
            return null;
        }
        // 这里是简单的由参数拼接来获取token
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        String userId = param[0];
        String token = param[1];
        return new TokenModel(userId, token);
    }

    @Override
    public void deleteToken(String token) {
        String key = JwtToken.REDIS_JWT_PREFIX + jwtToken.getJwtId(token);
        redisTemplate.delete(key);
    }
}
