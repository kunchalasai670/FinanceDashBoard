package org.financedashboard.service;


import org.financedashboard.dto.TransactionDTO;
import org.financedashboard.entity.TransactionEntity;
import org.financedashboard.model.Transaction;
import org.financedashboard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    private final TransactionDTO mapper = TransactionDTO.INSTANCE;

    public Transaction create(Transaction t) {
        TransactionEntity entity = mapper.toTransactionEntity(t);
        TransactionEntity saved = repo.save(entity);
        return mapper.toTransactionModel(saved);
    }

    public List<Transaction> getAll() {

        List<TransactionEntity> entities = repo.findAll();

        List<Transaction> result = new ArrayList<>();

        for (TransactionEntity entity : entities) {
            Transaction model = mapper.toTransactionModel(entity);
            result.add(model);
        }

        return result;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
