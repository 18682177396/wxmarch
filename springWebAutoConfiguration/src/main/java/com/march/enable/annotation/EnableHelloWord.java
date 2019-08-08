package com.march.enable.annotation;

import com.march.enable.configuration.HelloWordConfiguaration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
//@Import(HelloWordConfiguaration.class)
public @interface EnableHelloWord {
}
