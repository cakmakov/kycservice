package com.cakmakov.kycservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {

    @NotBlank(message = "İsim alanı boş olamaz")
    @Size(min = 2, max = 100, message = "İsim 2 ile 100 karakter arasında olmalıdır")
    private String fullName;

    @NotBlank(message = "Email boş olamaz")
    @Email(message = "Geçerli bir email formatı giriniz")
    private String email;

    @NotBlank(message = "Kimlik numarası boş olamaz")
    @Size(min = 11, max = 11, message = "Kimlik numarası 11 haneli olmalıdır")
    private String identityNumber;
}
