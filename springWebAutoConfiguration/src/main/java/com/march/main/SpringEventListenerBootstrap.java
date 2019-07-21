package com.march.main;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Objects;

public class SpringEventListenerBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Object.class).listeners(event -> System.out.println(
                "SpringApplication 事件监听：" + event.getClass().getSimpleName()+",事件源：" + event.getSource().getClass().getName()
        )).web(WebApplicationType.NONE).run().close();
    }
}
