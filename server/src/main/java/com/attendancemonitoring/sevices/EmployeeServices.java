package com.attendancemonitoring.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.attendancemonitoring.entity.Employee;

@Repository
public interface EmployeeServices {

	public List<Employee> getAllEmployee();

	public void createEmployee(Employee employee);

	public Optional<Employee> getEmployeeById(int empId);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int empId);

	public int countEmployee();

	public Optional<Employee> getEmployeeByCode(int implCode);

}
