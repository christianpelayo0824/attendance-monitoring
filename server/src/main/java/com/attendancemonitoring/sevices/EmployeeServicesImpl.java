package com.attendancemonitoring.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendancemonitoring.entity.Employee;
import com.attendancemonitoring.repository.EmployeeRepository;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public void createEmployee(Employee employee) {
		empRepo.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(int empId) {
		return empRepo.findById(empId);
	}

	@Override
	public void deleteEmployee(int empId) {
		empRepo.deleteById(empId);
	}

	@Override
	public void updateEmployee(Employee employee) {
		empRepo.save(employee);

	}

	@Override
	public int countEmployee() {
		return (int) empRepo.count();
	}

	@Override
	public Optional<Employee> getEmployeeByCode(int implCode) {
		return empRepo.findByEmployeeCode(implCode);
	}

}
