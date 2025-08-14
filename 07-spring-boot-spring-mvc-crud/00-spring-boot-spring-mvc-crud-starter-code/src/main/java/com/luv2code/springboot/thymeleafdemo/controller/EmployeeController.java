package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {
        // get employees from db
        List<Employee> employeeList = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employeeList", employeeList);

        // return "list-employees" view
        return "list-employees";
    }
}
