package com.cakmakov.kycservice.controller;

import com.cakmakov.kycservice.dto.CustomerRequest;
import com.cakmakov.kycservice.dto.CustomerResponse;
import com.cakmakov.kycservice.entity.Customer;
import com.cakmakov.kycservice.entity.KycStatus;
import com.cakmakov.kycservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "KYC Yönetimi", description = "Müşteri kayıt ve doğrulama işlemleri")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @Operation(summary = "Yeni müşteri oluştur", description = "Müşteri bilgileri ile yeni bir kayıt başlatılır (status = PENDING).")
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest request) {
        CustomerResponse response = customerService.createCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Tüm müşterileri getir", description = "Tüm müşteri kayıtlarını listeler.")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Müşteri KYC durumunu güncelle", description = "ID'ye göre müşterinin KYC durumu güncellenir (PENDING → APPROVED/REJECTED).")
    public ResponseEntity<CustomerResponse> updateKycStatus(
            @PathVariable Long id,
            @RequestParam KycStatus status
    ) {
        CustomerResponse response = customerService.updateKycStatus(id, status);
        return ResponseEntity.ok(response);
    }
}
