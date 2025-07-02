package springlearning.cruddemo.dao;

import jakarta.persistence.EntityManager;
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

    @Override
    public Employee findById(int id) {
        // find the employee by id
        Employee employee = entityManager.find(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {

        // Check if the employee has an ID
        if(employee.getId() == 0){
            entityManager.persist(employee); // If ID is 0, it's a new employee, so persist it
        }else{
            entityManager.merge(employee); // If ID is not 0, it's an existing employee, so merge it
        }

        return employee; // Return the saved employee
    }

    @Override
    public void deleteById(int id) {
        // Find the employee by ID
        Employee employee = entityManager.find(Employee.class, id);

        // If the employee is found, remove it; otherwise, throw an exception
        if(employee != null){
            entityManager.remove(employee); // Remove the employee if found
        } else {
            throw new RuntimeException("Employee with id " + id + " not found"); // Throw an exception if not found
        }
    }
}
