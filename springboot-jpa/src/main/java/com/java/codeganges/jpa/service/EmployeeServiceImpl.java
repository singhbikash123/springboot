package com.java.codeganges.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.codeganges.jpa.dao.EmployeeRepository;
import com.java.codeganges.jpa.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployeeList() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee getReferenceById(Long id) {
		return employeeRepository.getReferenceById(id);
	}

	@Override
	public List<Employee> getEmployeeListSortedDescByName() {
		 Sort sort = Sort.by(Sort.Direction.DESC, "name");
		return employeeRepository.findAll(sort);
	}
	
	@Override
	public List<Employee> getEmployeeListSortedAscByName() {
		 Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return employeeRepository.findAll(sort);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public long employeeCount() {
		return employeeRepository.count();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllEmployee() {
		employeeRepository.deleteAll();
	}
	
	@Override
	public void deleteEmployeeEntity(Employee employee) {
		employeeRepository.delete(employee);
	}
	
	@Override
	public void deleteAllEmployeeEntities() {
		employeeRepository.deleteAll(getEmployeeList());
	}
	
	
	@Override
	public List<Employee> findAllEmployeebyIds(List<Long> firstNameIds) {
		return employeeRepository.findAllById(firstNameIds);
	}
	
	@Override
	public void deleteAllEmployeebyIds(List<Long> firstNameIds) {
		 employeeRepository.deleteAllById(firstNameIds);
	}
	
	@Override
	public boolean employeeExistbyId(Long id) {
		 return employeeRepository.existsById(id);
	}

	@Override
	public List<Employee> findEmployeeByName(String name) {
		return employeeRepository.findEmployeeByName(name);
	}

	@Override
	public List<Employee> findEmployeeByNameAndJob(String name, String job) {
		 return employeeRepository.findEmployeeByNameAndJob(name,job);
	}

	@Override
	public List<Employee> findEmployeeByNameAllIgnoreCase(String name) {
		return employeeRepository.findEmployeeByNameAllIgnoreCase(name);
	}

	@Override
	public List<Employee> findByEnameOrderByJobAsc(String name) {
		return employeeRepository.findByNameOrderByJobAsc(name);
	}

	@Override
	public List<Employee> findByJobOrderByNameDesc(String job) {
		return employeeRepository.findByJobOrderByNameDesc(job);
	}

	@Override
	@Transactional(readOnly = true)
	public Stream<Employee> findAllEmployeeByCustomQueryAndStream() {
		return employeeRepository.findAllEmployeeByCustomQueryAndStream();
	}

	@Override
	@Transactional(readOnly=true)
	public Stream<Employee> streamAllPaged(Pageable pageable) {
		return employeeRepository.streamAllPaged(Pageable.unpaged(Sort.unsorted()));
	}

	@Override
	public Integer getEmpCountThroughProcedure() {
		return employeeRepository.getEmpCountThroughProcedure();
	}


	public void updateEnameThroughStoredProc(int empId, String ename) {
		System.out.println("empId:::"+empId +"ename::"+ename);
		 employeeRepository.updateEnameThroughStoredProc(empId, ename);
	}
	

	public void updateEnameThroughProcedureAnnotaion(int empId, String ename) {
		System.out.println("V empId:::"+empId +"ename::"+ename);
		 employeeRepository.updateEnameThroughProcedureAnnotaion(empId, ename);
	}


	
	
}
