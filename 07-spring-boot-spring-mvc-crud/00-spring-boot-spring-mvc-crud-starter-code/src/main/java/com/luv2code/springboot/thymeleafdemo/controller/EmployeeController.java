package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String listEmployees(@RequestParam(value = "sort", required = false) String sort, Model model) {
        List<Employee> employeeList;

        if ("lastNameAsc".equals(sort)) {
            employeeList = employeeService.findAllByLastNameAsc();
        } else if ("lastNameDesc".equals(sort)) {
            employeeList = employeeService.findAllByLastNameDesc();
        } else {
            employeeList = employeeService.findAll();
        }

        model.addAttribute("employeeList", employeeList);
        return "employees/list-employees";
    }


    // add mapping for "/showAddForm"
    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        // return "add-employee" view
        return "employees/employee-form";
    }

    // add mapping for "/save"
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save the employee using our service
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("employeeId") int theId, Model model) {

        // get the employee from the service
        Employee employee = employeeService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);

        // send over to our form
        return "employees/employee-form";
    }
}
