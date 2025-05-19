package com.cakmakov.kycservice.service;

import com.cakmakov.kycservice.dto.CustomerRequest;
import com.cakmakov.kycservice.dto.CustomerResponse;
import com.cakmakov.kycservice.entity.KycStatus;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest request);
    List<CustomerResponse> getAllCustomers();
    CustomerResponse updateKycStatus(Long customerId, KycStatus newStatus);
}
