package org.springframework.core.io.support;


import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

public class SpringFactoriesLoaderTest {

    @Test
    public void loadFactories(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class,classLoader).forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------------------");
        SpringFactoriesLoader.loadFactoryNames(AutoConfigurationImportListener.class,classLoader).forEach(System.out::println);
    }


}
