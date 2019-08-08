package com.march.listener;

import com.march.annotation.TransactionalService;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TransactionalService
public class TransactionalServiceAnnotationReflectionBootstarp {

    public static void main(String[] args) {
        AnnotatedElement annotationElement = TransactionalServiceAnnotationReflectionBootstarp.class;

        TransactionalService transactionalService = annotationElement.getAnnotation(TransactionalService.class);

        Set<Annotation> metaAnnotions = getAllMetaAnnotions(transactionalService);

        metaAnnotions.forEach(TransactionalServiceAnnotationReflectionBootstarp::printAnnotationAttribute);
    }

    private static Set<Annotation> getAllMetaAnnotions(Annotation annotation) {

        Annotation[] annotations = annotation.annotationType().getAnnotations();

        if(ObjectUtils.isEmpty(annotations)){
            return Collections.emptySet();
        }

        Set<Annotation> annotationSet = Stream.of(annotations).filter(metaAnnotation ->
                //通过java.lang.annotation包命排除java标准注解
                !Target.class.getPackage().equals(metaAnnotation.annotationType().getPackage())
        ).collect(Collectors.toSet());

        HashSet<Annotation> metaMetaAnnotationsSet = annotationSet.stream()
                .map(TransactionalServiceAnnotationReflectionBootstarp::getAllMetaAnnotions)
                .collect(HashSet::new, Set::addAll, Set::addAll);

        annotationSet.addAll(metaMetaAnnotationsSet);

        return annotationSet;
    }
    
    private static void printAnnotationAttribute(Annotation annotation){
        Class<?> annotationType = annotation.annotationType();

        ReflectionUtils.doWithMethods(annotationType,
                method -> System.out.printf("@%s.%s() = %s\n", annotationType.getSimpleName(),
                        method.getName(), ReflectionUtils.invokeMethod(method, annotation)) // 执行 Method 反射调用
                , method -> !method.getDeclaringClass().equals(Annotation.class));// 选择非 Annotation 方法
    }
}
