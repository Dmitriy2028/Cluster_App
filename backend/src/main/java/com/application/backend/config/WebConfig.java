package com.application.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Разрешаем доступ ко всем маршрутам
                .allowedOrigins("*") // Разрешаем запросы с этого адреса (например, из React)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Разрешаем методы, которые будут использоваться
                .allowedHeaders("*"); // Разрешаем все заголовки
    }
}

