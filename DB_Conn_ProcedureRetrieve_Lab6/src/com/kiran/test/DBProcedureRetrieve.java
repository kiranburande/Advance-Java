package com.kiran.test;

import java.sql.*;
import java.util.*;

public class DBProcedureRetrieve 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			CallableStatement cs = con.prepareCall("{call RETRIEVESTUDATA(?,?,?,?,?,?,?,?,?)}");
			System.out.println("Enter the Student-Id to retrieve details:");
			String sId = sc.nextLine();
			cs.setString(1, sId);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.BIGINT);
			cs.execute();
			System.out.println("******Student Details*****");
			System.out.println("Student Id :"+sId);
			System.out.println("Student Roll No :"+cs.getInt(2));
			System.out.println("Student Name :"+cs.getString(3));
			System.out.println("Student Branch :"+cs.getString(4));
			System.out.println("Student House No :"+cs.getString(5));
			System.out.println("Student City :"+cs.getString(6));
			System.out.println("Student PinCode :"+cs.getInt(7));
			System.out.println("Student Mail :"+cs.getString(8));
			System.out.println("Student Phone No :"+cs.getLong(9));
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	}

}
