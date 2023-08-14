package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {
}

