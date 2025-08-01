package spring.learning.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // controller method to show input form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form"; // helloworld-form là tên của file helloworld-form.html trong thư mục templates
    }

    // controller method to process input form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld"; // helloworld là tên của file helloworld.html trong thư mục templates
    }
}
