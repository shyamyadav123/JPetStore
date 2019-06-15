package org.csu.jpetstore.common.security;

import org.csu.jpetstore.common.exception.UserNotLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * @author: sun
 * @date: 2019/6/13
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod ();
        // 从 header 中得到 token
        if(method.getAnnotation (Authorization.class) == null) {
            return true;
        }
        String authorization = request.getHeader ("authorization");
//        System.err.println(authorization);
        // 验证 token
        TokenModel model = tokenManager.getToken (authorization);
        if (tokenManager.checkToken (model)) {
            // 如果 token 验证成功，将 token 对应的用户 id 存在 request 中，便于之后注入
            request.setAttribute ("current-userId", model.getUserId());
            return true;
        }
        // 如果验证 token 失败，并且方法注明了 Authorization，返回 401 错误
        if (method.getAnnotation (Authorization.class) != null) {
            throw new UserNotLoginException("Please login first");
        }
        return true;
    }
}
