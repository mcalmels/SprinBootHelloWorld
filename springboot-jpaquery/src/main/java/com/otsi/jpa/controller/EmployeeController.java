package com.otsi.jpa.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.otsi.jpa.model.Employee;
import com.otsi.jpa.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public List<Employee> getEmployee(Employee emp) {
		return employeeService.findEmployeeData();
	}

	@GetMapping("/getAllEmployeesByJoiningDate")
	public List<Employee> getAllEmployeesByJoiningDate(
			@RequestParam("joiningDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate joiningDate) {
		return employeeService.findAllEmployeesByJoiningDate(joiningDate);
	}

	@GetMapping("/getDept")
	public List<Employee> getDept(@RequestParam("deptName") String deptName) {
		return employeeService.getDept(deptName);
	}

	@PutMapping("/updateEmployee")
	public String updateEmolyeeDetails(@RequestParam Long empId,@RequestBody Employee emp) {
		employeeService.updateEmolyeeDetails(empId, emp.getEmpName(), emp.getDeptName(), emp.getManagerName());
		return "Updated SuccessFully";
	}

	@PostMapping("/saveEmployeesDetails")
	public Employee saveEmployeeDetails(@RequestBody Employee emp) {
		return employeeService.saveEmolyeeDetails(emp.getEmpName(), emp.getDeptName(), emp.getManagerName(),
				emp.getJoiningDate());
	}

	@DeleteMapping
	public String deleteEmployee(@RequestParam Long empId) {
		employeeService.deleteEmployee(empId);
		return "Delete Employee Data success fully";
	}

	@PostMapping("/insertEmployeesDetails/{empName}/{deptName}/{managerName}/{joiningDate}")
	public String postEmployeeDetails(@PathVariable String empName, @PathVariable String deptName,
			@PathVariable String managerName,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate joiningDate) {
		employeeService.insertEmolyeeDetails(empName, deptName, managerName, joiningDate);
		return "Inserted Successfully";
	}

}
//@RequestParam("empName") String empName, @RequestParam("dept") String dept,@RequestParam("managerName") String managerName,@RequestParam("joiningDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate joiningDate