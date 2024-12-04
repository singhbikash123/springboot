package com.java.codeganges.jpa.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.codeganges.jpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Query Creation
	public List<Employee> findEmployeeByName(String name);

	public List<Employee> findEmployeeByNameAndJob(String name, String job);

	public List<Employee> findEmployeeByNameAllIgnoreCase(String name);

	public List<Employee> findByNameOrderByJobAsc(String name);

	public List<Employee> findByJobOrderByNameDesc(String job);

	@Query("select e from Employee e")
	public Stream<Employee> findAllEmployeeByCustomQueryAndStream();

	@Query("select e from Employee e")
	Stream<Employee> streamAllPaged(Pageable pageable);
	
	@Procedure(procedureName = "EMP_COUNT")
	public Integer getEmpCountThroughProcedure();
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "call UPDATE_ENAME(:empId,:ename)")
	public void updateEnameThroughStoredProc(int empId, String ename);
	
	
	@Transactional
	@Modifying
	@Procedure(value = "UPDATE_ENAME")
	public void updateEnameThroughProcedureAnnotaion(int empId, String ename);


}
