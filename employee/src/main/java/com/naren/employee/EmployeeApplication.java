package com.naren.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;


/**
 * 
 * @author Narendar
 *	@Date = 05/24
 */
@SpringBootApplication
@OpenAPIDefinition(
		info =@Info(
				title 		="Employee Service REST API Documentation",
				description ="Employee Information REST Service",
				version		="v1",
				contact 	=@Contact(
					  name  ="Narendar B",
					  email ="narendar_7@gmail.com"
					  )
				)
		
		)
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
