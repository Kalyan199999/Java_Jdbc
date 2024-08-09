package com.static_database_access;

public class DatabaseCredientels {
	
	final static private String URL = "jdbc:mysql://localhost:3306/mydatabase";
	
	final static private String USERNAME = "root";
	
	final static private String PASSWORD  = "K@lyan19";
	
	public static String getUrl()
	{
		return DatabaseCredientels.URL;
	}
	
	public static String getUserName()
	{
		return DatabaseCredientels.USERNAME;
	}
	
	public static String getPassword()
	{
		return DatabaseCredientels.PASSWORD;
	}
}
