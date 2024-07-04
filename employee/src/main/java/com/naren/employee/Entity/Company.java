package com.naren.employee.Entity;


import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name="company")
public class Company {
	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_code")
	private Integer companyCode;
	@Column(name="company_name")
	@NotEmpty(message = "Please mention the company name ")
	private String companyName;
	@NotEmpty(message = "Please mention the Country ")
	private String country;
	private String foundedIn;
	private String percentageProfit;
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
	public String getPercentageProfit() {
		return percentageProfit;
	}
	public void setPercentageProfit(String percentageProfit) {
		this.percentageProfit = percentageProfit;
	}

	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode + ", companyName=" + companyName + ", country=" + country
				+ ", foundedIn=" + foundedIn + ", percentageProfit=" + percentageProfit + "]";
	}

	public Company( String companyName,String country, String foundedIn) {
	
		this.companyName = companyName;
		this.country = country;
		this.foundedIn = foundedIn;
	}

	public Company() {
		
	}
	
	
	
}
