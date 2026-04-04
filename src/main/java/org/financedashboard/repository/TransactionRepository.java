package org.financedashboard.repository;

import org.financedashboard.entity.Transaction;
import org.financedashboard.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByType(TransactionType type);
}
