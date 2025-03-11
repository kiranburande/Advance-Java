package com.kiran.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DB_Conn19 
{
	public static void main(String[] args) 
	{
		List<Departments> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM DEPARTMENTS");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Departments(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
			
//			1.Filters departments located in a specific city (e.g., "New York").
			list.stream().filter(dept->"Pune".equals(dept.location)).forEach(System.out::println);
			
			System.out.println("***********");
//			2.Sorts the departments by name in ascending order.
//			TreeMap<String, Map<Departments, List<Departments>>> collect = list.stream().sorted((a,b)->a.getName().compareTo(b.getName())).collect(Collectors.groupingBy(Departments::getName,TreeMap::new,Collectors.groupingBy(Function.identity())));
//			collect.forEach((k,v)->System.out.println(k+" = "+v));
			
			list.stream().sorted((dept1,dept2)->dept1.getName().compareTo(dept2.getName())).forEach(System.out::println);

			System.out.println("*********************************"); 
//			3.Limits the results to the top 3 departments based on manager_id.
			Set<Entry<Integer, List<Departments>>> entrySet = list.stream().limit(3).collect(Collectors.groupingBy(Departments::getManagerId)).entrySet();
			entrySet.forEach(System.out::println);
			
			
			System.out.println("********************************");
//			4.Prints the list of top 3 departments with their details.
			list.stream().sorted((dept1,dept2)->dept1.getManagerId().compareTo(dept2.getManagerId())).limit(3).forEach(System.out::println);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
