package com.tommy.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tommy.springproject.model.Employee;
import com.tommy.springproject.service.DepartmentService;
import com.tommy.springproject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// Module Integration
	@Autowired
	private DepartmentService deptService;

	@GetMapping("/add")
	public String getEmployee(Model model) {
		model.addAttribute("dList", deptService.getAllDepartments());
		return "EmployeeForm";
	}

	@PostMapping("/add")
	public String postEmployee(@ModelAttribute Employee emp) {
		empService.addEmployee(emp);
		return "redirect:/employee/add";

	}
	
	@GetMapping("/list")
	public String EmployeList(Model model) {
		model.addAttribute("empList",empService.getAllEmployees());
		return "EmployeeListForm";
	}
	
	
	@GetMapping("/edit")
	public String editEmployee(@RequestParam Long id, Model model) {
		model.addAttribute("empObj",empService.getEmployeeById(id));
		return "EmployeeEditForm";
	}
	
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Long id) {
		empService.deleteEmployee(id);
		return "redirect:/employee/list";
	}
}
