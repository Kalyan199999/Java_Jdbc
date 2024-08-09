package com.static_database_access;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Data
{
	static int id ,age;
	static String name;
	Data(int id,String anme,int age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	}
}

public class ShowData {
	
	public static void showData() throws SQLException {
		
		Connection con = ConnectionClass.getConnectionObject();
		
		String query = "select * from sample";
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{	
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("age"));
		}
		
		con.close();
	}
}
