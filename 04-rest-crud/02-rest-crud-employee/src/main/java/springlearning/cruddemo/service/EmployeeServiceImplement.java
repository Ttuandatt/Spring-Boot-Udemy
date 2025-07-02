package springlearning.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springlearning.cruddemo.dao.EmployeeDAO;
import springlearning.cruddemo.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImplement(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
