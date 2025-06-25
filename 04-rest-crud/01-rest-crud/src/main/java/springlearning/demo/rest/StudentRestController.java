//Step 3: Update REST service to handle exceptions
package springlearning.demo.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springlearning.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> studentList = new ArrayList<>();


    @PostConstruct
    public void loadData(){
        //We temporarily hardcode some data
        studentList.add(new Student("John", "Doe"));
        studentList.add(new Student("Jane", "White"));
        studentList.add(new Student("Jim", "Beam"));
    }

    // Keeping the initialization and hardcoded data inside the @GetMapping method would recreate the list and add the same students every time the endpoint is called, resulting in a new list for each request.
    // By moving the initialization and data loading to a field and the @PostConstruct method, the list is created and populated only once when the controller is initialized, so all requests return the same list instance and avoid unnecessary object creation.
    @GetMapping("/students")
    public List<Student> getStudents(){

        return studentList;
    }

    //The @PathVariable annotation is used in Spring Boot to extract values from the URI path and bind them to method parameters. In your code, it allows the studentId value from the URL /students/{studentId} to be passed into the getStudentById method, so you can retrieve the specific student by their index or ID.
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        if(studentId<0 || studentId>= studentList.size()){
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        return studentList.get(studentId);
    }

    //Step 4: Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //Create a StudentErrorResponse object
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //Add another exception handler for catching all exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
