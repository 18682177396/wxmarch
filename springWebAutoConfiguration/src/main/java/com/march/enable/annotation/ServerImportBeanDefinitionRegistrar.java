package com.march.enable.annotation;

import com.march.enable.annotation.ServerImportSelector;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ImportSelector importSelector = new ServerImportSelector();

        //帅选Class名称集合
        String[] selectImports = importSelector.selectImports(importingClassMetadata);

        //创建bean的定义
        Stream.of(selectImports)
                //转换为BeanDefinitionBuilder对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                //转换为BeanDifinition对象
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(abstractBeanDefinition ->
                        //注册BeanDefinition到BeanDefinitionRegistry
                        BeanDefinitionReaderUtils.registerWithGeneratedName(abstractBeanDefinition,registry)
                );
    }
}
