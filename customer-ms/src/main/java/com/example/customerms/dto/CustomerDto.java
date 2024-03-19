package com.example.customerms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private Long pinCode;
    private String name;
    private String surname;
    private Integer age;
    private String address;
    private Double balance;

}
