package springlearning.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springlearning.cruddemo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository // This annotation indicates that this class is a DAO component
public class EmployeeDAOImplement implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        // Create a query to retrieve all employees
        employees = entityManager.createQuery("from Employee" , Employee .class).getResultList();

        return employees;


    }
}
