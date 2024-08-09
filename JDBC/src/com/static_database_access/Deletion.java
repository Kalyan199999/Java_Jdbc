package com.static_database_access;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deletion {
	
	public static void deleteData() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the ID to delete:");
		
		int id = sc.nextInt();
		String query = "delete from sample where id="+id;
		
       Connection con = ConnectionClass.getConnectionObject();
		
		Statement st = con.createStatement();
		
		boolean x = st.execute(query);
		
		if(!x){
			System.out.println("1 instance is deleted!");
		}
		else {
			System.out.println("Error!");
		}
		
		con.close();
	}
}
