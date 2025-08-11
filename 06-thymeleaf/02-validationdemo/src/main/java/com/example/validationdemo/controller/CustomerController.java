package com.example.validationdemo.controller;

import com.example.validationdemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an initbinder ... to remove leading and trailing whitespace
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); // true means trim empty strings to null
        binder.registerCustomEditor(String.class, stringTrimmerEditor); // Register the StringTrimmerEditor for all String fields. This means that any String field in the Customer class will be trimmed of leading and trailing whitespace.b
    }

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

        System.out.println("Last name: |" + customer.getLastName()+"|");

        // Check for validation errors
        if(bindingResult.hasErrors()) {
            return "customer-form"; // If there are errors, return to the form view
        }else{
            return "customer-confirmation"; // Assuming you have a Thymeleaf template named customer-confirmation.html
        }

    }
}
