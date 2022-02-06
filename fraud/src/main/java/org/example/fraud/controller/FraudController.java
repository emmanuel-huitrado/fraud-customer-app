package org.example.fraud.controller;

import lombok.AllArgsConstructor;
import org.example.fraud.response.FraudCheckResponse;
import org.example.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId){
        return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
    }
}