package com.portifolyo.atmproject.services.impl;

import com.portifolyo.atmproject.entities.Admin;
import com.portifolyo.atmproject.repositories.AdminRepository;
import com.portifolyo.atmproject.repositories.CustomerRepository;
import com.portifolyo.atmproject.repositories.projections.CustomerInfo;
import com.portifolyo.atmproject.services.AdminService;
import com.portifolyo.atmproject.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    private final AdminRepository adminRepository;
    private final CustomerService customerService;
    public AdminServiceImpl(AdminRepository admin,CustomerService customerServiceImpl) {
        super(admin);
        this.adminRepository = admin;
        this.customerService = customerServiceImpl;
    }




    @Override
    public boolean checkAdmin(String email) {
        return this.adminRepository.CheckEmail(email);
    }

    @Override
    public List<CustomerInfo> findByCustomers() {
        return customerService.findByCustomers();
    }


}
