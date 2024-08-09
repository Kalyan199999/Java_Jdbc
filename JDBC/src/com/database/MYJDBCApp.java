package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MYJDBCApp {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		
		String userName = "root";
		
		String password  = "K@lyan19";
		
		Connection con = null;
		
//		Creating a connection 
		
		con = DriverManager.getConnection(url,userName,password);
		
		System.out.println("Connection successful...");
		
		System.out.println(con);
		
//		creating the statement to executing the statements
		Statement stmt = con.createStatement();
		System.out.println(stmt);
		
//		executing the sql queries
		String query = "select * from student";
		boolean x = stmt.execute(query);
		System.out.println(x);
		
	
		
		String dqlQuery = "select * from student ";
		ResultSet rs = stmt.executeQuery(dqlQuery);
		
		System.out.println(rs);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt("age")+" "+rs.getInt(5));
		}
		
		java.sql.ResultSetMetaData metadata = rs.getMetaData();
		
		System.out.println("Total No.of columns:"+metadata.getColumnCount());
		
		for(int i=1;i<=metadata.getColumnCount();i++)
		{
			System.out.println("column:"+i+" "+metadata.getColumnName(i));
			
		}
		
		PreparedStatement ps = con.prepareStatement("select * from student where id = ?");
		ps.setInt(1, 2);
		
		System.out.println(ps);
		
		ResultSet r = ps.executeQuery();
		System.out.println(r);
		while(r.next())
		{
			System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getInt("age")+" "+r.getInt(5));
		}
		
		con.close();
	}
}
