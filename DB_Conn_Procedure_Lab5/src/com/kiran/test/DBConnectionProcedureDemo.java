package com.kiran.test;

import java.sql.*;
import java.util.*;

public class DBConnectionProcedureDemo 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			CallableStatement cs = con.prepareCall("{call INSERTSTUDATA(?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("Enter Student Id");
			String sId = sc.nextLine();
			System.out.println("Enter Student Roll No:");
			int sRollNo = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Student Name :");
			String sName = sc.nextLine();
			System.out.println("Enter Student Branch :");
			String sBranch = sc.nextLine(); 
			System.out.println("Enter Student House number :");
			String sHNo = sc.nextLine();
			System.out.println("Enter Student City :");
			String sCity = sc.nextLine();
			System.out.println("Enter Student Pin Code :");
			int sPinCode = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Student Mail Id  :");
			String sMail = sc.nextLine();
			System.out.println("Enter Student Phone Number :");
			long sPhNo = Long.parseLong(sc.nextLine());
			
			cs.setString(1, sId);
			cs.setInt(2, sRollNo);
			cs.setString(3, sName);
			cs.setString(4, sBranch);
			cs.setString(5, sHNo);
			cs.setString(6, sCity);
			cs.setInt(7, sPinCode);
			cs.setString(8, sMail);
			cs.setLong(9, sPhNo);
			cs.execute();
			System.out.println("Student Details Inserted Successfully...");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
