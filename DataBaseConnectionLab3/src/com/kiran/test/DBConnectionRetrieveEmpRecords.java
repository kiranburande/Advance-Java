package com.kiran.test;

import java.util.*;
import java.sql.*;

public class DBConnectionRetrieveEmpRecords 
{
	public static void main(String[] args) 
	{
		List<Employee> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("select * from employee where age >25");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				float salary = rs.getFloat(4);
				list.add(new Employee(id,name,age,salary));
			}
			
			for(Employee e:list)
			{
				System.out.println(e);
			}
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
