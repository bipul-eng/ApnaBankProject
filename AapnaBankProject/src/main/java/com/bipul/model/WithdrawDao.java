package com.bipul.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawDao {

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
	
	public int withdrawAmount(long accno,String name,String password,long amount) throws SQLException
	{
		PreparedStatement ps1 = con.prepareStatement("select amount from bankcustomer where acc_no=?");
		ps1.setLong(1, accno);
		
		ResultSet rs = ps1.executeQuery();
		
		rs.next();
		long amount2=rs.getLong(1);
		
		if(amount<amount2)
		{
			PreparedStatement ps2 = con.prepareStatement("update bankcustomer set amount=? where acc_no=?");
			ps2.setLong(1, (amount2-amount));
			ps2.setLong(2, accno);
			
			int k = ps2.executeUpdate();
			return k;
		}
		else
		{
			return -1;
		}
	}
}
