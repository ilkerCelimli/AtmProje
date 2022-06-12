package com.portifolyo.atmproject.repositories;

import com.portifolyo.atmproject.entities.Customer;
import com.portifolyo.atmproject.repositories.projections.CustomerInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends BaseRepository<Customer>{


    List<CustomerInfo> findByIsDeletedFalseOrderByUser_NameDesc(Pageable pageable);
    Optional<Customer> findCustomerByIdEquals(String id);

}
