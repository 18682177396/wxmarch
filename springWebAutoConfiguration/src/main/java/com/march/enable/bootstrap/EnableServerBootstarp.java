package com.march.enable.bootstrap;

import com.march.enable.annotation.EnableServer;
import com.march.enable.service.service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableServer(type= service.Server.type.HTTP)
public class EnableServerBootstarp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(EnableServerBootstarp.class);
        
        context.refresh();

        service.Server server = context.getBean(service.Server.class);

        server.start();

        server.stop();
    }
}
