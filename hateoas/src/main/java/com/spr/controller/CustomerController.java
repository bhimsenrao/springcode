package com.spr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.bean.Customer;
import com.spr.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerResource getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        CustomerResource resource = new CustomerResource();
        resource.setId(customer.getId());
        resource.setName(customer.getName());
        resource.setCompany(customer.getCompany());

        // Add links
        Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class)
                                       .slash(id)
                                       .withSelfRel();
        resource.add(selfLink);

        return resource;
    }
}