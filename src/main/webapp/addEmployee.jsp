<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  		   Add New Employee
		</div>
    </div>
    <div class="container mt-5">
    	<form action="EmployeeController" method="post">
    		<div class="row">
    			<div class="col-lg-4">
    				<div class="mb-3">
    					<label for="id" class="form-label">Id</label>
    					<input type="text" class="form-control" id="id" name="id">
  					</div>
    			</div>
    			<div class="col-lg-4">
    				<div class="mb-3">
    					<label for="name" class="form-label">Name</label>
    					<input type="text" class="form-control" id="name" name="name">
  					</div>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-lg-4">
    				<div class="mb-3">
    					<label for="marks" class="form-label">Password</label>
    					<input type="text" class="form-control" id="password" name="password">
  					</div>
    			</div>
    			<div class="col-lg-4">
    				<div class="mb-3">
    					<label for="phone" class="form-label">Email</label>
    					<input type="text" class="form-control" id="email" name="email">
  					</div>
    			</div>
    			<div class="col-lg-4">
    				<div class="mb-3">
    					<label for="phone" class="form-label">Country</label>
    					<input type="text" class="form-control" id="country" name="country">
  					</div>
    			</div>
    			
    		</div>
    		
    		<div class="row">
    			<div class="col-lg-4">
    				<input type="submit" class="btn btn-success" value="Add Employee">
    			</div>
    		</div>
    	</form>
    </div>
    <div class="container">
    	<div class="row">
    		<div class="col-lg-4">
    			<%
    				if(request.getAttribute("msg")!=null){
    					%>
    					<div class="alert alert-success" role="alert">
  							<%=request.getAttribute("msg") %>
						</div>
    					<%
    				}
    				if(request.getAttribute("errorMsg")!=null){
						%>
						<div class="alert alert-danger" role="alert">
							<%=request.getAttribute("errorMsg") %>
						</div>
						<%
				}
    			%>
    		</div>
    	</div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
