package com.abctravels;

public class UserDetalis {
	
	String email , f_name ,  l_name, mobile, gender, password, status;
	int failedCount ;
	
	public UserDetalis()
	{
		this.email = "user@gmail.com";
		this.f_name = "user first name";
		this.l_name = "user last name";
		this.mobile = "0123456789";
		this.gender = "m";
		this.password = "abcd12345";
		this.failedCount = 0;
		this.status = "Failure";
	}
	
	public UserDetalis(String email , String f_name , String l_name,String mobile,String gender,String password,int failedCount , String status)
	{
		this.email = email;
		this.f_name = f_name;
		this.l_name = l_name;
		this.mobile = mobile;
		this.gender = gender;
		this.password = password;
		this.failedCount = failedCount;
		this.status = status;
	}
}
