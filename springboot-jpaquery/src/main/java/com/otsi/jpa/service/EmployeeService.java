package com.otsi.jpa.service;

import java.time.LocalDate;
import java.util.List;

import com.otsi.jpa.model.Employee;

public interface EmployeeService {

	List<Employee> findEmployeeData();

	List<Employee> findAllEmployeesByJoiningDate(LocalDate joiningDate);

	List<Employee> getDept(String deptName);

	void updateEmolyeeDetails(Long empId, String empName, String deptName, String managerName);

	Employee saveEmolyeeDetails(String empName, String deptName, String managerName, LocalDate joiningDate);

	void insertEmolyeeDetails( String empName, String deptName, String managerName, LocalDate joiningDate);

	void deleteEmployee(Long empId);

}
