package com.tommy.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommy.springproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
