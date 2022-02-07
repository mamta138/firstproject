package com.codeo.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;



public class Updatedata1 {

 static Connection con =null;

	public static void main(String[] args) throws SQLException   {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id: ");
         int id= sc.nextInt();
         System.out.println("Enter name: ");
         String name=sc.next();
         System.out.println("Enter email: ");
         String email=sc.next();
         System.out.println("Enter mobileno: ");
         int mobileno=sc.nextInt();
         System.out.println("Enter Addreass");
         String Addreass=sc.next();
         
       //1. Register the JDBC Driver
 		//Class.forName("oracle.jdbc.driver.OracleDriver");
 		//mysql connector 8.0 
 		//Class.forName("com.mysql.cj.jdbc.Driver");
 		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		// 2. Connecting or Establishing connection
 		//between software and database
 		//Connection==> Interface
 		//Driver Manager==> Class
 		//Oracle 11g
 		//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
 		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         // 3. Create a Statement:(Statement, PrepareStatement)
 		//Statement==> Interface
 		
		// 3. Create a Statement:(Statement, PrepareStatement)
				//Statement==> Interface
		Statement st=con.createStatement();
				String query="UPDATE Table_i " + 
						"   SET name = '"+name+"'  " + 
						"  WHERE id = "+id;
				
				//4. Execute the Query
				int count=0;
				st.executeUpdate(query);
				if(st!=null)
					count=st.executeUpdate(query);
				//process the Result
				if(count==0)
					System.out.println("Record not found for updation");
				else
					System.out.println("Record found and updated");
				
				//5. close the door
				st.close();
				con.close();
			}

			}

