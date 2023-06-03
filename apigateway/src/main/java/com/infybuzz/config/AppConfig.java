package com.infybuzz.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.infybuzz")
public class AppConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
