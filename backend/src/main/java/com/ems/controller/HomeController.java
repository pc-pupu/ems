package com.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Employee Management System API!";
    }
    
    @GetMapping("/api/health")
    public String healthCheck() {
        return "Employee Management System API is Running!";
    }
}
