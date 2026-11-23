package com.ems.service;

import org.springframework.stereotype.Service;

import com.ems.repository.EmployeeRepository;

@Service 
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public String getEmployeeStatus(){
        return "Employee Service is Working!";
    }
}
