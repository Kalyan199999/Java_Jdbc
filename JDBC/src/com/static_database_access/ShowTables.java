package com.static_database_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowTables {
	
	public static void showTables() throws SQLException {
		
        Connection con = ConnectionClass.getConnectionObject();
		
        String query = "show tables;";
		PreparedStatement st = con.prepareStatement(query);
		
		ResultSet r = st.executeQuery();
		ResultSet rs = (ResultSet) r.getMetaData();
		
		int i=0;
		
		while(rs.next())
		{
			System.out.println(rs.getString(0));

		}
		
		con.close();
	}

}
