package com.example.practice.rest;

import com.example.practice.entity.Employee;
import com.example.practice.exception.AppException;
import com.example.practice.exception.ErrorCode;
import com.example.practice.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee==null){
            throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }else{
            return employee;
    }

    }
}
