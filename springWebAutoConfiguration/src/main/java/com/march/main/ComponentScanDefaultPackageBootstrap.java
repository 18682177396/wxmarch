package com.march.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

//@ComponentScan(basePackages = "")除Spring内建的Bean外，仅扫描ComponentScanDefaultPackageBootstrap所在包
@ComponentScan(basePackages = "")
public class ComponentScanDefaultPackageBootstrap {

    public static void main(String[] args){
        //构建AnnotationConfigApplication配置驱动spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        System.out.println("当前Springboot应用上下文中所有注册的Bean名称");

        Stream.of(context.getBeanDefinitionNames()).map(name -> "\t"+name).forEach(System.out::println);

        //关闭上下文
        context.close();

    }

    @Bean
    public String msg(){return "msg";}
}
