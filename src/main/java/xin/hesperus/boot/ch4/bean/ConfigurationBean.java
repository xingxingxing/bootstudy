package xin.hesperus.boot.ch4.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ConfigurationBean {

//        @Bean(name = "dispatcherServlet") // 这样就不会构造DispatcherServlet，@Controller注解就无法生效了
    public Object test() {
        return new Object();
    }


    @Bean(name = "dispatcherServlet") // 在ServletContextInitializerBeans中调用addAdaptableBeans包装成ServletRegistrationBean
    public DispatcherServlet myDispatcherServlet() {
        return new DispatcherServlet();
    }
}
