package spring.learning.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // controler to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);


        return "helloworld"; // helloworld là tên của file helloworld.html trong thư mục templates
    }
}
