package srpingudemy.cruddemo.dao;

import srpingudemy.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO<T> {
    void save(T student);
    List<T> findAll();
    Student findById(int id);
    Student findByEmail(String email);
    int deleteById(int id);
    int deleteAll(); // Optional: method to delete all students
    int update(T student); // Optional: method to update a student

}
