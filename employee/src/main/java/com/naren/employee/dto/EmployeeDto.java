package com.naren.employee.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Schema( name = "Employee")
@Data
public class EmployeeDto {
	@NotNull(message="Employee ID can not be null")
	@Pattern(regexp = "(^\\d{7}$)", message = "mobile must be 10 digits")
	@Schema(description = "Employee Id", example ="2271899")
	private String employeeId;
	
	@NotEmpty(message="Employee name can not be null")
	@Schema(description = "Name of Employee", example ="Narendar")
	private String name;
		
	@NotEmpty(message="Company name can not be null")
	@Schema(description = "Company Name", example ="TCS")
	private String companyName;
	
	@NotEmpty(message = "salary can not be empty")
	private String salary;
	
	@NotEmpty(message = "Employee type can not be empty or null")	
	@Schema(description = "Employee Type", example ="Full Time")
	private String employeeType;
	
	@Schema(description = "Location of Employee", example ="Hyderabad")
	@NotEmpty(message = "Please mention the location ")
	private String location;
	
	@Schema(description = "Mobile Number", example ="955902777")
	@Pattern(regexp = "(^\\d{10}$)", message = "mobile number must be 10 digits")
	private String mobileNumber;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public EmployeeDto(String employeeId, String name,  String companyName, String employeeType,
			String location) {
		super();
		this.employeeId = employeeId;
		this.name = name;		
		this.companyName = companyName;
		this.employeeType = employeeType;
		this.location = location;
		
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	
	
}
