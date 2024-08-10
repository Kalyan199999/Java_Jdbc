package com.abctravels;

import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {
	
	public static void registration() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter an EMAIL(abcd@gmail.com):");
		
		String email = sc.next();
		
		while((!email.contains("@")) || (!email.contains(".")) || ( (email.indexOf('.')) - (email.indexOf('@')) < 0) || (!email.contains("@gmail")) || (!email.contains(".com")))
		{
			System.out.print("Enter a valid EMAIL(abcd@gmail.com):");
			
			email = sc.next();
		}
		
		
		System.out.print("Enter your FIRST NAME:");
		String f_name = sc.next();

		System.out.print("Enter your Last NAME:");
		String l_name = sc.next();
		
		System.out.print("Enter your MOBILE NUMBER:");
		String mobile = sc.next();
		
		while(mobile.length() <10 || mobile.length()>10)
		{
			System.out.print("Enter your valid MOBILE NUMBER:");
			mobile = sc.next();
		}
		
		System.out.print("Enter your GENDER (male(m) or female(f)):");
		String gender = sc.next();
		
		System.out.print("Enter your PASSWORD:");
		String password = sc.next();
		
		while(password.length() < 8)
		{
			System.out.print("Enter your PASSWORD of length should be greater than equal to 8:");
			password = sc.next();
		}
		
		int faliedCount = 0;
		
		String accountStatus = "Successfull";
		
		UserDetalis ud = new UserDetalis(email , f_name , l_name , mobile , gender , password , faliedCount , accountStatus);
		
		System.out.println(ud.email +" "+ud.f_name+" "+ud.l_name+" "+ud.mobile+" "+ud.gender+" "+ud.password+" "+ud.failedCount+" "+ud.status);
		
		InsertIntoDB.insert(ud);
	}
}
