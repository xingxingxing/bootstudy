package xin.hesperus.boot.ch1.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class MyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationStartedEvent) {
            System.out.println("===== custom started event in initializer");
        } else if(event instanceof ApplicationReadyEvent) {
            System.out.println("===== custom ready event in initializer");
        }else if(event instanceof ContextRefreshedEvent) {
            System.out.println("===== custom finish event in initializer");
        }
    }
}
