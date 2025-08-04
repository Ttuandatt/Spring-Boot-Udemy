package com.example.practiceSpringMVC.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/showInputForm")
    public String showInputForm() {
        return "inputForm";
    }

    @RequestMapping("/processInputForm")
    public String processInputForm(HttpServletRequest request, Model model) {

        // Read the request parameter from the HTML form
        String studentName = request.getParameter("studentName");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        // conert the data to caps
        if(studentName != null){
            studentName = studentName.toUpperCase();
        }

        model.addAttribute("studentName", studentName);
        model.addAttribute("age", age);
        model.addAttribute("email", email);
        model.addAttribute("phoneNumber", phoneNumber);

        return "helloWorld";
    }
}
