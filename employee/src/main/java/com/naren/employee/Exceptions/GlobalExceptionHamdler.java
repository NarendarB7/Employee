package com.naren.employee.Exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.naren.employee.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHamdler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmployeeAlreadyExistsExceptionOrCompanyNotExits.class)
	public ResponseEntity<ErrorResponseDto> handleEmployeeAlreadyExistsExceptionOrCompanyNotExits
	(EmployeeAlreadyExistsExceptionOrCompanyNotExits execption, WebRequest webReqst){
		ErrorResponseDto errorResponse = new ErrorResponseDto(
				webReqst.getDescription(false),
				HttpStatus.BAD_REQUEST,
				
				execption.getMessage(),
				LocalDateTime.now()
				);
		return new ResponseEntity<ErrorResponseDto>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> hanleGlobalException
	(Exception execption, WebRequest webReqst){
		ErrorResponseDto errorResponse = new ErrorResponseDto(
				webReqst.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR,
				execption.getMessage(),
				LocalDateTime.now()
				);
		return new ResponseEntity<ErrorResponseDto>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}



	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String,String> validationError 		= new HashMap<>();
		List<ObjectError> validationErrorList 	= ex.getBindingResult().getAllErrors();		
		validationErrorList.forEach( (e) -> {
			String fieldName				=  ((FieldError)e).getField();
			String validationMessage 		=  e.getDefaultMessage();
			validationError.put(fieldName,validationMessage);
			
		});
				
		return new ResponseEntity<>(validationError,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
