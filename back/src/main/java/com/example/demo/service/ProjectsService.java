package com.example.demo.service;

import com.example.demo.exception.ProjectNotFoundException;
import com.example.demo.models.Projects;
import com.example.demo.repo.ProjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProjectsService {
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectsService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Projects addProject(Projects project) {
        return projectRepo.save(project);
    }

    public List<Projects> findAllProject() {
        return projectRepo.findAll();
    }

    public Projects updateProject(Projects project) {
        return projectRepo.save(project);
    }

    public Projects findProjectById(Long id) {
        return projectRepo.findProjectById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project by id " + id + " not found"));
    }

    public void deleteProject(Long id) {
        projectRepo.deleteProjectById(id);
    }
}
