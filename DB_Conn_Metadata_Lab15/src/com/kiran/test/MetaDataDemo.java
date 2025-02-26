package com.kiran.test;

import java.sql.*;


public class MetaDataDemo 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			System.out.println("******DatabaseMetaData******");
			DatabaseMetaData dmd = con.getMetaData();
			System.out.println("Database Product Name :"+dmd.getDatabaseProductName());
			System.out.println("Database Product Version :"+dmd.getDatabaseProductVersion());
			System.out.println("Driver Name :"+dmd.getDriverName());
			System.out.println("Maximum Columns :"+dmd.getMaxColumnsInTable());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
