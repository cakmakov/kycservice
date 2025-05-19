package com.cakmakov.kycservice.dto;

import com.cakmakov.kycservice.entity.KycStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private Long id;
    private String fullName;
    private String email;
    private String identityNumber;
    private KycStatus kycStatus;
}
