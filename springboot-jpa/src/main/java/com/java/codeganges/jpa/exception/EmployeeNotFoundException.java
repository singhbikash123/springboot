package com.java.codeganges.jpa.exception;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExceptionModel em;
	
	public EmployeeNotFoundException(ExceptionModel em) {
		this.setEm(em);
		
	}

	/**
	 * @return the em
	 */
	public ExceptionModel getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(ExceptionModel em) {
		this.em = em;
	}

}
