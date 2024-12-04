package com.java.codeganges.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.java.codeganges.activemq.dao.ActiveMQDao;
import com.java.codeganges.activemq.vo.EmployeeVO;

import jakarta.jms.Queue;

@Service
public class ActiveMQServiceImpl implements ActiveMQService {

	@Autowired
	private ActiveMQDao activeMQDao;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
    private Queue queue;
	
	@Override
	public EmployeeVO getEmployee(int empID) {
		EmployeeVO employee =  activeMQDao.getEmployee(empID);
		jmsTemplate.convertAndSend(queue,"Reterived employee:"+employee.getEmployeeId());
		return employee;
	}
	
	
	
	

}
