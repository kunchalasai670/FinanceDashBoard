package org.financedashboard.service;


import org.financedashboard.entity.Transaction;
import org.financedashboard.entity.TransactionType;
import org.financedashboard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DashboardService {

    @Autowired
    private TransactionRepository repo;

    public Map<String, Double> getSummary() {

        List<Transaction> list = repo.findAll();

        double income = 0;
        double expense = 0;

        for (Transaction t : list) {

            if (t.getType() == TransactionType.INCOME) {
                income += t.getAmount();
            }
            else if (t.getType() == TransactionType.EXPENSE) {
                expense += t.getAmount();
            }
        }

        double balance = income - expense;

        Map<String, Double> map = new HashMap<>();
        map.put("income", income);
        map.put("expense", expense);
        map.put("balance", balance);

        return map;
    }
}