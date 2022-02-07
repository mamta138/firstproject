package com.codeo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DATAdelete {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id: ");
		int id=sc.nextInt();
		//1. Register the JDBC Driver
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//mysql connector 8.0 
		//Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Connecting or Establishing connection
		//between software and database
		//Connection==> Interface
		//Driver Manager==> Class
		//Oracle 11g
		//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
        // 3. Create a Statement:(Statement, PrepareStatement)
		//Statement==> Interface
		Statement st=con.createStatement();
		String query="delete from bill_payment where id="+id;
		//4. Execute the Query
		st.executeUpdate(query);
		
		
		//5. close the door
		st.close();
		con.close();
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	}

}



