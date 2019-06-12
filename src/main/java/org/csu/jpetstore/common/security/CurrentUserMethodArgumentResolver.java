package org.csu.jpetstore.common.security;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @author: sun
 * @date: 2019/6/13
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private AccountService accountService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 如果参数类型是 User 并且有 CurrentUser 注解则支持
        if (parameter.getParameterType().isAssignableFrom(Account.class) &&
                parameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 取出鉴权时存入的登录用户 Id
        String currentUserId = (String) nativeWebRequest.getAttribute("current-userId", RequestAttributes.SCOPE_REQUEST);
        if (!StringUtils.isEmpty(currentUserId)) {
            // 从数据库中查询并返回
            return accountService.getAccount(currentUserId);
        }
        throw new MissingServletRequestPartException("current-userId");
    }
}
