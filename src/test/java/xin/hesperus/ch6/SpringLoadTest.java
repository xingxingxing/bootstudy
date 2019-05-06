package xin.hesperus.ch6;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.hesperus.boot.ch6.SpringLoadApplication;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import static sun.misc.Version.println;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringLoadApplication.class)
public class SpringLoadTest {

    @Test
    public void testLoad(){
        try {
            Enumeration<URL> files = this.getClass().getClassLoader().getResources(SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION);
            while (files.hasMoreElements()){
                System.out.println(files.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadConfig(){
        List<String> strings = SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, this.getClass().getClassLoader());
        strings.stream().forEach(System.out ::println);
        List<String> list = SpringFactoriesLoader.loadFactoryNames(ApplicationListener.class, this.getClass().getClassLoader());
        list.stream().forEach(System.out ::println);
    }
}
