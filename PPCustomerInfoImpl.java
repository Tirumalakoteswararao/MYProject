package com.customer.account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class PPCustomerInfoImpl {

	public static EmailDTO FetchNotifications(String email) {

		EmailDTO EmailObj = new EmailDTO();
		Connection Connection=null;

		try {
			Connection = DBConnection.getConnection();

			String sql = "select *from tablename where EMAIL_ADDRESS=?";
			PreparedStatement stmt = Connection.prepareStatement(sql);
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				EmailObj.setEMAIL_ADDRESS(rs.getString(1));
				EmailObj.setCREATED_DTM(rs.getDate(2));

			}
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if (Connection != null)
				try {
					Connection.close();
					System.out.println("Connection Closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		return EmailObj;
	}
	
	/*public static void main(String[] args) {
		ObjectMapper mapper=new ObjectMapper();
		
		EmailDTO EmailID=PPCustomerInfoImpl.FetchNotifications("abc@gmail.com");
		
		try {
			//String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(EmailID);
			
			String jsonInString = mapper.writeValueAsString(EmailID);
			System.out.println(jsonInString);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
	} 


