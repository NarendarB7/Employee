package com.naren.employee.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
@Schema( name = "Employee Details")
public class EmployeeDetailsDto {
	@NotNull(message="Employee ID can not be null")
	@Schema(description = "Employee Id", example ="2271899")
	private String employeeId;
	@Schema(description = "Name of Employee", example ="Narendar")
	@NotEmpty(message = "name can not be null")
	private String name;
	private String status;
	@Schema(description = "Company Name", example ="TCS")
	private String companyName;
	private String employeeType;
	@Schema(description = "Location of Employee", example ="Hyderabad")
	private String location;
	@Schema(description = "Mobile Number", example ="955902777")
	private String mobileNumber;
	private LocalDate joinDate;
	private LocalDate lastDate;
    private Integer companyCode;
    @Schema(description = "Name of the COuntry", example ="India")
	private String country;

	
	
	public EmployeeDetailsDto(String employeeId, String name, String status, String companyName, String employeeType,
			String location, String mobileNumber, LocalDate joinDate, LocalDate lastDate, Integer companyCode,
			String country) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.status = status;
		this.companyName = companyName;
		this.employeeType = employeeType;
		this.location = location;
		this.mobileNumber = mobileNumber;
		this.joinDate = joinDate;
		this.lastDate = lastDate;
		this.companyCode = companyCode;
		this.country = country;
	}


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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public LocalDate getLastDate() {
		return lastDate;
	}
	public void setLastDate(LocalDate lastDate) {
		this.lastDate = lastDate;
	}
	public Integer getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
