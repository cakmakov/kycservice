package com.cakmakov.kycservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("KYC Müşteri Servisi API")
                        .version("1.0.0")
                        .description("Bu API, bankanın müşteri tanıma (KYC) süreçlerini yönetmek için geliştirilmiştir."));
    }
}
