package com.winz.demo.service;

import java.util.List;

import com.winz.demo.model.Employee;

public interface IEmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);

}
