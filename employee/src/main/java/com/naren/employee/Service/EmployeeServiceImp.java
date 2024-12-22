package com.naren.employee.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.naren.employee.Entity.Company;
import com.naren.employee.Entity.Employee;
import com.naren.employee.Exceptions.EmployeeAlreadyExistsExceptionOrCompanyNotExits;
import com.naren.employee.MapperDto.MapperClass;
import com.naren.employee.Repo.CompanyRepo;
import com.naren.employee.Repo.EmployeeRepo;
import com.naren.employee.constants.Econstants;
import com.naren.employee.dto.CompanyDto;
import com.naren.employee.dto.EmployeeDetailsDto;
import com.naren.employee.dto.EmployeeDto;

import lombok.AllArgsConstructor;
@Service 
public class EmployeeServiceImp implements IemployeeService {
	
	
	private EmployeeRepo employeeRepo;
	private CompanyRepo CompanyRepo;
	public EmployeeServiceImp(EmployeeRepo employeeRepo,CompanyRepo CompanyRepo) {
		this.employeeRepo=employeeRepo;
		this.CompanyRepo=CompanyRepo;
	}
	
	public void saveEmployee(EmployeeDto employee) {
		// TODO Auto-generated method stub
		Optional<Employee>   emp         		= employeeRepo.findByEmployeeId(employee.getEmployeeId());
		//List<Employee>   emp         		= employeeRepo.findByEmployeeId(employee.getEmployeeId());
		Optional<Company> companyFound          = CompanyRepo.findByCompanyName(employee.getCompanyName().trim());
		
		if(emp.isPresent() ) {
			 throw new EmployeeAlreadyExistsExceptionOrCompanyNotExits("Employee is already exists with given Employee Id");
		 }
//		 if(!emp.isEmpty() ) {
//			 throw new com.naren.employee.Exceptions.EmployeeAlreadyExistsExceptionOrCompanyNotExits("Employee is already exists with given Employee Id ");
//		 }
		 if( companyFound.isEmpty()) {
			 throw new EmployeeAlreadyExistsExceptionOrCompanyNotExits("Company Does not Exists with given Company Name");

		 }
		 Employee  emp1  = MapperClass.empDto_ToEmp(employee,LocalDate.now(),Econstants.ACTIVE);
				   
		 employeeRepo.save( emp1);
		//return emp;
	}
	private  int generateCustomId() {
		Random random = new Random();
		
		return 7000+random.nextInt(1000);
	}
	@Override
	public void saveCompany(CompanyDto companyDto) {
		Optional<Company> companyFound          = CompanyRepo.findByCompanyName(companyDto.getCompanyName().trim());
		if(companyFound.isPresent()) {
			 throw new EmployeeAlreadyExistsExceptionOrCompanyNotExits("Company Already Exists Can not create another company ");

		}
		Company  company  = MapperClass.companyDto_ToCompany(companyDto);
		Integer myCompany =generateCompanyCode(company);
		company.setCompanyCode(myCompany);
		System.out.println(company);
		CompanyRepo.saveCompany(company);
		
	}
	@Override
	public EmployeeDto getEmpDetails(String id) {
		
		
		Optional<Employee> emp =employeeRepo.findByEmployeeId(id);
		if(!emp.isPresent()) {
			throw new com.naren.employee.Exceptions.EmployeeAlreadyExistsExceptionOrCompanyNotExits("Employee Not Found");
		}
		
		EmployeeDto empDto = MapperClass.empToDto(emp);
		
		return empDto;
	}

	@Override
	public List<EmployeeDto> getAllEmpDetails(String companyName) {
		
		
		List<EmployeeDto> allEmplyeeDetails = new ArrayList<EmployeeDto>();
		List<Optional<Employee>> emp =employeeRepo.findAllBycompanyName(companyName);
		
//		List<Employee> employee = emp.stream().toList();
//		Optional<Employee> myEmployee = employee.get();
		//EmployeeDto empDto = MapperClass.empToDto(employee);
		if(!emp.isEmpty()) {
			for (Optional<Employee> employee : emp) {
				employee.ifPresent(e ->{
					EmployeeDto empDto = MapperClass.empToDto(e);
					allEmplyeeDetails.add(empDto);
				});
				
				
			}
		}else {
			throw new EmployeeAlreadyExistsExceptionOrCompanyNotExits("No Employee Found in the Company "+companyName);
		}
		
		
		return allEmplyeeDetails;
	}

	@Override
	public EmployeeDetailsDto getEmployeeData(String id) {
		
		Optional<Employee> employee 			= employeeRepo.findByEmployeeId(id);
		if(!employee.isPresent()) {
			throw new EmployeeAlreadyExistsExceptionOrCompanyNotExits("No Employee Found with the given Employee Id : "+id);
		}
		Optional<Company> comapny  				= CompanyRepo.findByCompanyName(employee.get().getCompanyName());
		EmployeeDetailsDto employeeDetailsDto   = MapperClass.fullDetailsMapper(comapny.get(),employee.get());
		System.out.println("employeeDetailsDto "+ employeeDetailsDto);
		return employeeDetailsDto;
	}

	@Override
	public Integer generateCompanyCode(Company company2) {
		
		Company company = new Company();
		final Integer customerStartCode = 9000;
		final int IncrmentValue         =1;
		//Company company       = new Company();
		Integer copmpanyCode  = CompanyRepo.findLastCompanyCode();
		if(copmpanyCode == null || copmpanyCode <customerStartCode  ) {
			company.setCompanyCode(customerStartCode);
			return customerStartCode;
			
		}else {
			company.setCompanyCode(copmpanyCode +IncrmentValue);
			return copmpanyCode +IncrmentValue;
		
		}
	}

	@Override
	public void releseEmployee(String employeeId) {
		
		Optional<Employee> employee 			= employeeRepo.findByEmployeeId(employeeId);
		if(!employee.isPresent()) {
			throw new EmployeeAlreadyExistsExceptionOrCompanyNotExits("No Employee Found with the given Employee Id : "+employeeId);
		}
		employee.get().setLastDate(LocalDate.now());
		employee.get().setStatus(Econstants.ARCHIVED);
		employeeRepo.save(employee.get());
		
	}

	
	

	
	
	

	
//	public Employee getEmployeeDetails() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
