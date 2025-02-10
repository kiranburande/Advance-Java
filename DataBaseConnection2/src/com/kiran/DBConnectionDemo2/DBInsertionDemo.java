package com.kiran.DBConnectionDemo2;

import java.util.*;
import java.sql.*;

public class DBInsertionDemo 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			System.out.print("Enter Book Code :");
			int code = Integer.parseInt(sc.nextLine());
			
			
			System.out.print("Enter Book Name :");
			String name = sc.nextLine();
			
			System.out.print("Enter Book Author :");
			String author = sc.nextLine();
			
			System.out.print("Enter Book Price :");
			float price = Float.parseFloat(sc.nextLine());
			
			System.out.print("Enter Book Quantity :");
			int qty = Integer.parseInt(sc.nextLine());
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			
			Statement stmt = con.createStatement();
			
			int k = stmt.executeUpdate("insert into bookdetails71 values("+code+",'"+name+"','"+author+"',"+price+","+qty+")");
			
			if(k>0) {
				System.out.println("Book Details Inserted Successfully.");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
