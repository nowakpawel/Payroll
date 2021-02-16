package com.example.demo.exception;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(Long id) {
        super("Order with id: " + id + " not found!");
    }
}
