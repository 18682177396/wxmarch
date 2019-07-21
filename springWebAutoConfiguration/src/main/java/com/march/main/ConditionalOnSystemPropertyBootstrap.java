package com.march.main;

import com.march.config.ConditionMessageConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalOnSystemPropertyBootstrap {

    public static void main(String[] args) {
        //设置System property laguage = Chinese
        System.setProperty("language","Chinese");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册配置Bean ContionalMessageCOnfiguration 到Spring上下文
        context.register(ConditionMessageConfiguration.class);

        //启动上下文
        context.refresh();

        String message = context.getBean("message",String.class);

        System.out.printf("\"message\" bean 对象 ： %s\n",message);
    }
}
