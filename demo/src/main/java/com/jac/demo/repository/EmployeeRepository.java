package com.jac.demo.repository;

import com.jac.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployee(){
        //this is the class(method) that needs to connect to database(Table) and fetch the data
//        List<Employee> result= jdbcTemplate.query("SELECT id, employee_name, age from employee_tbl",
//                (rs, rowNum) ->
//                        new Employee(rs.getLong("id"),
//                                rs.getString("employee_name"),
//                                rs.getInt("age")));

        String sql = "SELECT id, employee_name, age from employee_tbl";
        List<Employee> result = jdbcTemplate.query(sql, new EmployeeRowMapper());

        return result;
    }

    public Long saveEmployee(Employee employee){
        String sql = "INSERT INTO employee_tbl(employee_name, age) VALUES(?, ?)";
        //this line will save the value
        jdbcTemplate.update(sql, employee.getEmployeeName(), employee.getAge());

        //I would like to see the id of saved employee
        return jdbcTemplate.queryForObject("SELECT MAX(id) from employee_tbl", Long.class);
    }
}
