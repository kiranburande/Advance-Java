package com.kiran.DBConnectionDemo2;

import java.util.Scanner;
import java.sql.*;

public class DBUpdateDeleteDemo 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			
			Statement stmt = con.createStatement();
			
			System.out.println("Enter the Bookcode to perform update/delete operation :");
			int code = Integer.parseInt(sc.nextLine());
			
			ResultSet rs = stmt.executeQuery("select * from bookdetails71 where code = "+code+"");
			
			if(rs.next())
			{
				System.out.println("************ Choice **********");
				System.out.println("\t1. Update"+"\n\t2. Delete");
				System.out.println("Enter Your Choice :");
				int choice = sc.nextInt();
				
				switch(choice)
				{
				case 1 :System.out.println("**Perform update operations**");
				        System.out.println("Old Book Price :"+rs.getFloat(4));
				        System.out.println("Enter New Price :");
				        float nPrice = sc.nextFloat();
				        System.out.println("Enter the Book Quantity");
				        int nQTY = sc.nextInt();
				        int k = stmt.executeUpdate("update bookdetails71 set price ="+nPrice+",qty = qty+"+nQTY+" where code="+code+"");
				        if(k>0)System.out.println("Book details updated Successfully...");
				        break;
					
				case 2 :int k2 = stmt.executeUpdate("delete from bookdetails71 where code ="+code+"");
				        if(k2>0)System.out.println("Book Details Deleted Successfully");
				        break;
					
				default :System.out.println("Invalid Choice");
				}
			}
			else
				System.out.println("Invalid Bookcode.");
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
