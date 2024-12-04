package com.java.codeganges.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.codeganges.activemq.service.ActiveMQService;
import com.java.codeganges.activemq.vo.EmployeeVO;

@RestController
public class ActiveMQController {
	
	@Autowired
	private ActiveMQService activeMQService;
	
	@GetMapping(value = "emplyoee/{empID}")
	public EmployeeVO getEmployee(@PathVariable int empID) {
		return activeMQService.getEmployee(empID);
	}


}
