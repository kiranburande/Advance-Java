package com.kiran.test;

import java.sql.*;

public class ResultSetMetaDataDemo 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select  * from student_info");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("******ResultSetMetaData******");
			System.out.println("Number of columns :"+rsmd.getColumnCount());
			
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				System.out.println("Count "+i+" : Name = "+rsmd.getColumnName(i)+ " Type = "+rsmd.getColumnTypeName(i));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
