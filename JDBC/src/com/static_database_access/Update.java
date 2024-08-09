package com.static_database_access;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	
	public static void updateData() throws SQLException {
      Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the ID to Update name:");
		int id = sc.nextInt();
		
		System.out.print("Enter the UPDATED name:");
		String name = sc.next();
		
		String query = "update sample set name='"+name+"' where id="+id;
		
       Connection con = ConnectionClass.getConnectionObject();
		
		Statement st = con.createStatement();
		
		boolean x = st.execute(query);
		
		if(!x){
			System.out.println("1 instance is modified!");
		}
		else {
			System.out.println("Error!");
		}
		
		con.close();
	}
}
