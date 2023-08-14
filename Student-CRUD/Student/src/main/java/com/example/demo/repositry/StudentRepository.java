package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
