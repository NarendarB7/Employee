package com.naren.employee.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.naren.employee.Entity.Company;
import com.naren.employee.Entity.Employee;
import com.naren.employee.dto.CompanyDto;
import com.naren.employee.dto.EmployeeDetailsDto;
import com.naren.employee.dto.EmployeeDto;

import jakarta.validation.Valid;




public interface IemployeeService {
	void saveEmployee(@Valid EmployeeDto employee);
	//Employee getEmployeeDetails();
	
	void saveCompany(@Valid CompanyDto company);

	EmployeeDto getEmpDetails(@Valid String empId);
	
	
	List<EmployeeDto> getAllEmpDetails(String companyName);

	EmployeeDetailsDto getEmployeeData(String id);
	
	

	Integer generateCompanyCode(Company company2);

	void releseEmployee(String employeeId);
	
}
