package com.naren.employee.Entity;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
//	@Column(name="EMPLOYEE_ID")
	@NotNull(message="Employee ID can not be null")
	@Pattern(regexp = "(^\\d{7}$)", message = "Employee Id  must be 7 digits")
	private String employeeId;
	@NotEmpty(message = "name can not be null")
	private String name;
	
	private String status;
	@NotEmpty(message = "company name can not be null")
	private String companyName;
	@NotEmpty(message = "Company name can not be empty or null")
	private String employeeType;
	@NotEmpty(message = "Please mention the location ")
	private String location;
	@Pattern(regexp = "(^\\d{10}$)", message = "mobile must be 10 digits")
	private String mobileNumber;
//	@JsonFormat(pattern="dd-mm-yyyy")
	private LocalDate joinDate;
	//@JsonFormat(pattern="dd-mm-yyyy")
	private LocalDate lastDate;
	private String salary;
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", companyName=" + companyName + ", employeeType=" + employeeType
				+ ", location=" + location + ", mobileNumber=" + mobileNumber + ", joinDate=" + joinDate + ", lastDate="
				+ lastDate + ", salary=" + salary + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
