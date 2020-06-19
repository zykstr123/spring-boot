package com.example.springbootdemo.config;

import com.example.springbootdemo.interceptor.MajorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired MajorInterceptor majorInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(majorInterceptor).addPathPatterns("/**").excludePathPatterns("/user/v1/login/**");
    }

}
