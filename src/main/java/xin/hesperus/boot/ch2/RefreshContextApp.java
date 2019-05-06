package xin.hesperus.boot.ch2;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import xin.hesperus.boot.ch2.bean.ImportService;
import xin.hesperus.boot.ch2.listener.MyContextListener;

//@SpringBootApplication
@Import(ImportService.class)
@ImportResource("classpath:bean.xml")
@PropertySource("classpath:ch2.properties")
public class RefreshContextApp {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF)
                .initializers().listeners(new MyContextListener()).build(args);
        ConfigurableApplicationContext context = app.run(RefreshContextApp.class);
        SpringApplication.exit(context);
    }
}
