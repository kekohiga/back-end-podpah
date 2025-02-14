package com.example.loginauthapi.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite todas as rotas
                .allowedOrigins("https://alexapodpah.shop") // Permitir apenas este domínio
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permitir todos os headers
                .allowCredentials(true); // Permitir envio de credenciais (cookies, auth headers)
    }
}
