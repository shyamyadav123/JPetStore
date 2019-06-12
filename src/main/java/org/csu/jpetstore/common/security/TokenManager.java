package org.csu.jpetstore.common.security;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface TokenManager {

    /**
     * 创建一个 token 关联上指定用户
     * @param userId 指定用户的 id
     * @return 生成的 token
     */
    TokenModel createToken (String userId);

    /**
     * 检查Token是否有效
     * @param token
     * @return
     */
    boolean checkToken(TokenModel token);

    /**
     * 从字符串中解析 token
     * @param authentication 加密后的字符串
     * @return
     */
    TokenModel getToken(String authentication);

    /**
     * 根据userId清除Token
     * @param userId
     */
    void deleteToken(String userId);

}
