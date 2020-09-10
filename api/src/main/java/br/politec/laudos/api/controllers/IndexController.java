package br.politec.laudos.api.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "Hello World! Spring Boot!";
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    // .allowedOrigins("http://localhost:3000")
                    .allowedMethods("*");
            }
        };
    }
}
