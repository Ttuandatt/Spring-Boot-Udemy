package srpingudemy.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import srpingudemy.cruddemo.dao.StudentDAO;
import srpingudemy.cruddemo.entity.Student;

import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			Scanner scanner = new Scanner(System.in);

			// Create a new student
			createNewStudent(studentDAO);

			//Create multiple students
			createMultipleStudents(studentDAO);

			//get all students
			System.out.println("Retrieving all students...");
			getAllStudents(studentDAO);

			System.out.print("Enter student ID to retrieve: ");
			int id = scanner.nextInt();
			// Get student by ID
			getById(studentDAO, id);

			//Get student by email
			System.out.print("Enter student email to retrieve: ");
			String email = scanner.next();
			getByEmail(studentDAO, email);

			//Delete student by ID
			System.out.print("Enter student ID to delete: ");
			int deleteId = scanner.nextInt();
			deleteById(studentDAO, deleteId);


			//Update student
			System.out.print("Enter student ID to update: ");
			int updateId = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character
			System.out.print("Enter new first name: ");
			String firstName = scanner.nextLine();
			System.out.print("Enter new last name: ");
			String lastName = scanner.nextLine();
			System.out.print("Enter new email: ");
			String newEmail = scanner.nextLine();
			Student studentToUpdate = new Student(firstName, lastName, newEmail);
			studentToUpdate.setId(updateId);
			updateStudent(studentDAO, studentToUpdate);

//			// Delete all students
//			System.out.println("Deleting all students...");
//			deleteAllStudents(studentDAO);

		};
	}

	//CRUD operations
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

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating a new student...");
		Student student1 = new Student("John", "Doe", "john@gmail.com");
		Student student2 = new Student("Donny", "Kelve", "don@gmail.com");
		Student student3 = new Student("Shake", "Will", "john@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}


	private void getAllStudents(StudentDAO studentDAO){
		//Retrieve all students
		System.out.println("Retrieving all students...");
		var students = studentDAO.findAll();

		// Display the students
		for (Object student : students) {
			System.out.println(student);
		}
	}

	private void getById(StudentDAO studentDAO, int id) {
		System.out.println("Retrieving student with ID: "+id);
		System.out.println(studentDAO.findById(id));
	}

	private void getByEmail(StudentDAO studentDAO, String email){
		System.out.println("Retrieving student with email: " + email);
		Student s = studentDAO.findByEmail(email);
		if(s != null){
			System.out.println(s);
		} else {
			System.out.println("No student found with email: " + email);
		}
	}


	private void deleteById(StudentDAO studentDAO, int id){
		System.out.println("Deleting student with ID: " + id);
		int rowsAffected = studentDAO.deleteById(id);
		if(rowsAffected>0){
			System.out.println("Deleted student with ID: " + id);
		} else {
			System.out.println("No student found with ID: " + id);
		}
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int rowsAffected = studentDAO.deleteAll();
		System.out.println("Deleted " + rowsAffected + " students.");
	}

	private void updateStudent(StudentDAO studentDAO, Student student) {
		System.out.println("Updating student with ID: " + student.getId());
		int rowsAffected = studentDAO.update(student);
		if(rowsAffected > 0){
			System.out.println("Updated student: " + student);
		} else {
			System.out.println("No student found with ID: " + student.getId());
		}
	}
}
