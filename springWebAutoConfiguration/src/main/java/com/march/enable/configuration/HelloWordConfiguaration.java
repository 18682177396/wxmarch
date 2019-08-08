package com.march.enable.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWordConfiguaration {

    @Bean
    public String helloWord(){
        return "Hello,Word";
    }
}
