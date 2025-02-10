package com.kiran.DataBaseConnectionDemo1;

import java.sql.*;

public class DataBaseConnection1 
{
	public static void main(String[] args) 
	{
		try {
			// step 1 : loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// step 2 : creating connection to database product
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			
			// step 3 : Preparing JDBC-statement
			Statement stm = con.createStatement();
			
			// step 4 : Executing query
			ResultSet rs = stm.executeQuery("select * from BOOKDETAILS71");
			System.out.println("-----------Book Details------------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4)+'\t'+rs.getInt(5));
			}// end of while
			
			//step 5 : close the connection from Database product
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
