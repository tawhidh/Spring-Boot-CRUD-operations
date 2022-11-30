package com.tawhid.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tawhid.demo.entity.Employee;
import com.tawhid.demo.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp = service.getAllEmp();
		m.addAttribute("emp", emp);
		return "index";
	}
	
	@GetMapping("/addEmp")
	public String addEmp() {
		return "addEmp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee added successfully!");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	@PostMapping("/update")
	public String empUpdate(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee updated successfully!");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		service.deleteEmpById(id);
		session.setAttribute("msg", "Employee deleted successfully!");
		return "redirect:/";
	}
}
