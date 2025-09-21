package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

    List<Employee> findAllByLastNameAsc(); // Method to find all employees by last name in ascending order

    List<Employee> findAllByLastNameDesc(); // Method to find all employees by last name in descending order
}
