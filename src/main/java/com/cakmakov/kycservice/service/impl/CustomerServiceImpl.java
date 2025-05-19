package com.cakmakov.kycservice.service.impl;

import com.cakmakov.kycservice.dto.CustomerRequest;
import com.cakmakov.kycservice.dto.CustomerResponse;
import com.cakmakov.kycservice.entity.Customer;
import com.cakmakov.kycservice.entity.KycStatus;
import com.cakmakov.kycservice.exception.CustomerNotFoundException;
import com.cakmakov.kycservice.mapper.CustomerMapper;
import com.cakmakov.kycservice.repository.CustomerRepository;
import com.cakmakov.kycservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        customer.setKycStatus(KycStatus.PENDING);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse updateKycStatus(Long customerId, KycStatus newStatus) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Müşteri bulunamadı: " + customerId));
        customer.setKycStatus(newStatus);
        Customer updated = customerRepository.save(customer);
        return customerMapper.toResponse(updated);
    }
}
