package com.attendancemonitoring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendancemonitoring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public Optional<Employee> findByEmployeeCode(int implCode);
	}
