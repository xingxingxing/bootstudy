package xin.hesperus.boot.ch2.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import xin.hesperus.boot.ch2.bean.SimpleBeanInBeanDefinitionRegistryPostProcessor;
import xin.hesperus.boot.ch2.bean.SimpleBeanWithDefinitionInBeanDefinitionRegistryPostProcessor;


@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
    public MyBeanDefinitionRegistryPostProcessor() {
        System.out.println("MyBeanDefinitionRegistryPostProcessor init");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor  postProcessBeanDefinitionRegistry");
        beanDefinitionRegistry.registerBeanDefinition(" simpleBeanWithDefinitionInBeanDefinitionRegistryPostProcessor",new AnnotatedGenericBeanDefinition(SimpleBeanWithDefinitionInBeanDefinitionRegistryPostProcessor.class));

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor  postProcessBeanFactory");
        configurableListableBeanFactory.registerSingleton("simpleBeanInBeanDefinitionRegistryPostProcessor", new SimpleBeanInBeanDefinitionRegistryPostProcessor());

    }

    @Override
    public int getOrder() {
        return 10;
    }
}
