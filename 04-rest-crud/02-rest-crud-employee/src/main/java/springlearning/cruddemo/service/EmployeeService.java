package springlearning.cruddemo.service;

import org.springframework.stereotype.Service;
import springlearning.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

}
