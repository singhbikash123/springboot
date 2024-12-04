package com.java.codeganges.jpa.exception;

public class ExceptionModel {
	
	private String error;
	
	private String status;
	
	private String path;
	
	private String timeStamp;
	
	public ExceptionModel() {}
	
	public ExceptionModel(String error,String status, String path,String timeStamp) {
		this.error = error;
		this.status = status;
		this.path = path;
		this.timeStamp = timeStamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
