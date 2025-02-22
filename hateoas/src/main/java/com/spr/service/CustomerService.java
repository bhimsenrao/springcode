package com.spr.service;

import org.springframework.stereotype.Service;

import com.spr.bean.Customer;

@Service
public class CustomerService {
    private final java.util.Map<String, Customer> customerRepository = new java.util.HashMap<>();

    public CustomerService() {
        // Add some dummy data for demonstration
        customerRepository.put("1", new Customer("1", "John Doe", "Acme Corp"));
        customerRepository.put("2", new Customer("2", "Jane Smith", "Tech Solutions"));
    }

    public Customer getCustomerById(String id) {
        return customerRepository.get(id);
    }
}

