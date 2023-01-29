package com.simbls.employeeManager.service;

import com.simbls.employeeManager.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> findAllEmployees();

    Employee findEmployeeByID(Long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

}
