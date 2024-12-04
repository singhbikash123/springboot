package com.java.codeganges.exception.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.codeganges.exception.rowmapper.EmployeeRowMapper;
import com.java.codeganges.exception.vo.EmployeeVO;

@Repository
public class ExceptionDaoImpl implements ExceptionDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeVO getEmployeeVO(int empID) {
		return jdbcTemplate.queryForObject("SELECT * FROM EMP WHERE EMPNO=?", new EmployeeRowMapper(), empID);
	}

	@Override
	public int employeeCount(int empID) {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMP WHERE EMPNO =?", Integer.class, empID);
	}
	
	

}
