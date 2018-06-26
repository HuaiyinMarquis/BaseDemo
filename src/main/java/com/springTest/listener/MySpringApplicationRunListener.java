package com.springTest.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {}

    @Override
    public void starting() {
        System.out.println("MySpringApplicationRunListener#starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("MySpringApplicationRunListener#environmentPrepared...");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener#contextPrepared...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener#contextLoaded...");
    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MySpringApplicationRunListener#finished...");
    }
}
