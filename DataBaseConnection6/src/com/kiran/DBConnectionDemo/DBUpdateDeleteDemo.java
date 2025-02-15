package com.kiran.DBConnectionDemo;

import java.util.*;
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
			System.out.println("Enter the Product Code to perform Update/Delete Operations");
			int code = Integer.parseInt(sc.nextLine());
			
			ResultSet rs = stmt.executeQuery("select * from Product71 where CODE="+code+"");
			
			if(rs.next())
			{
				System.out.println("********* Choice ***********");
				System.out.println("\t1.Update"+"\n\t2.Delete");
				System.out.println("Enter your choice :");
				int choice = sc.nextInt();
				
				switch(choice)
				{
				case 1:System.out.println("*** Perform Update Operation***");
				       System.out.println("Old Product Price"+rs.getFloat(3));
				       System.out.println("Enter New Product Price :");
				       float nPrice = sc.nextFloat();
				       System.out.println("Enter Quantity :");
				       int nQty = sc.nextInt();
				       int k = stmt.executeUpdate("Update Product71 set PRICE ="+nPrice+",QTY = QTY+"+nQty+" where CODE="+code+"");
				       if(k>0)
				       {
				    	   System.out.println("Product Details Updated Successfully...");
				       }
					break;
					
				case 2: int k2 = stmt.executeUpdate("delete from product71 where code="+code+"");
				if(k2>0)
				{
					System.out.println("Product Details Deleted Successfully...");
				}
					break;
				
				default : System.out.println("Invalid Choice");	
				}
			}
			else {
				System.out.println("Invalid Book Code");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
