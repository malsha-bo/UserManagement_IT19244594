<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
     <%@page import = "com.User" %>
      
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>


<link rel = "stylesheet" href = "Views/bootstrap.min.css">
<script src = "Components/text"></script>
<script src = "Components/Users.js"></script>



</head>
<body>

<div class = "container"> 
	<div class="row">
		<div class="col">

		<h2>User Management</h2><br>
		
	
		
	<form id="formItem" name="formItem"  >
		    First Name:
			<input id='firstName' name='firstName' type='text' class='form-control form-control-sm'><br>
			Last Name: 
			<input id='lastName' name='lastName' type='text' class='form-control form-control-sm'><br> 
			NIC: 
			<input id='nic' name='nic' type='text' class='form-control form-control-sm'><br> 
			Phone Number: 
			<input id='phoneNumber' name='phoneNumber' type='text' class='form-control form-control-sm'><br> 
			Email: 
			<input id='email' name='email' type='text' class='form-control form-control-sm'><br> 
			User Type: 
			<input id='userType' name='userType' type='text' class='form-control form-control-sm'><br>
			Password: 
			<input id='password' name='password' type='text' class='form-control form-control-sm'><br>
			
		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
		<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
	</form>
    
     <div id="alertSuccess" class="alert alert-success"></div>
     <div id="alertError" class="alert alert-danger"></div>
    
    <br>
	<div id="divItemsGrid">
	<%
		User itemObj = new User();
		out.print(itemObj.readUsers());
	%>
	</div>
<br>


</div>
</div>
</div>


</body>
</html>