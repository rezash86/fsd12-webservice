package com.jac.demo.service;

import com.jac.demo.exception.EmployeeNotFoundException;
import com.jac.demo.exception.InvalidEmployeeInformationException;
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
        if(employee.getAge() > 100 || employee.getAge()<15){
            throw new InvalidEmployeeInformationException("age");
        }
        return repository.saveEmployee(employee);
    }

    public Employee getEmployeeById(Long id){
        var emp = this.getEmpById(id);
        if(emp == null){
            //throw exception
            throw new EmployeeNotFoundException(id);
        }
        return emp;
    }

    public void updateEmployee(Long id, Employee emp){
        if(this.getEmpById(id) == null){
            //throw exception
            throw new EmployeeNotFoundException(id);
        }
        repository.updateEmployee(id, emp);
    }

    public void deleteEmp(Long id){
        //handling business exception
        //check if the employee exist
        //if it exists then delete it
        //if not throw an exception

        //first try to validate
        if(this.getEmpById(id) == null){
            //throw exception
            throw new EmployeeNotFoundException(id);
        }

        repository.deleteEmp(id);

    }

    private Employee getEmpById(Long id){
        return this.repository.getEmployeeById(id);
    }
}
