package com.dynamic_database_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.static_database_access.ConnectionClass;

public class Show {
	
	public static void showData() throws SQLException {
		
       Connection con = ConnectionClass.getConnectionObject();
		
		String query = "select * from sample";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getString(1) +" "+rs.getString(2) +" "+ rs.getString(3));
		}
		
		System.out.println("Data retrieved successfully!");
	}
}
