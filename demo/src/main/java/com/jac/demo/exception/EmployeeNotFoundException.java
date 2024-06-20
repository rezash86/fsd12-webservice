package com.jac.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long empId) {
        super("Employee Not Found ->" + empId);
    }
}
