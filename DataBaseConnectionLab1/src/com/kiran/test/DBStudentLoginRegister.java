package com.kiran.test;

import java.sql.*;
import java.util.*;

public class DBStudentLoginRegister 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("select * from student71");
			PreparedStatement ps1 = con.prepareStatement("insert into student71 values(?,?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("select * from student71 where  PERCENTAGE > 60");
			PreparedStatement ps3 = con.prepareStatement("update student71 set mailid=?, phno=? where rollno=?");
			PreparedStatement ps4 = con.prepareStatement("delete from student71 where percentage between 30 and 60");
			PreparedStatement ps5 = con.prepareStatement("select * from student71 where rollno=? and name=?");
			PreparedStatement ps6 = con.prepareStatement("select * from student71 where percentage>=80");
			
			System.out.println("********Student Login*******");
			System.out.println("\t1. Register"+"\n\t2. Login");
			System.out.println("enter your choice");
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice)
			{
			case 1 : ResultSet rs1 = ps.executeQuery();
				    System.out.println("Enter Roll No :");
			        int rollNo = Integer.parseInt(sc.nextLine());
			        while(rs1.next())
			        {
			        	if(rs1.getInt(1)==rollNo)
			        	{
			        		System.out.println("Student Already Registered.");
			        		System.out.println("Thank You...");
			        		System.exit(0);
			        	}
			        }
			        
			        System.out.println("Enter Name :");
			        String name = sc.nextLine();
			        System.out.println("Enter Percentage :");
			        Float percentage = Float.parseFloat(sc.nextLine());
			        System.out.println("Enter First Name :");
			        String fName = sc.nextLine();
			        System.out.println("Enter Last Name :");
			        String lName = sc.nextLine();
			        System.out.println("Enter Email Id :");
			        String email = sc.nextLine();
			        System.out.println("Enter Phone Number :");
			        long phNo =  Long.parseLong(sc.nextLine());
			        
			        ps1.setInt(1, rollNo);
			        ps1.setString(2, name);
			        ps1.setFloat(3, percentage);
			        ps1.setString(4, fName);
			        ps1.setString(5, lName);
			        ps1.setString(6, email);
			        ps1.setLong(7, phNo);
			        int k = ps1.executeUpdate();
			        if(k>0)
			        {
			        	System.out.println("Student Registered Successfully...");
			        }
				    break;
				    
			case 2: 
			        System.out.println("**********Login***********");
			        System.out.println("Enter RollNo :");
			        int rollNo2 = Integer.parseInt(sc.nextLine());
			        System.out.println("Enter Name :");
			        String name2 = sc.nextLine();
			        ps5.setInt(1, rollNo2);
			        ps5.setString(2, name2);
			        
			        ResultSet rs2 = ps5.executeQuery();
			        
			        if(rs2.next())
			        {
			        	
			        		
			        		System.out.println("Welcome "+rs2.getString(4)+" "+rs2.getString(5));
			        		System.out.println("-------------------------");
			        		System.out.println("\t1. Show Student whose percentage > 60");
			        		System.out.println("\t2. Update MailId & PhoneNo Based on RollNo");
			        		System.out.println("\t3. Delete Student whose percentage between 30% to 60%");
			        		System.out.println("\t4. Find how many student got more than 80%");
			        		System.out.print("\tenter your choice :");
			        		int choice1 = Integer.parseInt(sc.nextLine());
			        		switch(choice1)
			        		{
			        		case 1:
			        			ResultSet rs = ps2.executeQuery();
			        			  while(rs.next())
			        			  {
			        		         System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getLong(7));
			        			  }
			        			  break;
			        			
			        		case 2:
			        			System.out.println("Enter Roll No to update");
			        			int rollNo1 = Integer.parseInt(sc.nextLine());
			        			 System.out.println("Enter new Mail Id :");
			        			 String email1 = sc.nextLine();
			        			 System.out.println("Enter new Phone number");
			        			 long phNo1 = Long.parseLong(sc.nextLine());
			        			 ps3.setString(1, email1);
			        			 ps3.setLong(2, phNo1);
			        			 ps3.setInt(3, rollNo1);
			        			 
			        			 int k2 = ps3.executeUpdate();
			        			 if(k2>0)
			        			 {
			        				 System.out.println("Mail and Phone number Successfully Updated...");
			        			 }
			        			  break;
			        			
			        		case 3:int k3=ps4.executeUpdate();
			        		      if(k3>0)
			        		      {
			        		    	  System.out.println("Student Deleted Successfully...");
			        		      }
			        			  break;
			        		case 4:
			        			ResultSet rs3 = ps6.executeQuery();
			        			while(rs3.next())
			        			{
			        				System.out.println(rs3.getInt(1)+"\t"+rs3.getString(2)+"\t"+rs3.getFloat(3)+"\t"+rs3.getString(4)+"\t"+rs3.getString(5)+"\t"+rs3.getString(6)+"\t"+rs3.getLong(7));
			        			}
			        			  break;
			        		default :
			        			System.out.println("Invalid Choice...");
			        			
			        		}
			        	
			        }
			        else System.out.println("Invalid Process..");
			        
				    break;
				    
			default : System.out.println("Invalid Choice");	
			con.close();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
