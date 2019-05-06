package xin.hesperus.boot.ch4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {


    @RequestMapping("/my")
     public String custom(){
         return "my";
     }

     @RequestMapping("/myerr")
     public String simple(){
        throw new RuntimeException("this is a error");
     }

//     @RequestMapping("/error")
//     @ResponseBody
//     public String error(){
//        return "my error";
//     }
}
