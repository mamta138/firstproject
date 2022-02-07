package com.codeo.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Loosecoupling1 {

	static Connection con=null;

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
	     System.out.println("Enter Name:");
	     String name=sc.next();
	     System.out.println("Enter Lastname:");
	     String lname=sc.next();
	     System.out.println("Enter Mobileno:");
	     String mobileno=sc.next();
	     System.out.println("Enter Emailid:");
	     String emailid=sc.next();
	     System.out.println("Enter Billamount:");
	     String bamount=sc.next();
	  
	     //1. Register JDBC Driver
	     try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	   //2. Establish the connection with d/b
	     
	    try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //3. Create a Statement (Prepared Statement)
		//PreparedStatement==> Interface
		//To Achieve loose coupling
		
	    String query="INSERT INTO hmanagment(name,lastname,mobileno,emailid,billamount)values(?,?,?,?,?)";
	     
	    PreparedStatement ps=null;
		if(con!=null) {
			ps=con.prepareStatement(query);
			
			}
		
		if(ps!=null) {
			ps.setString(1, name );
			ps.setString(2, lname );
			ps.setString(3, mobileno );
			ps.setString(4, emailid );
			ps.setString(5, bamount);
			
		}
		
		if(ps!=null) {
			int result=0;
			//4. Execute the query
			result=ps.executeUpdate();
			
		if(result==1) {
			System.out.println("Record Inserted Successfully");
		}
		else {
			System.out.println("Issue in Record Insertion");
		}
		}
		//5. Close the connections
		ps.close();
		con.close();
	
	}

}
