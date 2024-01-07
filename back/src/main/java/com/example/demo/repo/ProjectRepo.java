package com.example.demo.repo;

import com.example.demo.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Projects,Long> {
    void deleteProjectById(Long id);

    Optional<Projects> findProjectById(Long id);
}
