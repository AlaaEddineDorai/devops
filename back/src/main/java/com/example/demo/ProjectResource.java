package com.example.demo;

import com.example.demo.models.Employee;
import com.example.demo.models.Projects;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ProjectsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectResource {
    private final ProjectsService projectsService;

    public ProjectResource(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Projects>> getAllProjects() {
        List<Projects> projects = projectsService.findAllProject();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable("id") Long id) {
        Projects projects = projectsService.findProjectById(id);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Projects> addProject(@RequestBody Projects projects) {
        Projects projects1 = projectsService.addProject(projects);
        return new ResponseEntity<>(projects1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Projects> updateProject(@RequestBody Projects projects) {
        Projects projectUpdate = projectsService.updateProject(projects);
        return new ResponseEntity<>(projectUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {
        projectsService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


