package spring.learning.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    //create a mapping for "/hello"
    @GetMapping("/hello")
    public String hello(Model model) {
        //add an attribute to the model
        model.addAttribute("theDate", java.time.LocalDateTime.now());

        return "helloworld";    //helloworld ở đây là tên của file helloworld.html trong thư mục templates. Cụ thể là src/main/resources/templates/helloworld.html
    }
}
