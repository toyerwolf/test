package com.example.customerms.exception;

import org.springframework.http.HttpStatus;

public class CustomerAlreadyExistException extends AppException {
    public CustomerAlreadyExistException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
