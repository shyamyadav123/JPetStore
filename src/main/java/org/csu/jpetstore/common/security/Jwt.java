package org.csu.jpetstore.common.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: sun
 * @date: 2019/6/15
 */
@Component
public class Jwt {

    /**
     * JWT 自定义密钥
     */
    public static final String SECRET_KEY = "5371f568a45e5ab1f442c38e0932aef24447139b";

    /**
     * redis JWT Prefix
     */
    public static final String REDIS_JWT_PREFIX = "JWT-TOKEN-";

    /**
     * JWT 过期时间值 这里写死为和小程序时间一致 7200 秒，也就是两个小时
     */
    public static int expire_time = 7200;

    @Autowired
    private RedisTemplate redisTemplate;

    public String createToken(String userId) {
        // JWT 随机ID,做为验证的key
        String jwtId = UUID.randomUUID().toString();
        // 使用唯一密钥+用户密码生成加密密钥
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create()
                .withIssuer("org.csu")
                .withIssuedAt(new Date())
                .withAudience(userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + expire_time * 1000))
                .withClaim("jwt-id", jwtId)
                .sign(algorithm);
        return token;
    }

    public boolean verifyToken(String token, String redisToken) {
        if (redisToken == null) {
            return false;
        }
        try {
            // 得到算法相同的JWTVerifier
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("org.csu")
                    .withAudience(getJWTAudience(redisToken))
                    .withClaim("jwt-id", getJwtId(redisToken))
                    .acceptExpiresAt(System.currentTimeMillis() + expire_time * 1000)  //JWT 正确的配置续期姿势
                    .build();
            // 验证token
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public String getJwtId(String token) {
        return JWT.decode(token).getClaim("jwt-id").asString();
    }

    public String getJWTAudience(String token) {
        List<String> audiences = JWT.decode(token).getAudience();
        if (audiences != null && audiences.size() > 0) {
            return audiences.get(0);
        }
        return null;
    }

}
