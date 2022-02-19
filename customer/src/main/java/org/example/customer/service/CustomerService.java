package org.example.customer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clients.fraud.FraudClient;
import org.example.clients.fraud.responses.FraudCheckResponse;
import org.example.customer.model.Customer;
import org.example.customer.repository.CustomerRepository;
import org.example.customer.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder().
                            firstName(request.getFirstName())
                            .lastName(request.getLastName())
                            .email(request.getEmail())
                            .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if(response == null) return;
        log.info("FraudCheckResponse: " + response.toString());

        if(Boolean.TRUE.equals(response.getIsFraudster())){
            log.info("Customer is fraud!");

        }else{
            log.info("Customer {} saved on the db", customer);
        }


    }
}
