package com.java.codeganges.exception.dao;

import com.java.codeganges.exception.vo.EmployeeVO;

public interface ExceptionDao {

	public EmployeeVO getEmployeeVO(int empID);
	
	public int employeeCount(int empID);
	
}
