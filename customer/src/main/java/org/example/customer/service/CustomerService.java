package org.example.customer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.customer.model.Customer;
import org.example.customer.repository.CustomerRepository;
import org.example.customer.request.CustomerRegistrationRequest;
import org.example.customer.response.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder().
                            firstName(request.getFirstName())
                            .lastName(request.getLastName())
                            .email(request.getEmail())
                            .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if(response == null) return;
        log.info("FraudCheckResponse: " + response.toString());

        if(Boolean.TRUE.equals(response.getIsFraudster())){
            log.info("Customer is fraud!");
        }else{
            log.info("Customer {} saved on the db", customer);
        }
    }
}
