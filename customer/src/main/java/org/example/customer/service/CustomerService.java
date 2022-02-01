package org.example.customer.service;

import lombok.extern.slf4j.Slf4j;
import org.example.customer.model.Customer;
import org.example.customer.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {
    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder().
                            firstName(request.getFirstName())
                            .lastName(request.getFirstName())
                            .email(request.getEmail())
                            .build();
        log.info("Customer {} saved on the db", customer);
    }
}
