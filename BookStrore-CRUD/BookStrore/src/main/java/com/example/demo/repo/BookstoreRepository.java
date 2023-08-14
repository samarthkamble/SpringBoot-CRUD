package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Bookstore;

public interface BookstoreRepository extends JpaRepository<Bookstore, Long> {
}
