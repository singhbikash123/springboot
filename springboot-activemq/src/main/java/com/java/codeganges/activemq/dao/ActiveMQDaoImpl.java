package com.java.codeganges.activemq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.codeganges.activemq.rowmapper.EmployeeRowMapper;
import com.java.codeganges.activemq.vo.EmployeeVO;

@Repository
public class ActiveMQDaoImpl implements ActiveMQDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeVO getEmployee(int empID) {
		return jdbcTemplate.queryForObject("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP WHERE EMPNO = ?", new EmployeeRowMapper(), empID);
	}
	
}
