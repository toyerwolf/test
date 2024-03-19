package com.example.customerms.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends AppException{
    public CustomerNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }
}
