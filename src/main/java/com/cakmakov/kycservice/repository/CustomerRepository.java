package com.cakmakov.kycservice.repository;

import com.cakmakov.kycservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
    boolean existsByIdentityNumber(String identityNumber);
}
