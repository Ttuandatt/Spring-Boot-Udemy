package springlearning.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springlearning.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();

        //We temporarily hardcode some data
        studentList.add(new Student("John", "Doe"));
        studentList.add(new Student("Jane", "White"));
        studentList.add(new Student("Jim", "Beam"));

        return studentList;
    }

}
