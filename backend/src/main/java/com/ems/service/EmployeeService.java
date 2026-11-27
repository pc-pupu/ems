package com.ems.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeRequest;
import com.ems.dto.EmployeeResponse;
import com.ems.entity.Employee;
import com.ems.exception.DuplicateEmailException;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String getEmployeeStatus() {
        return "Employee Service is Working!";
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {

        // Check duplicate email
        if (employeeRepository.existsByEmail(employeeRequest.getEmail())) {
            throw new DuplicateEmailException("Employee email already exist");
        }

        // Convert DTO to Entity
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setSalary(employeeRequest.getSalary());
        employee.setDesignation(employeeRequest.getDesignation());

        // save into DB
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert saved entity to Response DTO
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

    public List<EmployeeResponse> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> {
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setId(employee.getId());
            employeeResponse.setFirstName(employee.getFirstName());
            employeeResponse.setLastName(employee.getLastName());
            employeeResponse.setEmail(employee.getEmail());
            employeeResponse.setDepartment(employee.getDepartment());
            employeeResponse.setDesignation(employee.getDesignation());
            employeeResponse.setCreatedAt(employee.getCreatedAt());
            return employeeResponse;
        }).collect(Collectors.toList());
    }

    public EmployeeResponse getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setDepartment(employee.getDepartment());
        employeeResponse.setDesignation(employee.getDesignation());
        employeeResponse.setCreatedAt(employee.getCreatedAt());

        return employeeResponse;

    }

    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest){
        //Find existing employee
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: "+id));

        //Check another employee owns this email
        if(employeeRepository.existsByEmailAndIdNot(employeeRequest.getEmail(), employee.getId())){
            throw new DuplicateEmailException("Employee email already exist.");
        }
        
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setSalary(employeeRequest.getSalary());
        employee.setDesignation(employeeRequest.getDesignation());
        employee.setDepartment(employeeRequest.getDepartment());

        // Save update employee
        Employee updateEmployee = employeeRepository.save(employee);

        // Convert updated entity to Response DTO
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(updateEmployee.getId());
        employeeResponse.setFirstName(updateEmployee.getFirstName());
        employeeResponse.setLastName(updateEmployee.getLastName());
        employeeResponse.setEmail(updateEmployee.getEmail());
        employeeResponse.setDesignation(updateEmployee.getDesignation());
        employeeResponse.setDepartment(updateEmployee.getDepartment());

        return employeeResponse;

    }
}
