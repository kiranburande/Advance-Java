package com.kiran.DBConnectionDemo;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class DBInsertionDemo1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			System.out.println("Enter Product Code :");
			int code = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Product Name :");
			String name = sc.nextLine();
			
			System.out.println("Enter Product Price :");
			double price = Double.parseDouble(sc.nextLine());
			
			System.out.println("Enter Product Quantity :");
			int qty = Integer.parseInt(sc.nextLine());
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			
			Statement stmt = con.createStatement();
			
			int k = stmt.executeUpdate("insert into product71 values("+code+",'"+name+"',"+price+","+qty+")");
			if(k>0)
			{
				System.out.println("Product Details Inserted Successfully");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
