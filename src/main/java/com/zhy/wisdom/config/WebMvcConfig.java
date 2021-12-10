/*
package com.zhy.wisdom.config;

import com.zhy.wisdom.config.interceptor.AdminInterceptor;
import com.zhy.wisdom.config.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        this.loginInterceptor(registry);//登录拦截
        this.adminInterceptor(registry);//管理员拦截
    }

    private void loginInterceptor(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(//释放登陆接口
                        "/login/**"
                );
    }

    private void adminInterceptor(InterceptorRegistry registry){
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**");//拦截管理员接口
    }
}
*/
