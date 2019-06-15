package org.csu.jpetstore.common.config;

import org.csu.jpetstore.common.result.ResponseResultInterceptor;
import org.csu.jpetstore.common.security.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 启动自定义拦截器
 *
 * @author: sun
 * @date: 2019/6/12
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ResponseResultInterceptor responseResultInterceptor;
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String apiUri = "/**";
        // 权限校验拦截器
        registry.addInterceptor(authorizationInterceptor).addPathPatterns(apiUri);
        //  响应结果控制拦截
        registry.addInterceptor(responseResultInterceptor).addPathPatterns(apiUri);
    }
}
