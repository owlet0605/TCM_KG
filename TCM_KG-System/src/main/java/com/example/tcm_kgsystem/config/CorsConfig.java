package com.example.tcm_kgsystem.config;

import com.example.tcm_kgsystem.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "C:/Users/zei/Desktop/TCM_KGSystem/src/main/resources/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/tcm/**")
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/user/getUserByName")
                .excludePathPatterns("/api/user/getUser")
                .excludePathPatterns("/api/user/email/**")
                .excludePathPatterns("/api/user/phone/**")
                .excludePathPatterns("/api/user/all")
                .excludePathPatterns("/api/user/changeStatus")
                .excludePathPatterns("/api/result/show")
                .excludePathPatterns("/api/result/do")
                .excludePathPatterns("/api/comment/show")
                .excludePathPatterns("/api/comment/show/sub")
                .excludePathPatterns("/api/comment/get")
                .excludePathPatterns("/api/audit/**")
                .excludePathPatterns("/api/article/**")
                .excludePathPatterns("/api/admin/**")
                .excludePathPatterns("/api/file/**");
    }
}
