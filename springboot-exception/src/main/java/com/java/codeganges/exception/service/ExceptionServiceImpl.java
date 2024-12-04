package com.java.codeganges.exception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.codeganges.exception.dao.ExceptionDao;
import com.java.codeganges.exception.vo.EmployeeVO;

@Service
public class ExceptionServiceImpl implements ExceptionService {
	
	@Autowired
	private ExceptionDao exceptionDao;

	@Override
	public EmployeeVO getEmployeeVO(int empID) {
		return exceptionDao.getEmployeeVO(empID);
	}

	@Override
	public int employeeCount(int empID) {
		return exceptionDao.employeeCount(empID);
	}

}
