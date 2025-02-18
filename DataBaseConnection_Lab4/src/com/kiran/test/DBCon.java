package com.kiran.test;

import java.util.*;
import java.sql.*;

public class DBCon 
{
		public static void main(String[] args) 
		{
			Scanner sc = new Scanner(System.in);
			try(sc;)
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
				PreparedStatement ps = con.prepareStatement("select * from Product1");
				PreparedStatement ps1 = con.prepareStatement("insert into PRODUCT1 values(?,?,?,?)");
				PreparedStatement ps2 = con.prepareStatement("SELECT * FROM Product1 ORDER BY id DESC");
				PreparedStatement ps3 = con.prepareStatement("SELECT * FROM (SELECT Product1.*, ROWNUM AS rn FROM Product1 ORDER BY ID ASC)WHERE rn = 3");
				PreparedStatement ps4 = con.prepareStatement("SELECT * FROM (SELECT t.*, ROWNUM AS rn FROM (SELECT * FROM Product1 ORDER BY ID DESC) t)WHERE rn = 3");
				PreparedStatement ps5 = con.prepareStatement("SELECT * FROM (SELECT * FROM Product1 ORDER BY ID DESC)WHERE ROWNUM <= 3");
				System.out.println("1.Insert productdetails into product table.");
				System.out.println("2.Retrieve productdetails in forward direction.");
				System.out.println("3.Retrieve productdetails in reverse direction.");
				System.out.println("4.Retrieve 3rd record from top.");
				System.out.println("5.Retrieve 3rd record from bottom.");
				System.out.println("6.Retrieve last three record from product table.");
				
				System.out.println("\tEnter Your Choice:");
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice)
				{
				case 1:System.out.println("Enter Product Id :");
				       String id = sc.nextLine();
				       ResultSet rs1 = ps.executeQuery();
				       while(rs1.next())
				        {
				        	if(rs1.getString(1)==id)
				        	{
				        		System.out.println("Student Already Registered.");
				        		System.out.println("Thank You...");
				        		System.exit(0);
				        	}
				        }
				       System.out.println("Enter Product Name :");
				       String name = sc.nextLine();
				       System.out.println("Enter Product Price :");
				       float price = Float.parseFloat(sc.nextLine());
				       System.out.println("Enter Product Quantity :");
				       int qty = Integer.parseInt(sc.nextLine());
				       ps1.setString(1, id);
				       ps1.setString(2, name);
				       ps1.setFloat(3, price);
				       ps1.setInt(4, qty);
				       int k = ps1.executeUpdate();
				       if(k>0)
				       {
				    	   System.out.println("Product Details Inserted Successfully...");
				       }
					break;
				case 2:ResultSet rs2 = ps.executeQuery();
				       while(rs2.next())
				       {
				    	   System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4)+"\t");
				       }
					break;
				case 3:ResultSet rs3 = ps2.executeQuery();
				 while(rs3.next())
			       {
			    	   System.out.println(rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getFloat(3)+"\t"+rs3.getInt(4)+"\t");
			       }
					break;
				case 4:ResultSet rs4 = ps3.executeQuery();
				 while(rs4.next())
			       {
			    	   System.out.println(rs4.getString(1)+"\t"+rs4.getString(2)+"\t"+rs4.getFloat(3)+"\t"+rs4.getInt(4)+"\t");
			       }
					break;
				case 5:
					ResultSet rs5 = ps4.executeQuery();
					 while(rs5.next())
				       {
				    	   System.out.println(rs5.getString(1)+"\t"+rs5.getString(2)+"\t"+rs5.getFloat(3)+"\t"+rs5.getInt(4)+"\t");
				       }
					break;
				case 6:ResultSet rs6 = ps5.executeQuery();
				 while(rs6.next())
			       {
			    	   System.out.println(rs6.getString(1)+"\t"+rs6.getString(2)+"\t"+rs6.getFloat(3)+"\t"+rs6.getInt(4)+"\t");
			       }
					break;
				default : System.out.println("Invalid Choice");
				}
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
