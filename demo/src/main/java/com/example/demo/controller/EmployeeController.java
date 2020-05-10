package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	private EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}

	@GetMapping({"/","/list"})
	public String showList(Model m) {
		// load all employees
		List<EmployeeEntity> emps = empService.findAll();
		m.addAttribute("employees", emps );
		
		
		//for adding employee
		EmployeeEntity newEmp = new EmployeeEntity();
		m.addAttribute("employee", newEmp);
		return "employeelist";
	}

	@PostMapping("/addEmp")
	public String addEmployee(@ModelAttribute("employees") EmployeeEntity emp) {
		System.out.println(" adding data ");
		empService.save(emp);
		return "redirect:list";
	}
	
	@GetMapping("updateEmp")
	public String updateEmployee(@RequestParam("empid") int id, Model m) {
		
		EmployeeEntity emp = empService.findById(id);
		
		m.addAttribute("employee", emp);
		
		return "employeelist";
	}
	
	@GetMapping("deleteEmp")
	public String deleteEmployee(@RequestParam("empid") int id) {
		empService.delete(id);
		return "redirect:list";
	}
}
