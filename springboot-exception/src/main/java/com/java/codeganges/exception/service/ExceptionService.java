package com.java.codeganges.exception.service;

import com.java.codeganges.exception.vo.EmployeeVO;

public interface ExceptionService {
	
	public EmployeeVO getEmployeeVO(int empID);
	
	public int employeeCount(int empID);

}
