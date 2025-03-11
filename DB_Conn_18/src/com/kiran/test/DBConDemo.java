package com.kiran.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DBConDemo 
{
	public static void main(String[] args) 
	{
		ArrayList<Order> al = new ArrayList<Order>();
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER10");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Order o = new Order(rs.getString(1),rs.getString(2), rs.getDate(3).toString(),rs.getInt(4));
				
				al.add(o);
			}
			
			System.out.println("****All Customer list****");
			al.forEach(System.out::println);
			
			System.out.println();
			System.out.println("****Orders where the total_amount is greater than 4000****");
			al.stream().filter(ord->ord.gettAmt()>4000).forEach(System.out::println);
			
			System.out.println();
			System.out.println("****Sort the orders by order_id in ascending order.****");
			al.stream().sorted((a,b)->a.getOrdId().compareTo(b.getOrdId())).forEach(System.out::println);
			
			System.out.println();
			System.out.println("****Group the orders by customer_name****");
			Map<String, List<Order>> collect = al.stream().collect(Collectors.groupingBy(ord->ord.getCustName()));

			Set<Entry<String, List<Order>>> entrySet = collect.entrySet();
			entrySet.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
