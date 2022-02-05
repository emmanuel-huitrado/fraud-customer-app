package org.example.customer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.customer.model.Customer;
import org.example.customer.repository.CustomerRepository;
import org.example.customer.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder().
                            firstName(request.getFirstName())
                            .lastName(request.getLastName())
                            .email(request.getEmail())
                            .build();
        //todo: validate fields
        customerRepository.save(customer);
        log.info("Customer {} saved on the db", customer);
    }
}
