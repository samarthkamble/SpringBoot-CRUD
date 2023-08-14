package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserName(String userName);
}
