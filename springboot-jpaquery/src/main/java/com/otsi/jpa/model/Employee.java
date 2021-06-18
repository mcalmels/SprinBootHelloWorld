package com.otsi.jpa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "employee_tb")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId", nullable = false, unique = true)
	private Long empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "dept_name")
	private String deptName;
	@Column(name = "manager_name")
	private String managerName;
	@Column(name = "joining_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Employee(String empName, String deptName, String managerName, LocalDate joiningDate) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.managerName = managerName;
		this.joiningDate = joiningDate;
	}

}
