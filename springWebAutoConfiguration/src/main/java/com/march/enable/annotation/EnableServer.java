package com.march.enable.annotation;

import com.march.enable.service.service;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({ServerImportSelector.class})
//@Import({ServerImportSelector.class}) 和 @Import(ServerImportBeanDefinitionRegistrar.class) 都可以实现注入
//@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer {

    /**
     * 设置服务的类型
     * @return
     */
    service.Server.type type();
}
