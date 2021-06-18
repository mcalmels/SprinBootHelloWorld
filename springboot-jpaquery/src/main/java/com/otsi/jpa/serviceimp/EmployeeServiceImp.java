package com.otsi.jpa.serviceimp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otsi.jpa.model.Employee;
import com.otsi.jpa.repository.EmployeeRepository;
import com.otsi.jpa.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findEmployeeData() {
		return employeeRepository.findEmployeeData();
	}

	@Override
	public List<Employee> findAllEmployeesByJoiningDate(LocalDate joiningDate) {
		return employeeRepository.findAllEmployeesByJoiningDateJpa(joiningDate);
	}

	@Override
	public List<Employee> getDept(String deptName) {
		return employeeRepository.getDept(deptName);
	}

	@Override
	public Employee saveEmolyeeDetails(String empName, String deptName, String managerName, LocalDate joiningDate) {
		Employee employee = new Employee(empName, deptName, managerName, joiningDate);
		employee.setEmpName(empName);
		employee.setDeptName(deptName);
		employee.setManagerName(managerName);
		employee.setJoiningDate(joiningDate);
		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmolyeeDetails(Long empId, String empName, String deptName, String managerName) {
		employeeRepository.updateEmployeeDetails(empId, empName, deptName, managerName);

	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteEmployee(empId);
	}

	@Override
	public void insertEmolyeeDetails( String empName, String deptName, String managerName,
			LocalDate joiningDate) {
		employeeRepository.insertEmployeeDetails( empName, deptName, managerName, joiningDate);
	}

}
