package org.csu.jpetstore.common.security;

import org.csu.jpetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在 Controller 的方法参数中使用此注解，该方法在映射时会注入当前登录的 User 对象
 * @author: sun
 * @date: 2019/6/13
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {

}
