package xin.hesperus.ch5;

import org.junit.Test;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.loader.LaunchedURLClassLoader;
import org.springframework.boot.loader.jar.JarFile;

import java.net.URL;

public class ExecuteTest {

    @Test
    public void test() {
        try {
            JarFile.registerUrlProtocolHandler();
            LaunchedURLClassLoader classLoader = new LaunchedURLClassLoader(
                    new URL[] {
                            new URL("jar:file:/Users/fangjian/Develop/gitrepository/springboot-analysis/springboot-executable-jar/target/executable-jar-1.0-SNAPSHOT.jar!/lib/spring-boot-loader-2.1.3..RELEASE.jar!/")
                            , new URL("jar:file:/Users/fangjian/Develop/gitrepository/springboot-analysis/springboot-executable-jar/target/executable-jar-1.0-SNAPSHOT.jar!/lib/spring-boot-2.1.3..RELEASE.jar!/")
                    },
                    ExecuteTest.class.getClassLoader());

            classLoader.loadClass("org.springframework.boot.loader.JarLauncher");
            classLoader.loadClass("org.springframework.boot.SpringApplication");
            classLoader.loadClass("org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
