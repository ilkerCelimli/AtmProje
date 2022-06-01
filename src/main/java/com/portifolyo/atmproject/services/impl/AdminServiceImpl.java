package com.portifolyo.atmproject.services.impl;

import com.portifolyo.atmproject.entities.Admin;
import com.portifolyo.atmproject.repositories.AdminRepository;
import com.portifolyo.atmproject.repositories.CustomerRepository;
import com.portifolyo.atmproject.repositories.projections.CustomerInfo;
import com.portifolyo.atmproject.services.AdminService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;

    public AdminServiceImpl(AdminRepository admin, CustomerRepository customerRepository) {
        super(admin);
        this.adminRepository = admin;
        this.customerRepository = customerRepository;
    }


    public List<CustomerInfo> findCustomers() {
        return customerRepository.findByOrderByUser_CreatedDateDesc(Sort.by("createdDate"));
    }

    @Override
    public boolean CheckAdmin(String email) {
        return this.adminRepository.CheckEmail(email);
    }




}
