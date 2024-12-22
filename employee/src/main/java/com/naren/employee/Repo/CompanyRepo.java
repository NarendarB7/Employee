package com.naren.employee.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naren.employee.Entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

	default void saveCompany(Company company) {
		save(company);
	}

	Optional<Company> findByCompanyName(String trim);
	
	@Query("SELECT MAX(c.companyCode) from Company c")
	Integer findLastCompanyCode();

}
