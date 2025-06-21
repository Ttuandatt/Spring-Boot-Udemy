package srpingudemy.cruddemo.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import srpingudemy.cruddemo.entity.Student;

@Repository
public class StudentDAOImplementation implements StudentDAO<Student> {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        // Save the student using the EntityManager
        entityManager.persist(student);
        // Alternatively, you can use entityManager.merge(student) for updates
        // entityManager.merge(student);
    }

    // Additional methods for CRUD operations can be added here
}
