package srpingudemy.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import srpingudemy.cruddemo.dao.StudentDAO;
import srpingudemy.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			// Create a new student
			createNewStudent(studentDAO);
		};
	}

	private void createNewStudent(StudentDAO studentDAO) {
		// Create a new student
		System.out.println("Creating a new student...");
		Student student = new Student("John", "Doe", "john@gmail.com");

		// Save the student using the DAO
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// Display the generated ID
		System.out.println("Saved student. Generated ID: " + student.getId());
	}

}
