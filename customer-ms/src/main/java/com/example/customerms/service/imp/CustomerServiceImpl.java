package com.example.customerms.service.imp;

import com.example.customerms.dto.CustomerDto;
import com.example.customerms.dto.CustomerReq;
import com.example.customerms.entity.Customer;
import com.example.customerms.exception.CustomerAlreadyExistException;
import com.example.customerms.exception.CustomerNotFoundException;
import com.example.customerms.exception.InsufficientBalanceException;
import com.example.customerms.mapper.CustomerMapper;
import com.example.customerms.repository.CustomerRepository;
import com.example.customerms.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper=CustomerMapper.INSTANCE;
    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(CustomerMapper.INSTANCE::customerToCustomerDto)
                .collect(Collectors.toList());
    }





    @Override
    public void createCustomer(CustomerReq customerReq) {
        Customer existingCustomer=customerRepository.findByPinCode(customerReq.getPinCode());
        if(existingCustomer!=null){
            throw new CustomerAlreadyExistException("Customer with pincode " +customerReq.getPinCode() + " already exist");
        }
        Customer customer=customerMapper.customerReqToCustomer(customerReq);
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + " not found"));
        return CustomerMapper.INSTANCE.customerToCustomerDto(customer);
    }

    @Override
    @Transactional
    public void decreaseBalance(Long customerId, double amount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + customerId + " not found"));
        double currentBalance = customer.getBalance();
        if (currentBalance >= amount) {
            customer.setBalance(currentBalance - amount);
            customerRepository.save(customer);
            log.info("Customer balance decreased successfully.");
        } else {
            throw new InsufficientBalanceException("Insufficient balance for customer with id " + customerId);
        }
    }

    @Override
    @Transactional
    public void increaseBalance(Long customerId, double amount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + customerId + " not found"));
        double currentBalance = customer.getBalance();
        double newBalance = currentBalance + amount;
        customer.setBalance(newBalance);
        customerRepository.save(customer);
        log.info("Customer balance increased successfully.");
    }


}




