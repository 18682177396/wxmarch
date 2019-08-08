package com.march.main;

import com.march.annotation.TransactionalService;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.AnnotatedElement;

public class AnnotationAttributeBootstrap {

    public static void main(String[] args) {
        AnnotatedElement annotatedElement = TransactionalService.class;

        AnnotationAttributes serviceAnnotationAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Service.class);

        AnnotationAttributes trancactionalAnnotationAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Transactional.class);

        print(serviceAnnotationAttributes);

        print(trancactionalAnnotationAttributes);
    }

    private static void print(AnnotationAttributes annotationAttributes){
        System.out.printf("注解@%s属性集合:\n",annotationAttributes.annotationType().getName());

        annotationAttributes.forEach((name,value) -> {
            System.out.printf("\t属性%s ： %s \n",name,value);
        });
    };
}
