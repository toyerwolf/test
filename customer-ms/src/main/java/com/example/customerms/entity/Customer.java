package com.example.customerms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers",schema = "customer",catalog = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long pinCode;
    private String name;
    private String surname;
    private Integer age;
    private String address;
    private Double balance;

}
