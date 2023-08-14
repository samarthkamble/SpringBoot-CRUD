package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaction;
import com.example.demo.repo.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> updateTransaction(Long id, Transaction transactionDetails) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            Transaction existingTransaction = optionalTransaction.get();
            existingTransaction.setUserName(transactionDetails.getUserName());
            existingTransaction.setEmail(transactionDetails.getEmail());
            existingTransaction.setBusId(transactionDetails.getBusId());
            existingTransaction.setBusName(transactionDetails.getBusName());
            existingTransaction.setNoOfSeat(transactionDetails.getNoOfSeat());
            existingTransaction.setPrice(transactionDetails.getPrice());
            existingTransaction.setTotal(transactionDetails.getTotal());
            existingTransaction.setDate(transactionDetails.getDate());
            transactionRepository.save(existingTransaction);
        }
        return optionalTransaction;
    }

    public boolean deleteTransaction(Long id) {
        try {
            transactionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
