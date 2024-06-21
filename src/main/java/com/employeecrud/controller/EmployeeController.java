package com.employeecrud.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.employeecrud.model.Employee;
import com.employeecrud.serviceimpl.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmployeeServiceImpl employeeServiceImpl;
	
	@Override
    public void init() throws ServletException {
        // Initialize the service implementation
        employeeServiceImpl = new EmployeeServiceImpl();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee> employees = employeeServiceImpl.getAll();
			RequestDispatcher rd = request.getRequestDispatcher("employee-list.jsp");
			request.setAttribute("employeeList", employees);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String country = request.getParameter("country");
	
		    Employee employee =  new Employee(id, name, password,email,country);
			int result = employeeServiceImpl.save(employee);
			RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
			if(result>0) {
				request.setAttribute("msg", "Employee successfully added !");
			}
			else {
				request.setAttribute("errorMsg", "Problem in adding !");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
