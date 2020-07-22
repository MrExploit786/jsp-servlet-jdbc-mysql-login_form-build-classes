package net.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.java.model.Employee;


public class EmployeeDao {

	// creating method and passing employee class object 

	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		
		
		// now passing the insert sql 
		
		String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";
		
        int result = 0;
        
       // Loading the sql drivers 
        
       Class.forName("com.mysql.jdbc.Driver");
       
       // now wreting the coonection code under try block 
       
       
    	   // creating connection object and regestration of sql driver 
    	   
    	   Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "DreamGoogle*7045");
		
    	   
    	   // Creating the statment 
    	   
    	   PreparedStatement ps;
	
			ps = con.prepareStatement(INSERT_USERS_SQL);
		
    			   
    			   // now inserting the value of employee class from POJO
    			   
    			   ps.setInt(1, 1);
    			   ps.setString(2, employee.getFirstName());
    			   ps.setString(3, employee.getLastName());
    			   ps.setString(4, employee.getUsername());
    			   ps.setString(5, employee.getPassword());
    			   ps.setString(6, employee.getAddress());
    			   ps.setString(7, employee.getContact());
		
    			   
    			   System.out.println(ps);
    			   
    			   // Step 3: Execute the query or update query
    			   
    			   result = ps.executeUpdate();
		}
    			   catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
 
// returning result 		
		return result;
		
		
		
		
	}
	
	
}
