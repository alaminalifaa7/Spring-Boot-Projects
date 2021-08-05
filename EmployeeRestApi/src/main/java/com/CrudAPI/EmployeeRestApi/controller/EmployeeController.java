package com.CrudAPI.EmployeeRestApi.controller;

import com.CrudAPI.EmployeeRestApi.entity.Employee;
import com.CrudAPI.EmployeeRestApi.exception.ResourceNotFoundException;
import com.CrudAPI.EmployeeRestApi.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    //get all employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return this.employeeRepo.findAll();
    }
    //get employee by id
    @GetMapping("/{id}")
    public Employee getUserById(@PathVariable(value = "id") long userId){
        return this.employeeRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id: "+ userId));
    }

    //create an employee
    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeRepo.save(employee);
    }
    //update an employee
    @PutMapping("/{id}")
    public Employee updateUser(@RequestBody Employee employee, @PathVariable("id") long userId){
        Employee exists = this.employeeRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id: "+ userId));
        exists.setFirstName(employee.getFirstName());
        exists.setLastName(employee.getLastName());
        exists.setEmail(employee.getEmail());
        return this.employeeRepo.save(exists);
    }
    //delete employee by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteUser(@PathVariable("id") long userId){
        Employee exists = this.employeeRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id: "+ userId));
        this.employeeRepo.delete(exists);
        return ResponseEntity.ok().build();
    }
}
