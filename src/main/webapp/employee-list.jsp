<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.employeecrud.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	request.getSession(false);
    %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
    	<div class="alert alert-primary" role="alert">
  			List of all the employees
		</div>
    </div>
    <div class="container mt-5">
    	<%
    	
    		if(request.getAttribute("employeeList")!=null){
    			List<Employee> employees =(ArrayList<Employee>)request.getAttribute("employeeList");
    			%>
    			<table class="table">
  					<thead>
    					<tr>
      						<th scope="col">Id</th>
      						<th scope="col">Name</th>
      						<th scope="col">Password</th>
      						<th scope="col">Email</th>
      						<th scope="col">Country</th>
      					
      						<th scope="col">Action</th>
    					</tr>
  					</thead>
  					<tbody>
  						<%
  						   Iterator<Employee> itr = employees.iterator();
  						    while(itr.hasNext()){
  						    	Employee emp = itr.next();
  						    	%>
  						    	<tr>
  						    		<td><%= emp.getId() %></td>
  						    		<td><%= emp.getName() %></td>
  						    		<td><%= emp.getPassword() %></td>
  						    		<td><%= emp.getEmail() %></td>
  						    		<td><%= emp.getCountry() %></td>
  						    		
  						    		<td><a href='#' class="btn btn-danger">Delete</a></td>
  						    	</tr
  						    	<% 
  						    }
  						%>
  					</tbody>
  				</table>
    			<%
    		}
    	
    	%>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>