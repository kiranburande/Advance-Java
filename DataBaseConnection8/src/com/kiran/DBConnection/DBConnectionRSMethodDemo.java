package com.kiran.DBConnection;

import java.sql.*;

public class DBConnectionRSMethodDemo 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("select * from bookdetails71",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();
			System.out.println("*******absolute(2)*******");
			rs.absolute(2);
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
			System.out.println("*******relative(-1)*******");
			rs.relative(-1);
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
			System.out.println("*******last()*******");
			rs.last();
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
			System.out.println("*******afterLast()*******");
			rs.afterLast();
			while(rs.previous())
			{
			   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
			}
			System.out.println("*******beforeFirst()*******");
			rs.beforeFirst();
			while(rs.next())
			{
			   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
