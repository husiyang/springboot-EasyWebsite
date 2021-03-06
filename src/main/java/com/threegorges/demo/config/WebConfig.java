package com.threegorges.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/register","/logout","/jquery-2.1.1.min.js","/css/**","/favicon.ico","/img/**","/js/**");
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/register","/logout","/jquery-2.1.1.min.js","/css/**","/favicon.ico","/img/**","/js/**");
    }
}
