package com.simbls.employeeManager.repository;

import com.simbls.employeeManager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Object> findEmployeeById(Long id);
}
