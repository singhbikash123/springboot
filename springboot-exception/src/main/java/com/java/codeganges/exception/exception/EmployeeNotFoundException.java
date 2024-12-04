package com.java.codeganges.exception.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ExceptionModel exceptionModel;

	public ExceptionModel getExceptionModel() {
		return exceptionModel;
	}

	public void setExceptionModel(ExceptionModel exceptionModel) {
		this.exceptionModel = exceptionModel;
	}

	public EmployeeNotFoundException(ExceptionModel exceptionModel) {
		this.exceptionModel = exceptionModel;
	}
	
	
	


	
}
