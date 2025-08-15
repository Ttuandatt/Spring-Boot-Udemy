package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to find all employees by last name in ascending order
    List<Employee> findAllByOrderByLastNameAsc(); // This method will be automatically implemented by Spring Data JPA

    // add a method to find all employees by last name in descending order
    List<Employee> findAllByOrderByLastNameDesc(); // This method will be automatically implemented by Spring Data JPA
}
