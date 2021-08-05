package com.CrudAPI.EmployeeRestApi.repository;

import com.CrudAPI.EmployeeRestApi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
