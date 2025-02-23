package com.kiran.test;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DB_Conn_RetrieveImage 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try (sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM TABLE_PLAYER_INFO WHERE PID =?");
			System.out.println("Enter Id to Retrieve Name and Image :");
			String id = sc.nextLine();
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Blob b = rs.getBlob(3);
				byte[] by = b.getBytes(1, (int)b.length());
				System.out.println("Player Id :"+id);
				System.out.println("Player Name :"+rs.getString(2));
				System.out.println("Player Date Of Birth :"+rs.getDate(4));
				System.out.println("Enter Destination FilePath & FileName To Store Image :");
				String path = sc.nextLine();
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(by);
				System.out.println("Image is Retrievd and available in destination...");
				fos.close();
			}
			else {
				System.out.println("Invalid Id....");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
