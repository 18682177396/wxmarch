package com.march.condition;

import com.march.annotation.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.Objects;

public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取ConditionalOnSystemProperty所有的属性方法值
        MultiValueMap<String, Object> annotationAttributes = annotatedTypeMetadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

        String propertyName = (String) annotationAttributes.getFirst("name");

        String propertyValue = (String) annotationAttributes.getFirst("value");
        //获取系统属性值
        String systemPropertyValue = System.getProperty(propertyName);

        if(Objects.equals(systemPropertyValue,propertyValue)){
            System.out.printf("系统属性【名称：%s】找到匹配，值：%s\n",propertyName,propertyValue);
            return true;
        }
        return false;
    }
}
