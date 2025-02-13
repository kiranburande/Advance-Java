package com.DBConnection.Demo;

import java.util.Scanner;
import java.sql.*;

public class DBCreateInsertUpdateDeleteDemo 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			Statement stmt = con.createStatement();
			
			System.out.println("Enter the NonSelect-query(Create/Insert/Update/Delete)");
			String query = sc.nextLine();
			
			int k = stmt.executeUpdate(query);
			if(k>=0)
			{
				System.out.println("Query Executed Successfully...");
				System.out.println("The value in k:"+k);
			}
			con.close();
		}
		catch(SQLSyntaxErrorException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
