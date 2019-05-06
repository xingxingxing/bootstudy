package xin.hesperus.boot.ch3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import xin.hesperus.boot.ch3.bean.MyConditionalBean;
import xin.hesperus.boot.ch3.condition.ConditionBeanInImport;

//@SpringBootApplication
@ImportResource("classpath:bean.xml")
@Import(ConditionBeanInImport.class)
@PropertySource("classpath:ch2.properties")
public class ConditionalApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConditionalApp.class, args);
        try {
            MyConditionalBean bean = (MyConditionalBean) context.getBean("myConditionalBean");
        }catch (Exception e){
            System.out.println("t条件加载不匹配");
        }
//        System.out.println(bean.getName());
        SpringApplication.exit(context);

    }
}
