package com.march.main;

import com.march.annotation.TransactionalService;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;
import java.util.Set;

@TransactionalService
public class TransactionalServiceAnnotationMetadataBootstrap {

    public static void main(String[] args) throws IOException {
        String className = TransactionalServiceAnnotationMetadataBootstrap.class.getName();
        //构建MetadataReaderFactory实例
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        //读取@TransactionalService MetadataReader信息
        final MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);

        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        annotationMetadata.getAnnotationTypes().forEach(annotationType ->{
            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
            metaAnnotationTypes.forEach(metaAnnotationType -> {
                System.out.printf("注解 @%s 元标注 @%s \n",annotationType,metaAnnotationType);
            });
        });
    }
}
