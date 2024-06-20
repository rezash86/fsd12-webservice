package com.jac.demo.exception;

public class InvalidEmployeeInformationException extends RuntimeException{

    public InvalidEmployeeInformationException(String field) {
        super("invalid information for " + field);
    }
}
