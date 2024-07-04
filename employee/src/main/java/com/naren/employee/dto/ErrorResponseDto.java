package com.naren.employee.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



public class ErrorResponseDto {
	private String apiPath;
	private HttpStatus errorCode;
	private String errorMsg;
	private LocalDateTime errorTime;
	public ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMsg, LocalDateTime errorTime) {
		
		this.apiPath = apiPath;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorTime = errorTime;
	}
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}
	public String getApiPath() {
		return apiPath;
	}
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public LocalDateTime getErrorTime() {
		return errorTime;
	}
	
	
	
}
