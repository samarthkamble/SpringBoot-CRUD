package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entiry.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
