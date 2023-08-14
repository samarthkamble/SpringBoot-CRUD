package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.repo.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> updateProject(Long id, Project projectDetails) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project existingProject = optionalProject.get();
            existingProject.setProjectName(projectDetails.getProjectName());
            existingProject.setDateOfStart(projectDetails.getDateOfStart());
            existingProject.setTeamSize(projectDetails.getTeamSize());
            projectRepository.save(existingProject);
        }
        return optionalProject;
    }

    public boolean deleteProject(Long id) {
        try {
            projectRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

