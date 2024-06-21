package com.employeecrud.DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.employeecrud.DAO.EmployeeDAO;
import com.employeecrud.model.Employee;
import com.employeecrud.util.SqlUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int save(Employee employee) {
		int result = -1;
		try {
			SqlUtil.connectDB();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?)");
			SqlUtil.stmt.setInt(1, employee.getId());
			SqlUtil.stmt.setString(2, employee.getName());
			SqlUtil.stmt.setString(3, employee.getPassword());
			SqlUtil.stmt.setString(4, employee.getEmail());
			SqlUtil.stmt.setString(5, employee.getCountry());
			//SqlUtil.stmt.setString(6, employee.getGender());
			result = SqlUtil.insert();
			SqlUtil.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return result;
	}

	
	@Override
	public List<Employee> getAll() {
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			SqlUtil.connectDB();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = SqlUtil.fetch();
			if(rs!=null) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String email = rs.getString("email");
					String country = rs.getString("country");
				
					Employee employee =  new Employee(id, name, password, email, country);
					empList.add(employee);
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public Employee getById(int id) {
		
		Employee emp = null;
		try {
			SqlUtil.connectDB();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("SELECT * FROM employee WHERE id=?");
			SqlUtil.stmt.setInt(1,id);
			ResultSet rs = SqlUtil.fetch();
			if(rs!=null) {
				if(rs.next()) {
					emp = new Employee();
				    emp.setId(rs.getInt("id"));
				    emp.setName(rs.getString("name"));
				    emp.setPassword(rs.getString("password"));
				    emp.setEmail(rs.getString("email"));
				    emp.setCountry(rs.getString("country"));
				    //emp.setGender(rs.getString("gender"));
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			SqlUtil.connectDB();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("delete from employee where id =?");
		    SqlUtil.stmt.setInt(1, id);
		    result = SqlUtil.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(int id, Employee employee) {
		int result = -1;
		try {
			SqlUtil.connectDB();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("UPDATE employee SET name=?, password=?, email=?, country=? WHERE id=?");
			SqlUtil.stmt.setString(1, employee.getName());
			SqlUtil.stmt.setString(2, employee.getPassword());
			SqlUtil.stmt.setString(3,employee.getEmail());
			SqlUtil.stmt.setString(4, employee.getCountry());
			SqlUtil.stmt.setInt(5, id);
			result = SqlUtil.update();
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
