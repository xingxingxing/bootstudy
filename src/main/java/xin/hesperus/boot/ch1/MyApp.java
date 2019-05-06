package xin.hesperus.boot.ch1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import xin.hesperus.boot.ch1.bean.User;

//@SpringBootApplication
public class MyApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyApp.class, args);
        try{
            User user = context.getBean("testBean",User.class);
            System.out.println(user.getId());
            System.out.println(user.getName());
            SpringApplication.exit(context);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
