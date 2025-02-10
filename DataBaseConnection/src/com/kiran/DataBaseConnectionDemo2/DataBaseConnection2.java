package com.kiran.DataBaseConnectionDemo2;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBaseConnection2 
{
	public static void main(String[] args) 
	{
		try {
			//step 1 : Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step 2 : create connection to Database product
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			
			//step 3 : Preparing JDBC-statement
			Statement stmt = con.createStatement();
			
			//step 4 : Executing Query
			ResultSet rs = stmt.executeQuery("select * from PRODUCT71");
			System.out.println("********** Product Details *********");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getInt(4));
			}
			//step 5 : Close the connection of Database product
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
