package org.example.customer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.customer.model.Customer;
import org.example.customer.request.CustomerRegistrationRequest;
import org.example.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest){
        log.info("new customer registration {}", customerRequest);
        service.registerCustomer(customerRequest);
    }
}
