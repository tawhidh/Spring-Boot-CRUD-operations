package com.tawhid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tawhid.demo.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
	
}
