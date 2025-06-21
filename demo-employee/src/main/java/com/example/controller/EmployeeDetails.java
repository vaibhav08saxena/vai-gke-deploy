package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/employee")
public class EmployeeDetails {

	@GetMapping("/details")
	public String getEmployeeDetails() {
		return "Employee details will be displayed here.";
	}
	
	@GetMapping("/details/{id}")
	public String getEmployeeById(int id) {
		return "Details of employee with ID: " + id;
	}
	
	@GetMapping("/all")
	public String getAllEmployees() {
		return "List of all employees will be displayed here.";
	}

	@PostMapping("/add")
	public String addEmployee(String employee) {
		return "Employee " + employee + " has been added successfully.";
	}

	@PutMapping("/update/{id}")
	public String updateEmployee(int id, String employee) {
		return "Employee with ID: " + id + " has been updated to " + employee + ".";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(int id) {
		return "Employee with ID: " + id + " has been deleted successfully.";
	}
	
	@GetMapping("/department/{department}")
	public String getEmployeeByDepartment(String department) {
		return "Details of employees in department: " + department;
	}

	@GetMapping("/role/{role}")
	public String getEmployeeByRole(String role) {
		return "Details of employees with role: " + role;
	}

	@LoadBalanced
	@GetMapping("/salary/{percent}/{department}/{role}")
	public String getEmployeeSalaryPercent(@PathVariable Double percent,@PathVariable String department, @PathVariable String role) {
				WebClient client = WebClient.create("http://demo-api-gateway:8770/demo-salary"); 
			/* demo-api-gateway:8770 is used instead of localhost to allow for load balancing. Also this is the api-gateway docker compose created container instance name used in docker-compose.yml file.
			 * Container name is used instead of localhost because the application is running in a Docker container where localhost if used in code will refer to its own container's localhost, 
			 * this means that every microservice is created in a separate container instance independent of other microservices, so each of the containers would have their own localhost in their environment.
			 * so to send request out of their env as in this case we need to refer to the api-gateway's container name as in docker-compose.yml file instead of localhost.
			 * hence demo-api-gateway:8770 is used to refer to the api-gateway container instance.
             * This is a RESTful endpoint that retrieves employees in a specific department with a specific role whose salary is greater than a certain percentage of the average salary.
             * this is 1 test done which worked fine - http://localhost:8770/demo-employee/employee/salary/37/accounts/officers is called from browser or Postman to get the response. 
			 */
		client.get().uri("/salary/salary/{percent}/{department}/{role}", percent, department, role).retrieve()
				.bodyToMono(Double.class).subscribe(response -> System.out.println("Response: " + response));
		
		return "Employees in department: " + department + " with role: " + role + " having salary greater than " + percent + "% of average salary.";
	}
	
    
}
