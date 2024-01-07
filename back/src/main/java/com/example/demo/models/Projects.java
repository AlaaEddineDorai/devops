package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String project_name;
    private Number nb_employees;
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public Projects(Long id, String project_name, Number nb_employees, List<Employee> employees) {
        this.id = id;
        this.project_name = project_name;
        this.nb_employees = nb_employees;
        this.employees = employees;
    }

    public Projects() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Number getNb_employees() {
        return nb_employees;
    }

    public void setNb_employees(Number nb_employees) {
        this.nb_employees = nb_employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployee_names(List<Employee> employees) {
        this.employees = employees;
    }
}

