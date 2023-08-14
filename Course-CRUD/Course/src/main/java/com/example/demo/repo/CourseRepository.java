package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
