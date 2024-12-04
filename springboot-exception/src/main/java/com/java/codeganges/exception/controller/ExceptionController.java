package com.java.codeganges.exception.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.codeganges.exception.exception.EmployeeNotFoundException;
import com.java.codeganges.exception.exception.ExceptionModel;
import com.java.codeganges.exception.service.ExceptionService;
import com.java.codeganges.exception.vo.EmployeeVO;

@RestController
public class ExceptionController {

	@Autowired
	private ExceptionService exceptionService;

	@GetMapping(value = "/employee/{empID}")
	public ResponseEntity<EmployeeVO> getEmployeeVO(@PathVariable int empID) {
		int empCount = exceptionService.employeeCount(empID);
		if (empCount == 0) {
			ExceptionModel em = new ExceptionModel();
			em.setError("Employee not found using empID::" + empID);
			em.setStatus("404- Not Found");
			em.setPath("/employee/" + empID);
			em.setTimeStamp(new Timestamp(System.currentTimeMillis()));
			throw new EmployeeNotFoundException(em);
		}
		EmployeeVO employeeVO = exceptionService.getEmployeeVO(empID);

		ResponseEntity<EmployeeVO> re = new ResponseEntity<EmployeeVO>(employeeVO, HttpStatus.OK);
		return re;
	}

}
