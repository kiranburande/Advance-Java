package com.kiran.test;

import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConnectionRetrieveFile
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try (sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP_INFO1 WHERE EMPID =?");
			System.out.println("Enter Id to Retrieve Name and File :");
			String id = sc.nextLine();
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Blob b = rs.getBlob(6);
				byte[] by = b.getBytes(1, (int)b.length());
				System.out.println("Employee Id :"+id);
				System.out.println("Employee Name :"+rs.getString(2));
				System.out.println("Employee Adress :"+rs.getString(3));
				System.out.println("Employee Email Id :"+rs.getString(4));
				System.out.println("Employee Phone No :"+rs.getLong(5));
				System.out.println("Enter Destination FilePath & FileName To Store File :");
				String path = sc.nextLine();
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(by);
				System.out.println("File is Retrievd and avalable in destination...");
				fos.close();
			}
			else {
				System.out.println("Invalid Id....");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
