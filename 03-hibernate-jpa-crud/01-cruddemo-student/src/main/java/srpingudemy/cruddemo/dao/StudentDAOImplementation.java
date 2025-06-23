package srpingudemy.cruddemo.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import srpingudemy.cruddemo.entity.Student;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student", Student.class)
                .getResultList();
    }

    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student findByEmail(String email) {
        return entityManager.createQuery("FROM Student WHERE email = :email", Student.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        return entityManager.createQuery("DELETE FROM Student WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student")
                .executeUpdate();
    }

    @Override
    @Transactional
    public int update(Student student) {
        return entityManager.createQuery("UPDATE Student SET firstName = :firstName, lastName = :lastName, email = :email WHERE id = :id")
                .setParameter("firstName", student.getFirstName())
                .setParameter("lastName", student.getLastName())
                .setParameter("email", student.getEmail())
                .setParameter("id", student.getId())
                .executeUpdate();
    }


    // Additional methods for CRUD operations can be added here
}
