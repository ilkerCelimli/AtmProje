package com.portifolyo.atmproject.services.impl;

import com.portifolyo.atmproject.entities.Customer;
import com.portifolyo.atmproject.entities.Transaction;
import com.portifolyo.atmproject.entities.dto.SendMoneyDto;
import com.portifolyo.atmproject.repositories.CustomerRepository;
import com.portifolyo.atmproject.repositories.projections.CustomerInfo;
import com.portifolyo.atmproject.services.CustomerService;
import com.portifolyo.atmproject.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

    private final CustomerRepository customerRepository;
    private final TransactionService transactionService;
    private final Logger log;


    public CustomerServiceImpl(CustomerRepository customerRepository,TransactionServiceImpl transactionService) {
        super(customerRepository);
        this.customerRepository = customerRepository;
        this.transactionService = transactionService;
        log = LoggerFactory.getLogger(this.getClass());
    }


    @Override
    public List<CustomerInfo> findByCustomers() {
        List<CustomerInfo> o = this.customerRepository.findByIsDeletedFalseOrderByUser_NameDesc(Pageable.ofSize(50));
        log.info("Müşteriler veritabanından çekildi.");
        return o;
    }

    @Override
    public void sendMoney(List<SendMoneyDto> dtos) {

        Optional<Customer> sender = this.customerRepository.findById(dtos.iterator().next().getId());
        sender.ifPresent(customer1 -> {
           Optional<Customer> recevier = this.customerRepository.findById(dtos.get(1).getId());
                recevier.ifPresent(item -> {
                    Transaction transaction = new Transaction();
                   BigDecimal money = customer1.getBalance();
                  BigDecimal senderMoney = dtos.get(0).getBalance();
                  senderMoney.negate();
                  money.add(senderMoney);
                  if(money.doubleValue() < -0.00001) {
                      customer1.setBalance(money);
                      item.getBalance().add(dtos.get(0).getBalance());
                      transaction.setSender(this.customerRepository.findById(dtos.get(0).getId()).get());
                      transaction.setReceiver(this.customerRepository.findById((dtos.get(1).getId())).get());
                      transaction.setDescription(dtos.get(0).getDescr());

                      try {
                          super.updateEntity(customer1);
                          super.updateEntity(item);
                          this.transactionService.addEntity(transaction);
                          log.info("Para transfer edildi {} {} {}" , customer1.getId(),item.getId(),money);
                      } catch (SQLException e) {
                          log.error("Hata");
                      }

                  }
                });
                }

        );
    }
}
