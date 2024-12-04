package com.java.codeganges.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;

import com.java.codeganges.jpa.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployeeList();
	
	public Optional<Employee> findById(Long id);
	
	public Employee getReferenceById(Long id);
	
	public List<Employee> getEmployeeListSortedDescByName();
	
	public List<Employee> getEmployeeListSortedAscByName();
	
	public Employee saveEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public long employeeCount();
	
	public void deleteEmployeeById(Long id);
	
	public void deleteAllEmployee();
	
	public void deleteEmployeeEntity(Employee employee);
	
	public void deleteAllEmployeeEntities();
	
	public List<Employee> findAllEmployeebyIds(List<Long> firstNameIds);
	
	public void deleteAllEmployeebyIds(List<Long> firstNameIds);
	
	public boolean employeeExistbyId(Long id);
	
	public List<Employee> findEmployeeByName(String name);

	public List<Employee> findEmployeeByNameAndJob(String name, String job);

	public List<Employee> findEmployeeByNameAllIgnoreCase(String name);

	public List<Employee> findByEnameOrderByJobAsc(String name);

	public List<Employee> findByJobOrderByNameDesc(String job);

	public Stream<Employee> findAllEmployeeByCustomQueryAndStream();
	
	public Stream<Employee> streamAllPaged(Pageable pageable);
	
	public Integer getEmpCountThroughProcedure();
	
	public void updateEnameThroughStoredProc(int empId, String ename);
	
	public void updateEnameThroughProcedureAnnotaion(int empId, String ename);

	
}
