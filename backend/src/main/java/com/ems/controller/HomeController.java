package com.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.service.EmployeeService;

@RestController
public class HomeController {

    private final EmployeeService employeeService;

    public HomeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/api/health")
    public String healthCheck() {
        return "Employee Management System API is Running!";
    }

    @GetMapping("/api/employee/status")
    public String getEmployeeStatus(){
        return employeeService.getEmployeeStatus();
    }
}
