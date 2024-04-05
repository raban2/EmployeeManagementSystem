package com.tommy.springproject.service;

import java.util.List;

import com.tommy.springproject.model.Department;

public interface DepartmentService {
	
	void addDepartment(Department dept);

	void deleteDept(int id);

	Department getDeptById(int id);

	void updateDept(Department dept);

	List<Department> getAllDepartments();

}
