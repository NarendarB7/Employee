package com.naren.employee.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.naren.employee.Entity.Company;
import com.naren.employee.Entity.Employee;
import com.naren.employee.Service.IemployeeService;
import com.naren.employee.constants.Econstants;
import com.naren.employee.dto.CompanyDto;
import com.naren.employee.dto.EmployeeDetailsDto;
import com.naren.employee.dto.EmployeeDto;
import com.naren.employee.dto.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
@Tag(
		name		="CRUD REST API for Employee Service",
		description ="CRUD REST APIs to CREATE ,UPDATE and FETCH employee details")
@RestController
@RequestMapping(path="/nari")
@Validated
public class EmpRestContoller {
	
	private final IemployeeService employeeService;
	
	public EmpRestContoller(IemployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@Operation(
			summary		= "Create Employee REST API",
			description	= "REST API to Create an Employee in a Company")
	@ApiResponse(
		   responseCode = "201",
		   description	= "HTTP Status EMployee Created")
	@PostMapping(value="/createEmp", produces="application/json")
	public ResponseEntity<ResponseDto> creatEmployee(@Valid @RequestBody EmployeeDto employee){
		
		employeeService.saveEmployee(employee);
		ResponseDto rsp= new ResponseDto(Econstants.CREATED_CODE,Econstants.CREATED_MSG);
		 
		return  ResponseEntity
				.status(HttpStatus.CREATED)
				.body(rsp);
//				<ResponseDto>
//		(new ResponseDto("201","Created an Employee"), HttpStatus.CREATED);
	}
	

	@Operation(
			summary		= "Get Employee REST API",
			description	= "Fetching  Employee in a Company by Employee Id")
	@ApiResponse(
		   responseCode = "200",
		   description	= "HTTP Status OK")	
	@GetMapping("/getEmp/{EmpId}")
	public ResponseEntity <EmployeeDto> getEmployee (@Valid @PathVariable String EmpId) {
		EmployeeDto empDto = employeeService.getEmpDetails(EmpId);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(empDto);
	}
	
	@Operation(
			summary		= "Create Company REST API",
			description	= "REST API to Create a Compnay ")
	@ApiResponse(
		   responseCode = "201",
		   description	= "HTTP Status Employee Created")
	@PostMapping(value="/createCompany", produces="application/json")
	public ResponseEntity<ResponseDto> createCompany(@Valid @RequestBody CompanyDto company){
			
			employeeService.saveCompany(company);
			return  ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new ResponseDto(Econstants.CREATED_CODE,Econstants.CREATED_MSG));
	}
	
	
	@Operation(
			summary		= "Get Employees REST API",
			description	= "Fetching List Employees in a Company")
	@ApiResponse(
		   responseCode = "200",
		   description	= "HTTP Status OK")	
	@GetMapping("/getAllEmp/{companyName}")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(@PathVariable String companyName) {
		
		List<EmployeeDto> empDto = employeeService.getAllEmpDetails(companyName);
		return ResponseEntity
							.status(HttpStatus.OK)
							.body(empDto);
	}
	
	@Operation(
			summary		= "Get Employee REST API",
			description	= "Fetching  Employee full deails in a Company by Employee Id")
	@ApiResponse(
		   responseCode = "200",
		   description	= "HTTP Status OK")	
	@GetMapping("/getEmpData/{employeeId}")
	public ResponseEntity<EmployeeDetailsDto> getEmployeData (@Pattern(regexp =  "(^\\d{7}$)", message = "mobile must be 7 digits") @PathVariable String employeeId){
		
		EmployeeDetailsDto employeeDetailsDto      =   employeeService.getEmployeeData(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(employeeDetailsDto);
		
	}
	
	@Operation(
			summary		= "Update Employee Status REST API",
			description	= "Releasing  Employee in a Company by Updating the Archived Status")
	@ApiResponse(
		   responseCode = "200",
		   description	= "HTTP Status OK")	
	
	@PutMapping("/releaseEmployee/{employeeId}")
	public ResponseEntity<ResponseDto> releaseEmployee (@PathVariable String employeeId){
			
			employeeService.releseEmployee(employeeId);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(Econstants.OK_CODE200, Econstants.RELEASE_EMP));
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
