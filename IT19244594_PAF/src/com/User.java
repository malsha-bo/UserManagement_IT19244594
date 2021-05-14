package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	
	
	//A common method to connect to the DB
		
			private Connection connect() 
			{ 
				 Connection con = null; 
				 
				 try
				 { 
					 Class.forName("com.mysql.cj.jdbc.Driver"); 
				 
					 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_management?useServerPrepStmts=true&tinyInt1isBit=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", ""); 
				 } 
				 catch (Exception e) 
				 {
					 e.printStackTrace();
				 } 
				 return con; 
			 } 
			
			
			//====================User=============================================
			
			//=============insert User Method===============
			
			public String insertUser(String fname, String lname, String nic ,String type, String email, String phoneNumber,String pw)
			{
				String output = "";
				try
				{
					Connection con = connect();
					if (con == null)
					{
						return "Error while connecting to the database";
					}

					// create a prepared statement
					String query = " insert into users(`userID`,`firstName`,`lastName`,`nic`,`userType`,`email`,`phoneNumber`,`password`)"
							 + " values (?, ?, ?, ?,?, ?,?,?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, fname); 
					 preparedStmt.setString(3, lname); 
					 preparedStmt.setString(4, nic);
					 preparedStmt.setString(5, type);
					 preparedStmt.setString(6, email);
					 preparedStmt.setString(7, phoneNumber); 
					 preparedStmt.setString(8, pw); 
					

					//execute the statement
					preparedStmt.execute();
				
					con.close();
					
			 		String newUser = readUsers(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					            newUser + "\"}"; 
				}
				catch (Exception e)
				{
					output = "{\"status\":\"error\", \"data\": \"Error while inserting the Users.\"}";
					System.err.println(e.getMessage());
				}
				return output;
			}
			
			//=============Read all Users ===============
			
			public String readUsers()
			 {
				 String output = "";
				 try
				 {
					 Connection con = connect();
				 if (con == null)
				 {
					 return "Error while connecting to the database for reading."; }
				 
				 // Prepare the html table to be displayed
				 output = "<table border='2'><tr>"+
				 "<th>First Name</th>" +
				 "<th>Last Name</th>" +
				 "<th>  NIC</th>" +
				 "<th>Phone Number</th>" +
				 "<th>  Email</th>" +
				 "<th>Type</th>" +
				 "<th>Password</th>"
				 + "<th>Update</th><th>Remove</th></tr>";
				
				 String query = "select * from users";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 
				 // iterate through the rows in the result set
				 while (rs.next())
				 {
					 String userID      = Integer.toString(rs.getInt("userID")); 
					 String firstName   = rs.getString("firstName"); 
					 String lastName    = rs.getString("lastName"); 
					 String nic         = rs.getString("nic"); 
					 String userType    = rs.getString("userType");
					 String email       = rs.getString("email");
					 String phoneNumber = rs.getString( "phoneNumber"); 
					 String password    = rs.getString("password");
					 
					 
					 // Add into the html table
					 output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + userID
								+ "'>" + firstName + "</td>";
					 output += "<td>" + lastName + "</td>";
					 output += "<td>" + nic + "</td>"; 
					 output += "<td>" + phoneNumber + "</td>"; 
					 output += "<td>" + email + "</td>"; 
					 output += "<td>" + userType + "</td>"; 
					 output += "<td>" + password + "</td>";


					 
					 // buttons
			            output += "<td><input name='btnUpdate' type='button' value='Update' class=' btnUpdate btn btn-secondary' data-userid='" + userID + "'></td>"
			            		+ "<td><input name = 'btnRemove' type='button' value = 'Remove' "
			            		+ "class = 'btnRemove btn btn-danger' data-userid='" + userID + "'>"
			            		+"</td></tr>";
			            		
			 }
				 con.close();
				 
				 // Complete the html table
				 output += "</table>";
			 }
			 catch (Exception e)
			 {
				 output = "Error while reading Users.";
				 System.err.println(e.getMessage());
			 }
				 return output;
			 }
			
			//=============Updating a User Method===============

			public String updateUser(String userID,String fname, String lname, String nic ,String type, String email, String pno,String pw)
			{
				 String output = "";
				 try
				 {
				 Connection con = connect();
				 if (con == null)
				 {
					 return "Error while connecting to the database for updating."; }
					
				 	// create a prepared statement
				     String query = "UPDATE users SET firstName=?,lastName=?,nic=?,phoneNumber=?,email=?,userType=?,password=? WHERE userID=?";
					 PreparedStatement preparedStmt = con.prepareStatement(query);
					 
					 
					 // binding values
					
					
					 preparedStmt.setString(1, fname); 
					 preparedStmt.setString(2, lname); 
					 preparedStmt.setString(3, nic);
					 preparedStmt.setString(4, type);
					 preparedStmt.setString(5, email);
					 preparedStmt.setString(6, pno); 
					 preparedStmt.setString(7, pw); 
					 
					 preparedStmt.setInt(8, Integer.parseInt(userID));
					 
					 // execute the statement
					 preparedStmt.execute();
					 con.close();
					 
				 		String newUser = readUsers(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						             newUser + "\"}"; 
				 }
				 catch (Exception e)
				 {
						output = "{\"status\":\"error\", \"data\": \"Error while updating the User.\"}";
						System.err.println(e.getMessage());
				 }
				 	return output;
				 }
			
			
			//=============Deleting User Method===============
			
			public String deleteUser(String userID)
			 {
				String output = "";
				
				     try{
					   
						 Connection con = connect();
						 if (con == null)
						 {
							 return "Error while connecting to the database for deleting."; }
							 
						 	// create a prepared statement
							 String query = "delete from users where userID=?";
							 PreparedStatement preparedStmt = con.prepareStatement(query);
							 
							 // binding values
							 preparedStmt.setInt(1, Integer.parseInt(userID));
							 
							 // execute the statement
							 preparedStmt.execute();
							 con.close();
								String newUser = readUsers(); 
								 output = "{\"status\":\"success\", \"data\": \"" + 
								               newUser + "\"}"; 
						 }
					 catch (Exception e)
					 {
							output = "{\"status\":\"error\", \"data\": \"Error while deleting the User.\"}";
							System.err.println(e.getMessage());
					 }
					 	return output;
					 }

}
