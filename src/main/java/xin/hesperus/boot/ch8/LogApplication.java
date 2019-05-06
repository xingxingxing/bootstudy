package xin.hesperus.boot.ch8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogApplication {

    Logger logger = LoggerFactory.getLogger(LogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class,args);
    }


    @Bean
    public CommandLineRunner runner() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                logger.info("runner execute");
            }
        };
    }
}
