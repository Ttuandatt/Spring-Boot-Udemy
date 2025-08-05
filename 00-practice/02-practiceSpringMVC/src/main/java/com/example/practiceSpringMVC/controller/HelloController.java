package com.example.practiceSpringMVC.controller;

import com.example.practiceSpringMVC.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController {

    @Value("${countries}") // Injecting a list of countries from application.properties
    private List<String> countryList;

    @Value("${programmingLanguages}") // Injecting a list of programming languages from application.properties
    private List<String> programingLanguages;


    @GetMapping("/showInputForm")
    public String showInputForm(Model model) {

        // Add an empty Student object to the model
        Student student = new Student();

        // Add the Student object to the model
        model.addAttribute("student", student);

        // Add the list of countries to the model
        model.addAttribute("countryList", countryList);

        // Add the list of programming languages to the model
        model.addAttribute("programingLanguages", programingLanguages);

        // Return the name of the HTML template to be rendered
        return "inputForm"; // inputForm là tên của file inputForm.html trong thư mục templates
    }

    @RequestMapping("/processInputForm")
    public String processInputForm(@ModelAttribute("student") Student student) {
        // log the input data (for demonstration purposes)
        System.out.println("The student: " + student.getFirstName() + " " + student.getLastName());

        return "helloWorld"; // helloWorld là tên của file helloWorld.html trong thư mục templates
    }
}
