package com.example.customerms.exception;

import org.springframework.http.HttpStatus;

public class InsufficientBalanceException extends AppException{
    public InsufficientBalanceException( String message) {
        super(HttpStatus.PERMANENT_REDIRECT, message);
    }
}
