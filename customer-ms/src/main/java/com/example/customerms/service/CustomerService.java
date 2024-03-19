package com.example.customerms.service;

import com.example.customerms.dto.CustomerDto;
import com.example.customerms.dto.CustomerReq;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> findAllCustomers();
     void createCustomer(CustomerReq customerReq);
     CustomerDto findCustomerById(Long id);

    void decreaseBalance(Long customerId, double amount);

    public void increaseBalance(Long customerId, double amount);
}
