package com.devsuperior.dscatalog.resources.exceptions;


import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dscatalog.services.execptions.DatabaseExceptions;
import com.devsuperior.dscatalog.services.execptions.ResourcesNotFoundExceptions;



@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	@ExceptionHandler(ResourcesNotFoundExceptions.class)
	public ResponseEntity<StandardError> entityNotFound(ResourcesNotFoundExceptions e, HttpServletRequest request){
	 HttpStatus status = HttpStatus.NOT_FOUND;
	 StandardError err = new StandardError();
	 err.setTimestamp(Instant.now());
	 err.setStatus(status.value());
	 err.setErros("Resource not found");
	 err.setMessage(e.getMessage());
	 err.setPath(request.getRequestURI());
	 return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(DatabaseExceptions.class)
	public ResponseEntity<StandardError> database(ResourcesNotFoundExceptions e, HttpServletRequest request){
	HttpStatus status = HttpStatus.BAD_REQUEST;
	 StandardError err = new StandardError();
	 err.setTimestamp(Instant.now());
	 err.setStatus(status.value());
	 err.setErros("Database exception");
	 err.setMessage(e.getMessage());
	 err.setPath(request.getRequestURI());
	 return ResponseEntity.status(status).body(err);
		
	}
	
	}


