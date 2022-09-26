package com.redcompany.app.customer;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    public void registerCustomer(Customer customer) {

        // todo: check if fraudster
        customerRepository.saveAndFlush(customer);
        Boolean isFraudster = restTemplate.getForObject(
                "http://localhost:8082/api/v1/fraud-check/{customerId}",
                Boolean.class,
                customer.getId());
        System.out.println("The RESPONSE from fraud server<<<" + isFraudster.toString() + ">>>");
        if (isFraudster) {
            throw new IllegalStateException("fraudster");
        }

        // todo:send notification
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
