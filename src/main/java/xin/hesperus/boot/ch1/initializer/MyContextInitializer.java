package xin.hesperus.boot.ch1.initializer;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import xin.hesperus.boot.ch1.bean.User;

public class MyContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if(applicationContext instanceof AnnotationConfigServletWebServerApplicationContext) {
            ((AnnotationConfigServletWebServerApplicationContext)applicationContext).getBeanFactory().registerSingleton("testBean", new User(12,"ceshi"));
        }
    }
}
