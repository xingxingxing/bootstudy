package xin.hesperus.boot.ch4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EmbeddedServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedServletApplication.class,args);
    }

}
