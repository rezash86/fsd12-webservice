package com.jac.demo.repository;

import com.jac.demo.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Employee.builder().id(rs.getLong("id"))
                .employeeName( rs.getString("employee_name"))
                .age(rs.getInt("age")).build();
    }
}
