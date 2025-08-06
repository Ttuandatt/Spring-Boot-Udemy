package com.example.validationdemo.controller;

import com.example.validationdemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/showCustomerForm")
    public String showCustomerForm(Model model) {
        // This method will return the name of the view to be rendered
        // In a real application, you would return a view name like "customerForm"
        model.addAttribute("customer", new Customer());

        return "customer-form"; // Assuming you have a Thymeleaf template named customer-form.html
    }

    @PostMapping("/processCustomerForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        // @Valid annotation is used to trigger validation on the Customer object
        // BindingResult is used to hold the result of the validation and any errors


        // Check for validation errors
        if(bindingResult.hasErrors()) {
            return "customer-form"; // If there are errors, return to the form view
        }else{
            return "customer-confirmation"; // Assuming you have a Thymeleaf template named customer-confirmation.html
        }
    }
}
