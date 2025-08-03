package spring.learning.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.learning.thymeleafdemo.model.Student;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        // create a new student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        return "student-form"; // student-form là tên của file student-form.html trong thư mục templates
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student){

        // log the input data (for demonstration purposes)
        System.out.println("The student: " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation"; // student-confirmation là tên của file student-confirmation.html trong thư mục templates
    }
}
