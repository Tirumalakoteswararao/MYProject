package com.customer.account;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.customer.Exec.MyException;

@Path("/customer") 
public class MyCustomerService  {
	
	

	@POST
    @Path("/add/{Email}")  
	//@Path("{year}/{month}/{day}")
    public Response getMsg(@PathParam("Email") String email) {  
       
		EmailDTO EmailID=PPCustomerInfoImpl.FetchNotifications(email);
		
		System.out.println("EmailID is"+EmailID);
		
		if(EmailID.getEMAIL_ADDRESS()==null){
			
		return Response.status(200).entity("Email-ID is not prasent in DB").build();
		}
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonInString=null;
		try {
			jsonInString= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(EmailID);
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
		/*
		String Email=EmailID.getEMAIL_ADDRESS();
		System.out.println(Email);
		Date date=EmailID.getCREATED_DTM();
		System.out.println(date);
		
	   return Response.status(200).entity("Customer Details are:!<br> Email-ID is:"+Email+"<br> Created DTM is:"+date).build();  
		*/
		return Response.status(200).entity("Customer Details are <br>:"+jsonInString).build();
    }  

}
