package com.java.codeganges.jpa.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPT")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Department implements Serializable {

	public Department() {
	}

	private static final long serialVersionUID = 1L;

	//@OneToMany(mappedBy = "department")
	//private List<Employee> employeeList;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPTNO")
	private Long departmentNumber;

	public Long getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Long departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	@Column(name = "DNAME")
	private String departmentName;

	@Column(name = "LOC")
	private String location;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
