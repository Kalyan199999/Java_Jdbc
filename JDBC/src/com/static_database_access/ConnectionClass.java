package com.static_database_access;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionClass {
	
	public static Connection getConnectionObject() throws SQLException
	{
		String url = DatabaseCredientels.getUrl();
		
		String userName = DatabaseCredientels.getUserName();
		
		String password = DatabaseCredientels.getPassword();
		
		Connection con = DriverManager.getConnection(url , userName,password);
		
		System.out.println("Connection Established Successfully!");
		
		return con;
		
	}
}
