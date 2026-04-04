package org.financedashboard.repository;

import org.financedashboard.entity.TransactionEntity;
import org.financedashboard.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByUserEntityId(Long userId);

    List<TransactionEntity> findByType(TransactionType type);
}
