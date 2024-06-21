package com.employeecrud.DAO;

import java.util.List;

import com.employeecrud.model.Employee;

public interface EmployeeDAO {

	int save(Employee employee);
	List<Employee> getAll();
	Employee getById(int id);
	int remove(int id);
	int update(int id, Employee employee);
}
