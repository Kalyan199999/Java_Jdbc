package com.dynamic_database_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.static_database_access.ConnectionClass;

public class Updation {
	public static void updateData() throws SQLException
	{
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the ID to Update name:");
		int id = sc.nextInt();
		
		System.out.print("Enter the UPDATED name:");
		String name = sc.next();
		
		String query = "update sample set name=? where id=?";
		
		Connection con = ConnectionClass.getConnectionObject();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, id);
		
		boolean isUpdates = ps.execute();
		
		if(!isUpdates)
		{
			System.out.println("Data updated successfully!");
		}
		else {
			System.out.println("Error!");
		}
		
	}
}
