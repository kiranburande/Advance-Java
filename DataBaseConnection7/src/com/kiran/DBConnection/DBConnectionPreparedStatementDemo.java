package com.kiran.DBConnection;

import java.util.*;
import java.sql.*;

public class DBConnectionPreparedStatementDemo 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;) 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps1 = con.prepareStatement("insert into employee71 values(?,?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("select * from employee71");
			PreparedStatement ps3 = con.prepareStatement("select * from employee71 where eid=?");
			PreparedStatement ps4 = con.prepareStatement("update employee71 set bsal=?, hra=?, da=?,totsal=? where eid =?");
			PreparedStatement ps5 = con.prepareStatement("delete from employee71 where eid=?");
			while(true)
			{
				System.out.println("********Employee Operations Choices********");
				System.out.println("\t1. Add Employee"+"\n\t2. View All Employees"+"\n\t3. View Employee By Id"+"\n\t4. Update Employees"+"\n\t5. Delete Employee"+"\n\t6. Exit");
				System.out.println("Enter Your Choice");
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice)
				{
				case 1: System.out.println("Enter Employee Id");
				        String id = sc.nextLine();
				        System.out.println("Enter Employee Name");
				        String ename = sc.nextLine();
				        System.out.println("Enter Employee Designation");
				        String edesg = sc.nextLine();
				        System.out.println("Enter Employee Basic Salary");
				        int bsal = Integer.parseInt(sc.nextLine());
				        float hra = 0.91f * bsal;
				        float da = 0.63f *bsal;
				        float totsal = bsal+hra+da;
				        //Load the data to PreparedStatement Object
				        ps1.setString(1, id);
				        ps1.setString(2, ename);
				        ps1.setString(3, edesg);
				        ps1.setInt(4, bsal);
				        ps1.setFloat(5, hra);
				        ps1.setFloat(6, da);
				        ps1.setFloat(7, totsal);
				        int k = ps1.executeUpdate();//Execution process
				        if(k>0)
				        {
				        	System.out.println("Employee Added Successfully...");
				        }
				        break;
				  
				 case 2: ResultSet rs1 = ps2.executeQuery();
				        System.out.println("------Employee Details------");
				        while(rs1.next())
				        {
				        	System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getInt(4)+"\t"+rs1.getFloat(5)+"\t"+rs1.getFloat(6)+"\t"+rs1.getFloat(7));
				        }
				        break;
				 
				 case 3:System.out.println("Enter Employee Id To Display Details");
				        String id1 =sc.nextLine();
				        ps3.setString(1, id1);
				        ResultSet rs2 = ps3.executeQuery();
				        if(rs2.next())
				        {
				        	System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getInt(4)+"\t"+rs2.getFloat(5)+"\t"+rs2.getFloat(6)+"\t"+rs2.getFloat(7));
				        }
				        else {
				        	System.out.println("Invalid Employee Id");
				        }
				        break;
				  
				 case 4: System.out.println("Enter Employee Id To Update Details");
				        String id2 = sc.nextLine();
				        ps3.setString(1, id2);
				        
				        ResultSet rs3 = ps3.executeQuery();
				        if(rs3.next())
				        {
				        	System.out.println("Exising Salary is "+rs3.getInt(4));
				        	System.out.println("Enter New Salary");
				        	int bsal2 = Integer.parseInt(sc.nextLine());
				        	float hra2 = 0.91f*bsal2;
				        	float da2 = 0.63f*bsal2;
				        	float totsal2 = bsal2+hra2+da2;
				        	
				        	//Loading data to PreparedStatement Object
				        	ps4.setInt(1, bsal2);
				        	ps4.setFloat(2, hra2);
				        	ps4.setFloat(3, da2);
				        	ps4.setFloat(4, totsal2);
				        	ps4.setString(5, id2);
				        	
				        	int k2 = ps4.executeUpdate();
				        	if(k2>0)
				        	{
				        		System.out.println("Employee Updated Successfully...");
				        	}
				        }
				        else {
				        	System.out.println("Invalid Employee Id");
				        }
				        break;
				        
				  case 5 :System.out.println("Enter Employee Id To Delete Details");
			             String id3 = sc.nextLine();
			             ps3.setString(1, id3);
			             
			             ResultSet rs4 = ps3.executeQuery();
			             if(rs4.next())
			             {
			            	 ps5.setString(1, id3);
			            	 int k3 = ps5.executeUpdate();
			            	 if(k3>0)
			            	 {
			            		 System.out.println("Employee Details Deleted Seccessfully...");
			            	 }
			             }
			             else {
			            	 System.out.println("Invalid Employee Id");
			             }
			             break;
					 
				  case 6:System.out.println("Operations Stopped...");
				         System.exit(0);
				         
				  default:System.out.println("Invalid Choice...");
				}

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
