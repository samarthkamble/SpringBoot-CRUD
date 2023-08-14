package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

