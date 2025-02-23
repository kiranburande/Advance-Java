package com.kiran.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DB_ConStoreImg 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("INSERT INTO TABLE_PLAYER_INFO VALUES(?,?,?,?)");
			System.out.println("Enter Playes ID :");
			String id = sc.nextLine();
			System.out.println("Enter Player Name :");
			String name = sc.nextLine();
			System.out.println("Enter Player Date Of Birth(DD/MM/YYYY) :");
			String dob = sc.nextLine(); 
			DateFormat format= new SimpleDateFormat("dd/mm/yy");
			java.util.Date date = format.parse(dob);
			Date date1=new java.sql.Date(date.getTime());
			
			System.out.println("Enter Path of Image :");
			String path = sc.nextLine();
			
			File f = new File(path);
			if(f.exists())
			{
				FileInputStream fis = new FileInputStream(path);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setBinaryStream(3, fis,f.length());
				ps.setDate(4, date1);
				
				int k = ps.executeUpdate();
				if(k>0)
				{
					System.out.println("Player Information Stored Successfully...");
				}
				
			}
			else {
				System.out.println("Invalid Path or Image-name");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
