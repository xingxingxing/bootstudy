package xin.hesperus.boot.ch4.servlet;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomServletRegistrationBean {

        @Bean
        public ServletRegistrationBean customServlet(){
            return new ServletRegistrationBean(new CustomServlet(),"/custom");
        }


         static class CustomServlet extends HttpServlet{
            @Override
            protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                super.service(req, resp);
                resp.getWriter().println("hello this is a custom servlet");
            }

        }
}



