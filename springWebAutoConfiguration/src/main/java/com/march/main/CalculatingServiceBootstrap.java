package com.march.main;

import com.march.service.CalculatingService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

@Configuration
@ComponentScan(basePackageClasses = CalculatingService.class)
@EnableAutoConfiguration
public class CalculatingServiceBootstrap {

    static {
        //通过java系统属性设置spring profile
        //以下语句等效于ConfigurableEnvironment.setActiviProfiles("Java8")
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,"Java8");
        //以下语句等效于ConfigurableEnvironment.setDefaultProfiles("Java8")
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME,"Java7");
    }

    public static void main(String[] args){
        //构建AnnotationConfigApplication配置驱动spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前配置Bean到Spring上下文
        context.register(CalculatingServiceBootstrap.class);
        //启动上下文
        context.refresh();
        //获取CalclatingService Bean
        CalculatingService cs = context.getBean(CalculatingService.class);

        cs.sum(1,2,3,4,5);

        //关闭上下文
        context.close();

    }
}

