package xin.hesperus.boot.ch2.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;
import xin.hesperus.boot.ch2.bean.SimpleBeanInBeanFactoryPostProcessor;
import xin.hesperus.boot.ch2.bean.SimpleBeanWithDefinitionInBeanFactoryPostProcessor;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        System.out.println("MyBeanFactoryPostProcessor  init");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor  postProcessBeanFactory ");

//        BeanDefinition simpleBeanInListener = configurableListableBeanFactory.getBeanDefinition("simpleBeanInListener");
//        if(simpleBeanInListener!=null){
//            System.out.println("simpleBeanInListener have reg");
//        }
//        Object simpleBeanInListener1 = configurableListableBeanFactory.getBean("simpleBeanInListener");
//        if(simpleBeanInListener1!=null){
//            System.out.println("simpleBeanInListener have inited");
//        }
        configurableListableBeanFactory.registerSingleton("simpleBeanInBeanFactoryPostProcessor",new SimpleBeanInBeanFactoryPostProcessor());
    if(configurableListableBeanFactory instanceof BeanDefinitionRegistry){
        BeanDefinitionReaderUtils.registerBeanDefinition(new BeanDefinitionHolder(new AnnotatedGenericBeanDefinition(SimpleBeanWithDefinitionInBeanFactoryPostProcessor.class),
                "simpleBeanWithDefinitionInBeanFactoryPostProcessor"),(BeanDefinitionRegistry)configurableListableBeanFactory);
    }
    }
}
