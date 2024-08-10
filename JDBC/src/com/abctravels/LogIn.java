package com.abctravels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.static_database_access.ConnectionClass;

public class LogIn {
	public static void login() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
        Map<String, String> cretientials = new HashMap<>();
		
		Connection con = ConnectionClass.getConnectionObject();
		
		String query = " select email,password from abctravels";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet result = ps.executeQuery();
		
		while(result.next())
		{
			String mail = result.getString(1);
			String pass = result.getString(2);
			
			cretientials.put(mail,pass);
		}
		
		System.out.print("Enter your EMAIL:");
		String email = sc.next();
		
		System.out.print("Enter your PASSWORD:");
		String password = sc.next();
		
		int failure = 1;
		
		while((!cretientials.containsKey(email) || !cretientials.get(email).equals(password)) && failure<=5)
		{
			System.out.print("Enter your EMAIL:");
			email = sc.next();
			
			System.out.print("Enter your PASSWORD:");
			password = sc.next();
			
			failure++;
		}
		
		
		if(failure<=5)
		{
//			details of user
			
			query =  "update abctravels set failedcount=? where email=?";
			PreparedStatement p = con.prepareStatement(query);
			
			p.setInt(1, failure);
			p.setString(2, email);
			p.execute();
			
			query =  "select * from abctravels where email=?";
			p = con.prepareStatement(query);
			p.setString(1, email);
			
			ResultSet res = p.executeQuery();
			
			System.out.println("Your's Details:");
			
			System.out.println("Email:" + res.getString(1) );
			System.out.println("First Name"+res.getString(2));
			System.out.println("Last Name"+res.getString(3));
			System.out.println("Mobile"+res.getString(4));
			System.out.println("Gender"+res.getString(5));
			System.out.println("Password"+res.getString(6));
			System.out.println("Failure Attempts:"+res.getInt(7));
			System.out.println("Status"+res.getString(8));
			
			System.out.println("Log In Successfull!");
			
		}
		else if(cretientials.containsKey(email))
		{
//			blocked
			query =  "update abctravels set failedcount=? , accountstatus=? where email=?";
			PreparedStatement p = con.prepareStatement(query);
			
			p.setInt(1, failure);
			p.setString(2, "Blocked");
			p.setString(3, email);
			p.execute();
			
			System.out.println("Account Blocked!");
			
		}
		else {
//			Invalid credientels
			System.out.println("Invalid Credientials!");
		}
		
		ps.close();
		con.close();
		
	}
}
