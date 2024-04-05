package com.tommy.springproject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommy.springproject.model.Employee;

import com.tommy.springproject.repository.EmployeeRepository;
import com.tommy.springproject.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void addEmployee(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return empRepo.findById(id).get();
	}

	@Override
	public void updateEmployee(Employee emp) {
		empRepo.save(emp);

	}

	@Override
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);

	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

}
