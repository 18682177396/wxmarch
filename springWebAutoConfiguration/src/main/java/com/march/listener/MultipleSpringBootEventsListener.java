package com.march.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SmartApplicationListener;

import java.util.Random;

public class MultipleSpringBootEventsListener implements SmartApplicationListener {


    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        //支持的事件类型
        return ApplicationReadyEvent.class.equals(eventType) || ApplicationFailedEvent.class.equals(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType){
        return SpringApplication.class.equals(sourceType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if( event instanceof ApplicationReadyEvent){
            if(new Random().nextBoolean()){
                throw new RuntimeException("ApplicationReadyEvent 事件监听异常");
            }
        }
        System.out.println("MultipleSpringBootEventsListener 监听事件：" + event.getClass().getSimpleName());
    }

    @EventListener({ApplicationReadyEvent.class,ApplicationFailedEvent.class})
    public void onSpringBootEvent(SpringApplicationEvent event){
        System.out.println("@EventListener 监听事件：" + event.getClass().getSimpleName());
    }
}
