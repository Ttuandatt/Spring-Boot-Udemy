package com.example.practiceSpringMVC.controller;

import com.example.practiceSpringMVC.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}") // Injecting a list of countries from application.properties
    private List<String> countries;

    @Value("${programmingLanguages}") // Injecting a list of programming languages from application.properties
    private List<String> programingLanguages;

    @Value("${systems}") // Injecting a list of favorite operating systems from application.properties
    private List<String> systems;


    @GetMapping("/showStudentForm")
    public String showInputForm(Model model) {

        // Add an empty Student object to the model
        Student student = new Student();

        // Add the Student object to the model
        model.addAttribute("student", student);

        // Add the list of countries to the model
        model.addAttribute("countries", countries);

        // Add the list of programming languages to the model
        model.addAttribute("programingLanguages", programingLanguages);

        // Add the list of favorite operating systems to the model
        model.addAttribute("systems", systems);

        // Return the name of the HTML template to be rendered
        return "inputForm"; // inputForm là tên của file inputForm.html trong thư mục templates
    }

    @RequestMapping("/processStudentForm")
    public String processInputForm(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult, Model model) {
        // log the input data (for demonstration purposes)
        System.out.println("The student: " + student.getFirstName() + " " + student.getLastName());

        if(bindingResult.hasErrors()) {
            // If there are validation errors, return to the input form
            model.addAttribute("countries", countries);
            model.addAttribute("programingLanguages", programingLanguages);
            model.addAttribute("systems", systems);
            return "inputForm"; // inputForm là tên của file inputForm.html trong thư mục templates
        }else{
            return "helloWorld"; // helloWorld là tên của file helloWorld.html trong thư mục templates
        }
    }
}
