package com.example.practice.service;

import com.example.practice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee updateEmployee(int id, Employee employee);
    void deleteById(Integer id);
}
