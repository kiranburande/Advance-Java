package com.kiran.test;

import java.sql.*;
import java.util.*;
import java.io.*;

public class DBConnectionStoreFile
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMP_INFO1 VALUES(?,?,?,?,?,?)");
			System.out.println("Enter Employee  Id To Store File :");
			String id = sc.nextLine();
			System.out.println("Enter Employee  empName :");
			String name = sc.nextLine();
			System.out.println("Enter Employee empAddress :");
			String address = sc.nextLine(); 
			System.out.println("Enter Employee empMailId :");
			String email = sc.nextLine();
			System.out.println("Enter Employee empPhNo :");
			long phNo = Long.parseLong(sc.nextLine());
			System.out.println("Enter the path(source) and File name:");
			String path = sc.nextLine();
			
			File f = new File(path);
			if(f.exists())
			{
				FileInputStream fis = new FileInputStream(path);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setString(4, email);
				ps.setLong(5, phNo);
				ps.setBinaryStream(6, fis,f.length());
				int k = ps.executeUpdate();
				if(k>0)
				{
					System.out.println("File Stored Successfully...");
				}
				
			}
			else {
				System.out.println("Invalid Path or Image-name");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
