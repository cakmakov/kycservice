package com.cakmakov.kycservice.mapper;

import com.cakmakov.kycservice.dto.CustomerRequest;
import com.cakmakov.kycservice.dto.CustomerResponse;
import com.cakmakov.kycservice.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequest request);

    CustomerResponse toResponse(Customer customer);
}
