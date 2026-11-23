package com.ems.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    boolean existsByEmail(String email);

    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(BigDecimal salary);
}
