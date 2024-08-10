package com.abctravels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.static_database_access.ConnectionClass;

public class InsertIntoDB {
	
	public static void insert(UserDetalis user) throws SQLException {
		
		Connection con = ConnectionClass.getConnectionObject();
		
		String query = "insert into abctravels values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, user.email);
		ps.setString(2, user.f_name);
		ps.setString(3, user.l_name);
		ps.setString(4, user.mobile);
		ps.setString(5, user.gender);
		ps.setString(6, user.password);
		ps.setInt(7, user.failedCount);
		ps.setString(8, user.status);
		
		boolean isInserted = ps.execute();
		
		if(!isInserted)
		{
			System.out.println("Inserted successfully!");
		}
		
		ps.close();
		con.close();
	}

}
