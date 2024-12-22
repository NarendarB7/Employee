package com.naren.employee.MapperDto;

import java.time.LocalDate;
import java.util.Optional;

import com.naren.employee.Entity.Company;
import com.naren.employee.Entity.Employee;
import com.naren.employee.dto.CompanyDto;
import com.naren.employee.dto.EmployeeDetailsDto;
import com.naren.employee.dto.EmployeeDto;

public class MapperClass {
//	public  static EmployeeDto empToDto(Employee emp) {
//		
//		EmployeeDto empDto = new EmployeeDto(emp.getEmployeeId(),emp.getCompanyName(),emp.getEmployeeType(),emp.getLocation(),
//				emp.getMobileNumber(),emp.getJoinDate(),emp.getLastDate());
//		return empDto;
//		
//	}
	
public  static Employee empDto_ToEmp(EmployeeDto emp,LocalDate date, String status ) {
	Employee employee =new Employee();
	employee.setName(emp.getName());
	employee.setMobileNumber(emp.getMobileNumber());
	employee.setCompanyName(emp.getCompanyName());
	employee.setEmployeeId(emp.getEmployeeId());
	employee.setEmployeeType(emp.getEmployeeType());	
	employee.setLocation(emp.getLocation());
	employee.setStatus(status);
	employee.setJoinDate(date);
	employee.setSalary(emp.getSalary());	
	return employee;
		
	}
public  static CompanyDto companyToDto(Company com) {
	
	CompanyDto company =new CompanyDto(com.getCompanyCode(),com.getCompanyName(), com.getCountry(),com.getFoundedIn());
	return company;
	
}

public  static Company companyDto_ToCompany(CompanyDto com) {
	
	
	return new Company(com.getCompanyName(), com.getCountry(),com.getFoundedIn());
	
}

public static  EmployeeDetailsDto fullDetailsMapper(Company com,Employee emp) {
	
	return new  EmployeeDetailsDto(emp.getEmployeeId(), emp.getName(),emp.getStatus(),emp.getCompanyName(), emp.getEmployeeType(), emp.getLocation(),
			    emp.getMobileNumber(), emp.getJoinDate(), emp.getLastDate(), com.getCompanyCode(), com.getCountry());
	
}

public static EmployeeDto empToDto(Optional<Employee> emp) {
	
	if(emp.isPresent()) {
		return new EmployeeDto(emp.get().getEmployeeId(),emp.get().getName(),emp.get().getCompanyName(), 
												emp.get().getEmployeeType(), emp.get().getLocation());
	}
	return null;
}
public static EmployeeDto empToDto(Employee emp) {
	
	
		return new EmployeeDto(emp.getEmployeeId(),emp.getName(), emp.getCompanyName(), emp.getEmployeeType(), emp.getLocation());
	
	
}


















}
