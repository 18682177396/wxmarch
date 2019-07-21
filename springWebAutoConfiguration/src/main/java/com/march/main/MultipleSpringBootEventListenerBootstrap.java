package com.march.main;

import com.march.listener.MultipleSpringBootEventsListener;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class MultipleSpringBootEventListenerBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MultipleSpringBootEventsListener.class).web(WebApplicationType.NONE).run(args).close();
    }
}
