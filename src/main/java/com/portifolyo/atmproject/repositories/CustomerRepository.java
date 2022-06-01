package com.portifolyo.atmproject.repositories;

import com.portifolyo.atmproject.entities.Customer;
import com.portifolyo.atmproject.repositories.projections.CustomerInfo;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CustomerRepository extends BaseRepository<Customer>{
    List<CustomerInfo> findByOrderByUser_CreatedDateDesc(Sort sort);




}
