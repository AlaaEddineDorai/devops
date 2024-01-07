package com.example.demo.service;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.models.Employee;
import com.example.demo.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    @Autowired
    public  EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmpCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }
    public Employee  updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id "+id+" not found"));
    }
    public void deleteEmployee(Long id){
       employeeRepo.deleteEmployeeById(id);
    }
}
