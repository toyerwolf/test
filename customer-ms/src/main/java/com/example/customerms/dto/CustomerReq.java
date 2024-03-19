package com.example.customerms.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReq {
    private Long id;

    @NotNull
    @Min(value = 1000, message = "PIN code must be at least 4 digits")
    private Long pinCode;

    @NotNull
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    private String surname;

    @NotNull
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 120, message = "Age must be less than 120")
    private Integer age;

    @NotNull
    private String address;

    @DecimalMin(value = "0.0", message = "Balance must be a positive number")
    private Double balance;
}

