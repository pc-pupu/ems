package com.ems.service;

import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeRequest;
import com.ems.dto.EmployeeResponse;
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

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest){

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
        Employee savedEmployee = employeeRepository.save(employee);

        //Convert saved entity to Response DTO
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(savedEmployee.getId());
        employeeResponse.setFirstName(savedEmployee.getFirstName());
        employeeResponse.setLastName(savedEmployee.getLastName());
        employeeResponse.setEmail(savedEmployee.getEmail());
        employeeResponse.setDepartment(savedEmployee.getDepartment());
        employeeResponse.setDesignation(savedEmployee.getDesignation());
        employeeResponse.setCreatedAt(savedEmployee.getCreatedAt());
        return employeeResponse;
    }
}
    