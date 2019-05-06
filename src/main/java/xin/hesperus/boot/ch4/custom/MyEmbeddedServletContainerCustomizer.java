package xin.hesperus.boot.ch4.custom;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


//springboot1.x的相关类如下：
//        org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
//        org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
//        org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer
//        org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory
//        springboot2.x的相关类如下：
//        org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
//        org.springframework.boot.web.server.WebServerFactoryCustomizer
//        org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer
//        org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
@Component
public class MyEmbeddedServletContainerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        ((TomcatServletWebServerFactory)factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                protocol.setMaxConnections(200);
                protocol.setMaxThreads(200);
                protocol.setSelectorTimeout(3000);
                protocol.setSessionTimeout(3000);
                protocol.setConnectionTimeout(3000);
            }
        });

    }
}
