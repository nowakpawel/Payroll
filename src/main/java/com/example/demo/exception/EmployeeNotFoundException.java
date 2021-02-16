package com.example.demo.exception;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(Long id) {
        super("User with id: " + id + " not found!");
    }

    public EmployeeNotFoundException (Exception ex) {
        super(ex.toString());
    }
}
