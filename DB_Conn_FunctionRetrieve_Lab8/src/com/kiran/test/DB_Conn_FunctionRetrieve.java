package com.kiran.test;

import java.util.*;
import java.sql.*;

public class DB_Conn_FunctionRetrieve 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			CallableStatement cs = con.prepareCall("{call ?:=RETRIEVENAME(?)}");
			System.out.println("Enter the Employee Id to retrieve the Employee name :");
			String id = sc.nextLine();
			cs.setString(2, id);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			System.out.println("Student Id :"+id);
			System.out.println("Student Name :"+cs.getString(1));
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
