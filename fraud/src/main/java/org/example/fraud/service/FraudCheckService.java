package org.example.fraud.service;

import lombok.AllArgsConstructor;
import org.example.fraud.model.FraudCheckHistory;
import org.example.fraud.repository.FraudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudRepository fraudRepository;

    public Boolean isFraudulentCustomer(Long customerId){
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(Boolean.FALSE)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return Boolean.FALSE;
    }
}
