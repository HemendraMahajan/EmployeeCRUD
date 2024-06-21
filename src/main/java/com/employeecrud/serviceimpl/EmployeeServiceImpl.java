package com.employeecrud.serviceimpl;

import java.util.List;

import com.employeecrud.DAOImpl.EmployeeDAOImpl;
import com.employeecrud.model.Employee;
import com.employeecrud.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAOImpl employeeDAOImpl;
	
	
	
	public EmployeeServiceImpl() {
		
		employeeDAOImpl = new EmployeeDAOImpl();
	}

	@Override
	public Integer save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAOImpl.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeDAOImpl.getAll();
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return employeeDAOImpl.getById(id);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return employeeDAOImpl.remove(id);
	}

	@Override
	public int update(int id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAOImpl.update(id, employee);
	}

}
