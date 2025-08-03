package com.example.practice.rest;

import com.example.practice.entity.Employee;
import com.example.practice.exception.AppException;
import com.example.practice.exception.ErrorCode;
import com.example.practice.service.EmployeeService;
import com.example.practice.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

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

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
        if (employee == employeeService.findById(employeeId)) { //If the employee has an id that does not exist <=> Employee not found
            throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }else{
            if(employee.getFirstName() == null && employee.getLastName() == null && employee.getEmail() == null){
                throw new AppException(ErrorCode.NULL_PAYLOAD);
            }
            if(employee.getFirstName() == null){
                throw new AppException(ErrorCode.NULL_PAYLOAD_FIRSTNAME);
            }else if(employee.getLastName() == null){
                throw new AppException(ErrorCode.NULL_PAYLOAD_LASTNAME);
            }else if(employee.getEmail() == null){
                throw new AppException(ErrorCode.NULL_PAYLOAD_EMAIL);
            }

            else{
                return employeeService.updateEmployee(employeeId, employee);
            }
        }
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad) {
        Employee existingEmployee = employeeService.findById(employeeId);

        // Throw exception if employee not found
        if(existingEmployee==null){
            throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }
        // Throw exception if patch payload is empty
        if (patchPayLoad.isEmpty()) {
            throw new AppException(ErrorCode.NULL_PAYLOAD);
        }
        // Throw exception if patch payload contains id
        if (patchPayLoad.containsKey("id")) {
            throw new AppException(ErrorCode.ID_INCLUDED);
        }

        // Update the existing employee with the patch payload
        try{
            Employee updatedEmployee = objectMapper.convertValue(patchPayLoad, Employee.class);
            if (updatedEmployee.getFirstName() != null) {
                existingEmployee.setFirstName(updatedEmployee.getFirstName());
            }
            if (updatedEmployee.getLastName() != null) {
                existingEmployee.setLastName(updatedEmployee.getLastName());
            }
            if (updatedEmployee.getEmail() != null) {
                existingEmployee.setEmail(updatedEmployee.getEmail());
            }
            return employeeService.saveEmployee(existingEmployee);
        } catch (Exception e) {
            throw new AppException(ErrorCode.NULL_PAYLOAD);
        }
    }
}
