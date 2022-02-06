package org.example.fraud.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FraudCheckResponse {
    private Boolean isFraudster;
}
