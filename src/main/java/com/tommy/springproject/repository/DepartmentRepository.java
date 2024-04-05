package com.tommy.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommy.springproject.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
