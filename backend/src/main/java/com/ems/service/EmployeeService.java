package com.ems.service;

import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeRequest;
import com.ems.entity.Employee;
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

    public Employee createEmployee(EmployeeRequest employeeRequest){

        //Check duplicate email
        if(employeeRepository.existsByEmail(employeeRequest.getEmail())){
            throw new RuntimeException("Employee email already exist");
        }

        //Convert DTO to Entity
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setSalary(employeeRequest.getSalary());
        employee.setDesignation(employeeRequest.getDesignation());

        //save into DB
        return employeeRepository.save(employee);
    }
}
