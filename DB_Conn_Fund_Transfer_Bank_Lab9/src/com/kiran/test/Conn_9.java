package com.kiran.test;

import java.util.*;
import java.sql.*;
public class Conn_9 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps1 = con.prepareStatement("SELECT * FROM BANKING_SYSTEM WHERE ACCOUNT_NUMBER =?");
			con.setAutoCommit(false);
			System.out.println("Commit status :"+con.getAutoCommit());
			System.out.println("Enter Your Account Number :");
			long acc1 = sc.nextLong();
			ps1.setLong(1, acc1);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next())
			{
				int balance = getAccountBalance(acc1);
				System.out.println("Enter Beneficiary Account Number :");
				long acc2 = sc.nextLong();
				ps1.setLong(1, acc2);
				ResultSet rs2 = ps1.executeQuery();
				if(rs2.next())
				{
					System.out.println("Enter Amount To Transfer :");
					int tAmount = sc.nextInt();
					if(balance >= tAmount)
					{
						int isUpdate = updateAccountBalance(acc1,acc2,tAmount);
						if(isUpdate==1)
						{
							con.commit();
							System.out.println("Transaction Succcessful..");
						}
						else {
							con.rollback();
							System.out.println("Transaction Failed...");
						}
					}
					else {
						System.out.println("Insufficient Funds...");
						System.exit(0);
					}
				}
				else {
					System.out.println("Invalid Beneficiary Account Number");
				}
			}
			else {
				System.err.println("Invalid Account Number");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static int updateAccountBalance(long acc1, long acc2, int amount)
	{
		try {
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps1 = con.prepareStatement("UPDATE BANKING_SYSTEM SET  BALANCE =BALANCE+? WHERE ACCOUNT_NUMBER=?");
			ps1.setInt(1, -amount);
			ps1.setLong(2, acc1);
			int p = ps1.executeUpdate();
			ps1.setInt(1, amount);
			ps1.setLong(2, acc2);
			int q = ps1.executeUpdate();
			if(p==1 && q==1)
				return 1;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
			return 0;
	}
	public static int getAccountBalance(long accNumber)
	{
		int bal=-1;
		try {
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","c##practice","bk");
			PreparedStatement ps1 = con.prepareStatement("SELECT * FROM BANKING_SYSTEM WHERE ACCOUNT_NUMBER =?");
			ps1.setLong(1, accNumber);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next())
			{
				 bal = rs1.getInt(2);
			}
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return bal;
	}

}
