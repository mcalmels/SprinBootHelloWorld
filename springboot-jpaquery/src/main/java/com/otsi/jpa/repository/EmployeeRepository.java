package com.otsi.jpa.repository;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.otsi.jpa.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Query("select e from Employee e")
	List<Employee> findEmployeeData();

	// Indexed Query
	@Query("select e from Employee e where e.joiningDate=?1")
	List<Employee> findAllEmployeesByJoiningDateJpa(LocalDate joiningDate);

	@Query("select e from Employee e where e.deptName=?1")
	List<Employee> getDept(String dept);

	@Modifying
	@Query("update Employee e set e.empName=?2,e.deptName=?3,e.managerName=?4 where e.empId=?1")
	@Transactional
	void updateEmployeeDetails(Long empId, String empName, String deptName, String managerName);

	@Modifying
	@Query(value = "insert into employee_tb (emp_name,dept_name,manager_name,joining_date) values (:empName,:deptName,:managerName,:joiningDate)", nativeQuery = true)
	@Transactional
	void insertEmployeeDetails(@Param("empName") String empName, @Param("deptName") String deptName,

			@Param("managerName") String managerName, @Param("joiningDate") LocalDate joiningDate);

	@Modifying
	@Query("delete from Employee e where e.empId = ?1")
	@Transactional
	void deleteEmployee(Long empId);

}
