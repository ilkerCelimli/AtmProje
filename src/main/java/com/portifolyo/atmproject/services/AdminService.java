package com.portifolyo.atmproject.services;

import com.portifolyo.atmproject.entities.Admin;
import com.portifolyo.atmproject.repositories.projections.CustomerInfo;

import java.util.List;

public interface AdminService extends BaseService<Admin>{

    List<CustomerInfo> findCustomers();
    boolean CheckAdmin(String email);
}
