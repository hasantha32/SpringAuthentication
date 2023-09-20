package com.SpringAuthentication.SpringAuthentication.configuration;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    public static final String GET="GET";
    public static final String POST="POST";
    public static final String PUT="PUT";
    public static final String DELETE="DELETE";


    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping(("/**"))
                       .allowedMethods(GET,POST,PUT,DELETE)
                       .allowedHeaders("*")
                       .allowedOriginPatterns("*")
                       .allowCredentials(true);
            }
        };
    }
}
