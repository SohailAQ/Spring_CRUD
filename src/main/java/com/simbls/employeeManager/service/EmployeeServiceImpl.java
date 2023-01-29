package com.simbls.employeeManager.service;

import com.simbls.employeeManager.entity.Employee;
import com.simbls.employeeManager.exception.UserNotFoundException;
import com.simbls.employeeManager.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByID(Long id){
        return (Employee) employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User with the id " + id + " was not found."));
    }

    @Override
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
