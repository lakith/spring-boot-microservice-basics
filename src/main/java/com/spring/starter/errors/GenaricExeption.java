package com.spring.starter.errors;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.starter.models.GenaricExeptionModel;

@ControllerAdvice
@RestController
public class GenaricExeption extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleallException(Exception ex, WebRequest request) throws Exception {	
		GenaricExeptionModel exeptionModel =  new GenaricExeptionModel(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exeptionModel,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundExeption.class)
	public final ResponseEntity<Object> userNotFound(Exception ex, WebRequest request) throws Exception {
		
		GenaricExeptionModel exeptionModel =  new GenaricExeptionModel(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exeptionModel,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		GenaricExeptionModel exeptionModel = new GenaricExeptionModel(new Date(),"Validation failed",ex.getBindingResult().toString());
		return new ResponseEntity(exeptionModel,HttpStatus.BAD_REQUEST);
	}	
	
}
