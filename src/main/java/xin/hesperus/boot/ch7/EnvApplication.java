package xin.hesperus.boot.ch7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
@PropertySource("classpath:ch2.properties")
public class EnvApplication {




    public static void main(String[] args) {
        SpringApplication.run(EnvApplication.class, args);
    }

    @Bean
    CommandLineRunner run(){



        return new CommandLineRunner() {
            @Autowired
            private Environment environment;

            @Value("${my.name}")
            private String name;
            @Override
            public void run(String... args) throws Exception {
                System.out.println(name);
                MutablePropertySources propertySources = ((StandardEnvironment) environment).getPropertySources();
                propertySources.stream().forEach(propertySource -> {
                    System.out.println(propertySource.getName()+propertySource.getSource());
                });
            }
        };
    }
}
