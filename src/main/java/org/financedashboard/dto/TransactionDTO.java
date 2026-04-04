package org.financedashboard.dto;

import org.financedashboard.entity.TransactionEntity;
import org.financedashboard.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionDTO {

    TransactionDTO  INSTANCE = Mappers.getMapper(TransactionDTO.class);

    TransactionEntity toTransactionEntity(Transaction transaction);

    Transaction toTransactionModel(TransactionEntity transactionEntity);

}
