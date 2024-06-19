package com.jac.demo.controller;

import com.jac.demo.model.Employee;
import com.jac.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public List<Employee> getAll(){
        return service.getAllEmployees();
    }

    @PostMapping("/")
    public Long saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }
}
