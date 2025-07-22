package com.example.practice.service;

import com.example.practice.dao.EmployeeRepository;
import com.example.practice.entity.Employee;
import com.example.practice.exception.AppException;
import com.example.practice.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
