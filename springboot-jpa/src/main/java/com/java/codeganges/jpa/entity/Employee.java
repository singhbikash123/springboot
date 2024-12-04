package com.java.codeganges.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMP")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@NamedStoredProcedureQuery(name = "User.plus1", procedureName = "EMP_COUNT", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Integer.class) })

public class Employee implements Serializable {
	
	public Employee() {
	}
    
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE , generator = "EMP_SEQ")
	@SequenceGenerator(name="EMP_SEQ", sequenceName="EMP_SEQ",allocationSize=1)
	@Column(name = "EMPNO")
	private Long employeeId;

	@Column(name = "ENAME")
	private String name;

	@Column(name = "JOB")
	private String job;

	@Column(name = "MGR")
	private Long managerId;

	@Column(name = "HIREDATE")
	private LocalDate hireDate;

	@Column(name = "SAL")
	private Double salary;

	@Column(name = "COMM", nullable =true  )
	private Double commission;

	@ManyToOne
    @JoinColumn(name = "DEPTNO")
    private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}


}
