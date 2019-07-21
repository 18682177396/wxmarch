package com.march.main;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.march.spring.boot.autoConfigure.formatter.Formatter;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration
public class FormatterBoostrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterBoostrap.class)
                .web(WebApplicationType.SERVLET).run(args);

        Map<String,Object> data = new HashMap<>();
        data.put("name","王星");

        Formatter formatter = context.getBean(Formatter.class);

        System.out.printf("[Bean name : %s],format(data):%s\n",formatter.getClass().getSimpleName(),formatter.formart(data));

        Map<String, Formatter> beans = context.getBeansOfType(Formatter.class);
        if (beans.isEmpty()) { // 如果 Bean 不存在，抛出异常
            throw new NoSuchBeanDefinitionException(Formatter.class);
        }

        beans.forEach((beanName,fm)->{
            System.out.printf("[Bean name : %s] %s.format(data) : %s\n", beanName, fm.getClass().getSimpleName(),
                    fm.formart(data));
        });

        ObjectMapper objectMapper = context.getBean(ObjectMapper.class);

        System.out.printf("[objectMapper name : %s]\n",objectMapper.getClass().getName());


        context.close();
    }
}
