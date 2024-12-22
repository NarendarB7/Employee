package com.naren.employee.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Schema( name = "Company")
@Data
public class CompanyDto {
	@JsonIgnore
	private Integer companyCode;
	
	@NotEmpty(message = "Company Name can not be empty ")
	@Schema(description = "Company Name", example ="TCS")
	private String companyName;
	
	@NotEmpty(message = "Please mention the Country ")
    @Schema(description = "Name of the COuntry", example ="India")
	private String country;
    @Schema(description = "Establed Date", example ="15-07-1947")
	private String foundedIn;
	public Integer getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getFoundedIn() {
		return foundedIn;
	}
	public void setFoundedIn(String foundedIn) {
		this.foundedIn = foundedIn;
	}
	public CompanyDto(Integer companyCode, String companyName, String country, String foundedIn) {
		
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.country = country;
		this.foundedIn = foundedIn;
	}
	
	
}
