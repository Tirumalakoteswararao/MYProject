package com.customer.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection()throws SQLException  {
		Connection con=null;
		
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@ndc-vwmclmp1:1521:wmclmp1","clm_user","clmprod");  
		System.out.println("Connection sucessfull..");

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	  
	//step2 create  the connection object  
	
	return con;
}
	
	/*
	public static void main(String[] args) throws Exception {
		
		Connection connection=DBConnection.getConnection();
		
		String sql="select *from wcp_email where EMAIL_ADDRESS=?";
		PreparedStatement  stmt=connection.prepareStatement(sql); 
		stmt.setString(1,"koti2java@gmail.com");
		
		ResultSet rs=stmt.executeQuery();  
		while(rs.next()){  
		  
		System.out.println(rs.getString(1)+""+rs.getDate(2));
		
		}
	}*/

}