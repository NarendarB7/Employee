package com.naren.employee.Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naren.employee.Entity.Company;
import com.naren.employee.Entity.Employee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	 
	/**
	 * 
	 * @param employee
	 */
	default void saveEmployee(Employee employee) {
		Employee emp =save(employee);
		//return emp;
	} 

//	default Employee getByEmployeeDetails(int employeeId) {
//		Employee emp = findByEmployeeId(employeeId);
//		return emp;
//	}

	Optional<Employee> findByEmployeeId(String id);
	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	// List<Employee> findByEmployeeId(int employeeId);
	Employee findByMobileNumber(String mobileNmber);

	ArrayList<Employee> findBycompanyName(String companyName);

	List<Optional<Employee>> findAllBycompanyName(String companyName);

//	default Optional<Employee> findByEmployeeIdPotional(Integer employeeId){
//		Optional<Employee> myEmp =Optional.ofNullable(findByEmployeeId(employeeId));
//		return myEmp;
//	}

	

	


}
