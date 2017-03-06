package com.customer.account;

import java.io.Serializable;
import java.util.Date;

public class EmailDTO  {
	
	String EMAIL_ADDRESS;
	Date CREATED_DTM;
	public String getEMAIL_ADDRESS() {
		return EMAIL_ADDRESS;
	}
	public void setEMAIL_ADDRESS(String eMAIL_ADDRESS) {
		EMAIL_ADDRESS = eMAIL_ADDRESS;
	}
	public Date getCREATED_DTM() {
		return CREATED_DTM;
	}
	public void setCREATED_DTM(Date cREATED_DTM) {
		CREATED_DTM = cREATED_DTM;
	}
	

}
