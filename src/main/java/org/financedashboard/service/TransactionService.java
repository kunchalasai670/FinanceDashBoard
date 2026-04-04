package org.financedashboard.service;


import org.financedashboard.entity.Transaction;
import org.financedashboard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    public Transaction create(Transaction t) {
        return repo.save(t);
    }

    public List<Transaction> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
