package com.kiran.test;

import java.util.*;
import java.sql.*;

public class DBConnectionEmployee 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("select * from Employee_Info");
			PreparedStatement ps1 = con.prepareStatement("insert into employee_info values(?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("select * from employee_info where empname like 'S%'");
			PreparedStatement ps3 = con.prepareStatement("select * from employee_info where  EMPSALARY between 10000 and 20000");
			PreparedStatement ps4 = con.prepareStatement("update employee_info set EMPSALARY =? where EMPID=?");
			PreparedStatement ps5 = con.prepareStatement("delete from employee_info where empsalary = (select max(empsalary) from employee_info)");
			PreparedStatement ps6 = con.prepareStatement("select * from employee_info where empname like '%a'");
			while(true)
			{
				System.out.println("********* Menu *********");
				System.out.println("1.Insert data into Employee Table.");
				System.out.println("2.Retrieve all Employee data.");
				System.out.println("3.Retrieve employee whose name stats with 'S'.");
				System.out.println("4.Retrieve employees whose salary between 10000 to 20000.");
				System.out.println("5.Update employee salary with the help of eid.");
				System.out.println("6.delete employee who is getting maximum salary.");
				System.out.println("7.delete employee whose name ends with 'a';");
				System.out.println("8.Exit.");
				
				System.out.print("\t Enter your choice :");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice)
				{
				case 1:System.out.println("Enter Employee Details");
					   System.out.println("Enter Employee ID :");
				       int id = Integer.parseInt(sc.nextLine());
					   System.out.println("Enter Employee Name :");
					   String name = sc.nextLine();
					   System.out.println("Enter Employee Salary :");
					   float salary = Float.parseFloat(sc.nextLine());
					   System.out.println("Enter Employee Address :");
					   String address = sc.nextLine();
					   System.out.println("Enter Employee Mail ID :");
					   String email = sc.nextLine();
					   System.out.println("Enter Employee Phone No :");
					   long phNo = Long.parseLong(sc.nextLine());
					   
					   ps1.setInt(1, id);
					   ps1.setString(2, name);
					   ps1.setFloat(3, salary);
					   ps1.setString(4, address);
					   ps1.setString(5,email);
					   ps1.setLong(6, phNo);
					   int k = ps1.executeUpdate();
					   if(k>0)
					   {
						   System.out.println("Employee data inserted successfully...");
					   }
					   break;
				case 2:
					   ResultSet rs1 = ps.executeQuery();
					   while(rs1.next())
					   {
						   System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getString(4)+"\t"+rs1.getString(5)+"\t"+rs1.getLong(6));
					   }
					   break;
				case 3:System.out.println("Employees Whose name start from S letter");
					   ResultSet rs2 = ps2.executeQuery();
				       while(rs2.next())
				       {
						  System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getString(4)+"\t"+rs2.getString(5)+"\t"+rs2.getLong(6));

				       }
					   break;
				case 4:System.out.println("Employees Whose Salary Between 10000 to 20000");
				       ResultSet rs3 = ps3.executeQuery();
				       while(rs3.next())
				       {
						  System.out.println(rs3.getInt(1)+"\t"+rs3.getString(2)+"\t"+rs3.getFloat(3)+"\t"+rs3.getString(4)+"\t"+rs3.getString(5)+"\t"+rs3.getLong(6));
				       }
					   break;
				case 5:System.out.println("Enter Employee Id :");
				       int id1 = Integer.parseInt(sc.nextLine());
				       System.out.println("Enter Updated Salary :");
				       float salary1 = Float.parseFloat(sc.nextLine());
				       ps4.setFloat(1, salary1);
				       ps4.setInt(2, id1);
				       int k1 = ps4.executeUpdate();
				       
				       if(k1>0)
				       {
				    	   System.out.println("Salary Updated Successfully...");
				    	   
				       }
					   break;
				case 6:int k2 = ps5.executeUpdate();
				       if(k2>0)
				       {
					      System.out.println("Max Salaried Employee Deleted Sccessfully...");
				       }
					   break;
				case 7:ResultSet rs4 = ps6.executeQuery();
				       while(rs4.next())
				       {
						  System.out.println(rs4.getInt(1)+"\t"+rs4.getString(2)+"\t"+rs4.getFloat(3)+"\t"+rs4.getString(4)+"\t"+rs4.getString(5)+"\t"+rs4.getLong(6));

				       }
					   break;
				case 8:System.out.println("Closing the Menu...");
				con.close();
				       System.exit(choice);
					   break;
				default : System.out.println("Invalid Choice");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
