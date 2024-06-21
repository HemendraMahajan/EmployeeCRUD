package com.employeecrud.service;

import java.util.List;

import com.employeecrud.model.Employee;

public interface EmployeeService {

	Integer save(Employee employee);
	List<Employee> getAll();
	Employee getById(int id);
	int remove(int id);
	int update(int id, Employee employee);
}
