package com.example.customerms.mapper;

import com.example.customerms.dto.CustomerDto;
import com.example.customerms.dto.CustomerReq;
import com.example.customerms.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "id", ignore = true)
    Customer customerReqToCustomer(CustomerReq customerReq);


//    @Mapping(target = "id", source = "id")
    CustomerDto customerToCustomerDto(Customer customer);
}
