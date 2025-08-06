package spring.learning.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.learning.thymeleafdemo.model.Student;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}") // Injecting a list of countries from application.properties
    private List<String> countries;

    @Value("${languages}") // Injecting a list of favorite languages from application.properties
    private List<String> languages;

    @Value("${systems}") // Injecting a list of favorite operating systems from application.properties
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){ // Model is used to pass data to the view
        // create a new student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        // add the list of countries to the model
        model.addAttribute("countries", countries);

        // add the list of favorite languages to the model
        model.addAttribute("languages", languages);

        // add a list of favorite operating systems
        model.addAttribute("systems", systems);

        return "student-form"; // student-form là tên của file student-form.html trong thư mục templates
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student){

        // log the input data (for demonstration purposes)
        System.out.println("The student: " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation"; // student-confirmation là tên của file student-confirmation.html trong thư mục templates
    }
}
