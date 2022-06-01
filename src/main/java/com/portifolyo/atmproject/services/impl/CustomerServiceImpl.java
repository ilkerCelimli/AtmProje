package com.portifolyo.atmproject.services.impl;

import com.portifolyo.atmproject.entities.Customer;
import com.portifolyo.atmproject.repositories.CustomerRepository;
import com.portifolyo.atmproject.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

    private CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }




}
