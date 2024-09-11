package com.bmo_genc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm endpoint'ler için
                .allowedOrigins("http://localhost:8082","http://localhost:8081")  // Frontend'in origin'i
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);  // İsterseniz credential'ları da destekleyebilirsiniz
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(10); // Aynı anda 10 görev işleyebilir
    }
}