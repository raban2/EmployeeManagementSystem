package com.tommy.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tommy.springproject.model.Department;
import com.tommy.springproject.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	//GetMapping to get the Form
	@GetMapping("/add")
	public String getDepartment() {
		return "DepartmentForm";
	}
	
	
	
	//Post Mapping to Insert Into Database
	@PostMapping("/add")
	public String postDepartment(@ModelAttribute Department dept) {
		deptService.addDepartment(dept);
		return "DepartmentForm";
	}
	
	
	//Getting all the Department
	@GetMapping("/list")
	public String getAll(Model model) {
		model.addAttribute("dList", deptService .getAllDepartments());
		return "DepartmentListForm";
	}
	
	
	@GetMapping("/delete")
	public String deleteDepartment(@RequestParam int id) {    // http://localhost:8080/department/edit?id=2   xa vane @Requestparam garera id ko value catch garne
		deptService.deleteDept(id);                           // if http://localhost:8080/department/edit/id/2  xa vane path varaiale use garne
		return "redirect:/department/list";
		
	}
	
	@GetMapping("/edit")
	public String getEdit(@RequestParam int id, Model model) {    //here "http://localhost:8080/department/edit?id=2" @RequesetParam is used to capture id from the url
		model.addAttribute("dModel",deptService.getDeptById(id));
		return "DepartmentEditForm";
	}
	
	@PostMapping("/update")
	public String postEdit(@ModelAttribute Department dept) {
		deptService.updateDept(dept);
		return "redirect:/department/list";
	}

}
