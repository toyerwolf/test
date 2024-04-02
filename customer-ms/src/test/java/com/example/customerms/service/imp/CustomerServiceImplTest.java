package com.example.customerms.service.imp;

import com.example.customerms.entity.Customer;
import com.example.customerms.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void testIncreaseBalance() {
        // Arrange
        Long customerId = 1L;
        double amount = 100.0;
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setBalance(500.0);

        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(customer));

        // Act
        customerService.increaseBalance(customerId, amount);

        // Assert
        assertEquals(600.0, customer.getBalance()); // Проверяем, что баланс увеличился на 100.0
        verify(customerRepository, times(1)).findById(customerId);
        verify(customerRepository, times(1)).save(customer);
    }
}

