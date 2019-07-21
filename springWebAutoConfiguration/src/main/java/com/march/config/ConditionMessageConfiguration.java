package com.march.config;

import com.march.annotation.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionMessageConfiguration {

    @ConditionalOnSystemProperty(name="language",value = "Chinese")
    @Bean(name="message")
    public String chineseMessage(){
        return "你好，世界";
    }

    @ConditionalOnSystemProperty(name="language",value = "Engish")
    @Bean(name="message")
    public String engishMessage(){
        return "Hello,Word";
    }
}
