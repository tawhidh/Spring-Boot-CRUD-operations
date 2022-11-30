package com.tawhid.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawhid.demo.entity.Employee;
import com.tawhid.demo.repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	EmpRepo repo;

	public void addEmp(Employee e) {
		repo.save(e);
	}
	public List<Employee> getAllEmp() {
		return repo.findAll();
	}
	public Employee getEmpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) return e.get();
		else return null;
	}
	public void deleteEmpById(int id) {
		repo.deleteById(id);
	}
}
