package springlearning.cruddemo.dao;

import springlearning.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

}
