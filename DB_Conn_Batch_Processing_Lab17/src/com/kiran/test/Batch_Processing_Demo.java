package com.kiran.test;
import java.sql.*;
import java.util.*;
public class Batch_Processing_Demo 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oralce.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			Statement stm = con.createStatement();
			System.out.println("*********Insert Operation*********");
			System.out.println("Enter Employee Id :");//empId,empName,empSalary,empAddress,empMailId,empPhNo
			String id = sc.nextLine();
			System.out.println("Enter Employee Name :");
			String name = sc.nextLine();
			System.out.println("Enter Employee Salary :");
			float sal = Float.parseFloat(sc.nextLine());
			System.out.println("Enter Employee Address :");
			String address = sc.nextLine();
			System.out.println("Enter Employee Email :");
			String email = sc.nextLine();
			System.out.println("Enter Phone Number :");
			long phNumber = Long.parseLong(sc.nextLine());
			stm.addBatch("INSERT INTO  EMPLOYEE_INFO1 VALUES('"+id+"', '"+name+"', "+sal+",'"+address+"','"+email+"',"+phNumber+")");
			
			System.out.println("*******Update Salary********");
			System.out.println("Enter Id To Update Salary :");
			String id1 = sc.nextLine();
			System.out.println("Enter Updated Salary :");
			float usal = Float.parseFloat(sc.nextLine());
			stm.addBatch("UPDATE EMPLOYEE_INFO1 SET EMPSALARY="+usal+" WHERE EMPID = "+id1+"");
			
			System.out.println("Delete Employee who is getting Min Salary");
			stm.addBatch("DELETE FROM EMPLOYEE_INFO1 WHERE EMPSALARY =(SELECT MIN(EMPSALARY) FROM EMPLOYEE_INFO1)");
			
			int k[] = stm.executeBatch();
			
			for(int i:k)
			{
				System.out.println("Query Executed");
			}
			stm.clearBatch();
			con.close();
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
