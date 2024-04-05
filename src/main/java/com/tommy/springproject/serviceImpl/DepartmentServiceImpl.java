package com.tommy.springproject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommy.springproject.model.Department;
import com.tommy.springproject.repository.DepartmentRepository;
import com.tommy.springproject.service.DepartmentService;
/*
 *    # Steps to Implement modules
 *     pojo class
 *     repository
 *     service
 *     serviceImpl
 *     controller
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository depRepo;

	@Override
	public void addDepartment(Department dept) {
		depRepo.save(dept);
	}

	@Override
	public void deleteDept(int id) {
		depRepo.deleteById(id);
	}

	@Override
	public Department getDeptById(int id) {
		return depRepo.findById(id).get();
	}

	@Override
	public void updateDept(Department dept) {
		depRepo.save(dept);
	}

	@Override
	public List<Department> getAllDepartments() {

		return depRepo.findAll();
	}

}
