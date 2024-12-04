package com.java.codeganges.jpa.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.java.codeganges.jpa.entity.Employee;
import com.java.codeganges.jpa.exception.EmployeeNotFoundException;
import com.java.codeganges.jpa.exception.ExceptionModel;
import com.java.codeganges.jpa.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employeelist")
	public List<Employee> getEmployeeList() {
		return (List<Employee>) employeeService.getEmployeeList();
	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> findById(@PathVariable("id") Long id,HttpServletRequest request) {
		Optional<Employee> employees =  employeeService.findById(id);
		if(employees.isEmpty()) {
			throw new EmployeeNotFoundException(new ExceptionModel("Employee id = " + id + " not found in database","Not Found", request.getRequestURL().toString(), getTimeStampString()));
		}
		return employees;

	}
	
	private String getTimeStampString() {
	// Get the current date and time
	LocalDateTime now = LocalDateTime.now();

	// Define the format
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	// Format the current date and time
	String formattedNow = now.format(formatter);

	// Print the formatted date and time
	System.out.println("Current Timestamp:" + formattedNow);
	
	return formattedNow;
	
}

	@GetMapping("/employeeref/{id}")
	@JsonDeserialize
	public Employee getReferenceById(@PathVariable("id") Long id) {
		return employeeService.getReferenceById(id);
	}

	@GetMapping("/employeelistsortdesbyname")
	public List<Employee> getEmployeeListSortedDescByName() {
		return this.employeeService.getEmployeeListSortedDescByName();
	}

	@GetMapping("/employeelistsortascbyname")
	public List<Employee> getEmployeeListSortedAscByName() {
		return this.employeeService.getEmployeeListSortedAscByName();
	}

	@GetMapping("/employee/count")
	public long employeeCount() {
		return this.employeeService.employeeCount();
	}

	@GetMapping(value = "/employeebyids")
	public List<Employee> findAllEmployeeByIds(@RequestParam List<Long> firstNameIds) {
		System.out.println("firstNameIds:::" + firstNameIds);
		return employeeService.findAllEmployeebyIds(firstNameIds);
	}

	@GetMapping(value = "/employeeexistsby/{id}")
	public boolean employeeExistbyId(@PathVariable("id") Long id) {
		return employeeService.employeeExistbyId(id);
	}

	@GetMapping(value = "/findEmployeeByName")
	public List<Employee> findEmployeeByName(@RequestParam String name) {
		return employeeService.findEmployeeByName(name);
	}

	@GetMapping(value = "/findEmployeeByNameAndJob")
	public List<Employee> findEmployeeByNameAndJob(@RequestParam String name, @RequestParam String job) {
		return employeeService.findEmployeeByNameAndJob(name, job);
	}

	@GetMapping(value = "/findEmployeeByNameAllIgnoreCase")
	public List<Employee> findEmployeeByNameAllIgnoreCase(@RequestParam String name) {
		return employeeService.findEmployeeByNameAllIgnoreCase(name);
	}

	@GetMapping(value = "/findByEnameOrderByJobAsc")
	public List<Employee> findByEnameOrderByJobAsc(@RequestParam String name ){
		return employeeService.findByEnameOrderByJobAsc(name);
	}

	@GetMapping(value = "/findEmployeeByNameDesc")
	public List<Employee> findByJobOrderByNameDesc(@RequestParam String job) {
		return employeeService.findByJobOrderByNameDesc(job);
	}
	
	@GetMapping(value = "/findAllEmployeeByCustomQueryAndStream")
	public List<Employee> findAllEmployeeByCustomQueryAndStream() {
		return employeeService.findAllEmployeeByCustomQueryAndStream().collect(Collectors.toList());
	}
	@GetMapping(value = "/streamAllPaged")
	public Stream<Employee> streamAllPaged(Pageable pageable){
		return employeeService.streamAllPaged(pageable);
		
	}
	@GetMapping(value = "/empCountViaProc")
	public Integer getEmpCountThroughProcedure(){
		return employeeService.getEmpCountThroughProcedure();
		
	}
	
	@PostMapping(value = "/employee/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}
	
	@PostMapping(value = "/employee/updateEnameThroughStoredProc/{empId}/{ename}")
	public void updateEnameThroughStoredProc(@PathVariable("empId") int empId, @PathVariable("ename") String ename ) {
		 employeeService.updateEnameThroughStoredProc(empId, ename);
	}
	
	@PostMapping(value = "/employee/updateEnameThroughProcedureAnnotaion/{empId}/{ename}")
	public void updateEnameThroughProcedureAnnotaion(@PathVariable("empId") int empId, @PathVariable("ename") String ename ) {
		 employeeService.updateEnameThroughProcedureAnnotaion(empId, ename);
	}

	@PutMapping(value = "/employee/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@DeleteMapping(value = "/employee/delete/{id}")
	public void deleteEmployeeById(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeById(id);

	}

	@DeleteMapping(value = "/employee/delete/all")
	public void deleteAllEmployee() {
		employeeService.deleteAllEmployee();
	}

	@DeleteMapping(value = "/employee/delete")
	public void deleteEmployeeEntity(@RequestBody Employee employee) {
		employeeService.deleteEmployeeEntity(employee);
	}

	@DeleteMapping(value = "/employee/delete/entities")
	public void deleteAllEmployeeEntities() {
		employeeService.deleteAllEmployee();
	}

	@DeleteMapping(value = "/employee/deletebyids")
	public void deleteAllEmployeeByIds(@RequestParam List<Long> employeeIds) {
		employeeService.deleteAllEmployeebyIds(employeeIds);
	}

}
