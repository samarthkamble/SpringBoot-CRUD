package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
