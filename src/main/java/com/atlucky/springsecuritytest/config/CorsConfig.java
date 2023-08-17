package com.atlucky.springsecuritytest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpMethod.*;

/**
 * 跨域相关配置
 * @Date 2023/8/17 17:50
 * @Author XiaoHu
 * @Description
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许的跨域路径
        registry.addMapping("/**")
                //允许跨域的请求的域名
                .allowedOriginPatterns("*")
                //允许cookie设置
                .allowCredentials(true)
                //允许的请求方法
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                //允许的header操作
                .allowedHeaders("*")
                //允许跨域时间
                .maxAge(3600);
    }
}
