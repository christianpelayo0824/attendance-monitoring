package com.attendancemonitoring.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendancemonitoring.entity.Employee;
import com.attendancemonitoring.sevices.EmployeeServices;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EmployeeResources {

	@Autowired
	private EmployeeServices empServices;

	@GetMapping(value = "/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return empServices.getAllEmployee();
	}

	@GetMapping(value = "/getEmployeeById/{empId}")
	public Optional<Employee> getEmployeeBtId(@PathVariable("empId") final int empId) {
		return empServices.getEmployeeById(empId);
	}

	@PostMapping(value = "/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createEmployee(@RequestBody Employee employee) {
		empServices.createEmployee(employee);
	}

	@DeleteMapping(value = "/deleteEmployee/{empId}")
	public boolean deleteEmployee(@PathVariable("empId") final int impId) {
		empServices.deleteEmployee(impId);
		return true;
	}

	@PutMapping(value = "/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@RequestBody Employee employee) {
		empServices.updateEmployee(employee);
	}

	@GetMapping(value = "/countEmployee")
	public int countEmployee() {
		return empServices.countEmployee();
	}

	@GetMapping(value = "/getEmployeeByCode/{emplCode}")
	public Optional<Employee> getEmployeeByCode(@PathVariable("emplCode") final int emplCode) {
		return empServices.getEmployeeByCode(emplCode);
	}

}
