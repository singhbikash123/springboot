package com.java.codeganges.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionController {
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	   public ResponseEntity<Object> exception(EmployeeNotFoundException exception) {
	      return new ResponseEntity<>(exception.getEm(), HttpStatus.NOT_FOUND);
	   }
}
