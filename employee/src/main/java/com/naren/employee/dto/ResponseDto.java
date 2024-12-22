package com.naren.employee.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema( name = "Response")
@Data 
public class ResponseDto {
	private String statusCode;
	private String statusMessage;
	
	
	public ResponseDto(String statusCode, String statusMessage) {
		
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getStatusMessage() {
		return statusMessage;
	}


	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}


	
	
	
}
