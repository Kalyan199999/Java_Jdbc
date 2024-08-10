package com.dynamic_database_access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.static_database_access.ConnectionClass;

public class Insertion {
	
	public static void insertData() throws SQLException
	{
		Scanner sc= new Scanner(System.in);
		
		Connection con = ConnectionClass.getConnectionObject();
		
		String query = "insert into sample values(?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		System.out.print("Enter the ID:");
		int id = sc.nextInt();
		ps.setInt(1, id);
		
		System.out.print("Enter the NAME:");
		String name = sc.next();
		ps.setString(2, name);
		
		System.out.print("Enter the age:");
		int age = sc.nextInt();
		ps.setInt(3, age);
		
		boolean isinserted= ps.execute();
		
		if(!isinserted)
		{
			System.out.println("Data inserted succeessfully!");
		}
		else {
			System.out.println("Error!");
		}
		
	}
}
