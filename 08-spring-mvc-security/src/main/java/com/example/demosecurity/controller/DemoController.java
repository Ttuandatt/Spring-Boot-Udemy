package com.example.demosecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return  "home";
    }

    // add request mapping for /manager
    @GetMapping("/manager")
    public String showManager(){
        return "manager";
    }

    // add request mapping for /admin
    @GetMapping("/admin")
    public String showAdmin(){
        return "admin";
    }

}
