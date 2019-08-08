package com.march.enable.bootstrap;

import com.march.enable.annotation.EnableHelloWord;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@EnableHelloWord
@Configuration
public class EnableHelloWordBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前引到类（被@Configuration标注）到spring 上下文
        context.register(EnableHelloWordBootstrap.class);

        context.refresh();

        System.out.println(context.getBean("helloWord",String.class));

        context.close();
    }
}
