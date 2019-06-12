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
    private RedisService redisService;

    @Override
    public TokenModel createToken(String userId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token, new Timestamp(new Date().getTime()));
        // 存储到redis并设置过期时间
        redisTemplate.boundValueOps("user-token:" + userId).set(model, TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String key = "user-token:" + model.getUserId();
        TokenModel cacheModel = (TokenModel) valueOperations.get(key);
//        System.err.println(model.getTimestamp().getTime());
//        System.err.println(cacheModel.getTimestamp().getTime());
        if (cacheModel == null || !cacheModel.getToken().equals(model.getToken())
                || model.getTimestamp().getTime() - cacheModel.getTimestamp().getTime() > TOKEN_EXPIRE_TIME * 1000) {
            return false;
        }
        // 如果验证成功，说明此用户进行了一次有效操作，延长 token 的过期时间
        redisTemplate.boundValueOps("user-token:" + model.getUserId()).set(model, TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
        return true;
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
        return new TokenModel(userId, token, new Timestamp(new Date().getTime()));
    }

    @Override
    public void deleteToken(String userId) {
        redisTemplate.delete("user-token:" + userId);
    }
}
