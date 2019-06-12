package org.csu.jpetstore.common.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要检查用户登录的方法的注解
 * 该方法在映射时会检查用户是否登录，未登录返回 401 错误
 * @author: sun
 * @date: 2019/6/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
}
