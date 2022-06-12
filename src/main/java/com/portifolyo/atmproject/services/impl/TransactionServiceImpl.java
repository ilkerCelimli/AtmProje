package com.portifolyo.atmproject.services.impl;

import com.portifolyo.atmproject.entities.Transaction;
import com.portifolyo.atmproject.repositories.TransactionRepository;
import com.portifolyo.atmproject.services.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Transaction> implements TransactionService {

    private final TransactionRepository transactionRepository;


    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        super(transactionRepository);
        this.transactionRepository = transactionRepository;
    }
}
