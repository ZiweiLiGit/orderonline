package com.liziwei.orderonline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liziwei
 * @title: MyConfig
 * @projectName orderonline
 * @description: TODO
 * @date 2020/2/22 20:42
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //扫描static下的所有html页面
        registry.addResourceHandler("classpath:/static/*.html");
        //扫描static下的所有资源
        registry.addResourceHandler("/static/**");
    }
}