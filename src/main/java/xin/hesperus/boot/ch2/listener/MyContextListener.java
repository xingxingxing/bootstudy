package xin.hesperus.boot.ch2.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import xin.hesperus.boot.ch2.bean.SimpleBeanInListener;

public class MyContextListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ContextRefreshedEvent) {
            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
            if(applicationContext instanceof AnnotationConfigServletWebServerApplicationContext) {
                ((AnnotationConfigServletWebServerApplicationContext) applicationContext).getBeanFactory().registerSingleton("simpleBeanInListener", new SimpleBeanInListener());
            }

        }
    }
}
