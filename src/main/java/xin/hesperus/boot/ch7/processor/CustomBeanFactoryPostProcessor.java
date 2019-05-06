package xin.hesperus.boot.ch7.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String name = "custom";
        Map<String,Object> map = new HashMap<>();
        map.put("my.name","processor");
        ((StandardEnvironment)context.getEnvironment()).getPropertySources().addFirst(new MapPropertySource(name,map));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
