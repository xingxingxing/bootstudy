package xin.hesperus.boot.ch4.initializer;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;
import xin.hesperus.boot.ch4.servlet.HomeServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Component
public class MyServletContextInitializer implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addServlet("/home",new HomeServlet());
    }
}
