package com.portifolyo.atmproject.services;

import com.portifolyo.atmproject.entities.Customer;
import com.portifolyo.atmproject.entities.dto.SendMoneyDto;
import com.portifolyo.atmproject.repositories.projections.CustomerInfo;

import java.util.List;
import java.util.Optional;

public interface CustomerService extends BaseService<Customer>{

   List<CustomerInfo> findByCustomers();

   void sendMoney(List<SendMoneyDto> dtos);
}
