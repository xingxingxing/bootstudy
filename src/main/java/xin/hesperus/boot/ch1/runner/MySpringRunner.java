package xin.hesperus.boot.ch1.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MySpringRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MySpringRunner start  ");
    }
}
