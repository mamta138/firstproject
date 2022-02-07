package com.codeo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class datainsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.jdbc.Driver");
	 //established connections
	 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","");
       // statement 
	 Statement st= con.createStatement();
	 String query  = "INSERT INTO table_i (student_name, email_id, mobileno, addreass, rollno) values ('Mansi','mansi46@gmail.com','wathodaanmolna','7798806539','56')";
	 //execute the query
	st.executeUpdate(query);
	 st.close();
	 con.close();
	}

}

