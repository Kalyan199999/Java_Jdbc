package com.dynamic_database_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.static_database_access.ConnectionClass;

public class Deletion {
	
	public static void deleteData() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		Connection con  = ConnectionClass.getConnectionObject();
		
		String query = "delete from sample where id=?";
		
		System.out.print("Enter the id to delete:");
		int id = sc.nextInt();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		boolean isDeleted =  ps.execute();
		
		if(!isDeleted) {
			System.out.println("Data deleted successfully!");
		}
		else {
			System.out.println("Error!");
		}
		
	}
}
