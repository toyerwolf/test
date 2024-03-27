package com.example.customerms.controller;

import com.example.customerms.dto.CustomerDto;
import com.example.customerms.dto.CustomerReq;
import com.example.customerms.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping()
    public ResponseEntity<List<CustomerDto>> findAllCustomer(){
        List<CustomerDto> customers=customerService.findAllCustomers();
        log.info("successful");
        return new ResponseEntity<>(customers, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<String> registerCustomer(@Valid @ModelAttribute CustomerReq customerReq){
        customerService.createCustomer(customerReq);
        return ResponseEntity.status(200).body("Created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Long id) {
        CustomerDto customerDto = customerService.findCustomerById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping("/decreaseBalance")
    public ResponseEntity<?> decreaseBalance(@RequestParam("customerId") Long customerId, @RequestParam("amount") double amount) {
        customerService.decreaseBalance(customerId, amount);
        return ResponseEntity.ok("Customer balance decreased successfully.");
    }


    @PostMapping("/increaseBalance")
    public ResponseEntity<Void> increaseCustomerBalance(@RequestParam("customerId")  Long customerId, @RequestParam double amount) {
        customerService.increaseBalance(customerId, amount);
        return ResponseEntity.ok().build();
    }


}
