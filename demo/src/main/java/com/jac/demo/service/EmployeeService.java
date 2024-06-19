package com.jac.demo.service;

import com.jac.demo.model.Employee;
import com.jac.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees(){
        return repository.getAllEmployee();
    }

    public Long saveEmployee(Employee employee){
        return repository.saveEmployee(employee);
    }
}
