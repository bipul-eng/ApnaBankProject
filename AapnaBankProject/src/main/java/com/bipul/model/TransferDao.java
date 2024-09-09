package com.bipul.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferDao {

private static Connection con=null;
	
	static
	{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public int transferAmount(long accno,String name,String password,long taccno,double amount) throws SQLException
	{
		long amount2=0;
		long tamount=0;
		
		PreparedStatement ps1 = con.prepareStatement("select amount from bankcustomer where acc_no=? and username=? and password=?");
		
	    ps1.setLong(1, accno);
	    ps1.setString(2, name);
	    ps1.setString(3, password);
		ResultSet rs = ps1.executeQuery();
		
		if(rs.next())
		{
		amount2=rs.getLong(1);
		
		ps1.setLong(1, taccno);
		ResultSet rs2 = ps1.executeQuery();
		rs2.next();
		tamount=rs2.getLong(1);
		}
		
		
		if(amount2>amount)
		{
			PreparedStatement ps2 = con.prepareStatement("update bankcustomer set amount=? where acc_no=? and username=? and password=?");
			ps2.setDouble(1, (amount2-amount));
			ps2.setLong(2, accno);
			ps2.setString(3, name);
			ps2.setString(4, password);
			ps2.executeUpdate();
			
			ps2.setDouble(1, tamount+amount);
			ps2.setLong(2, taccno);
			return ps2.executeUpdate();
		}
		else
		{
			return -1;
		}
	}
	
	public Double amountBalance(Long account) throws SQLException
	{
		PreparedStatement ps1 = con.prepareStatement("select amount from bankcustomer where acc_no=?");
		ps1.setLong(1, account);
		
		ResultSet rs = ps1.executeQuery();
		rs.next();
		
		return rs.getDouble(1);
	}
}
