package com.kiran.DBConnection;
import java.util.*;
import java.sql.*;
import java.io.*;

public class Demo {

	public static void main(String[] args) 
	{
        Scanner s = new Scanner(System.in);
        try(s;){
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con  = DriverManager.getConnection
        			("jdbc:oracle:thin:@localhost:1521:orcl","c##practice","bk");
        	PreparedStatement ps = con.prepareStatement
        			("select * from StreamTab71 where id=?");
        	System.out.println("Enter the User-Id to retrieve name and image:");
        	String id = s.nextLine();
        	ps.setString(1, id);
        	ResultSet rs = ps.executeQuery();
        	if(rs.next()) {
        		Blob b = rs.getBlob(3);
        		byte by[] = b.getBytes(1, (int)b.length());
        		System.out.println("User-Id : "+id);
        		System.out.println("User-Name : "+rs.getString(2));
        		System.out.println("Enter the fPath&fName(Destination) to store image:");
        		String path = s.nextLine();
        		FileOutputStream fos = new FileOutputStream(path);
        		fos.write(by);
        		System.out.println("Image retrived and available in destination...");
        		fos.close();
        	}else {
        		System.out.println("Invalid id...");
        	}
        	con.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
