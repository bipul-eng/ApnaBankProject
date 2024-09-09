package com.bipul.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositDao {

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
	
	public int depositAmount(long accno,String uname,String password,long amount) throws SQLException
	{
		long  amount2=0;
		
		PreparedStatement ps1 = con.prepareStatement("update bankcustomer set amount=? where acc_no=?");
		PreparedStatement ps2 = con.prepareStatement("select amount from bankcustomer where acc_no = ?");
		
		ps2.setLong(1, accno);
		ResultSet rs = ps2.executeQuery();
		
		System.out.println(rs);
		if(rs.next())
		{
		
		amount2= rs.getLong(1);
		
		}
		
		ps1.setLong(1, amount+amount2);
		ps1.setLong(2, accno);
		
		int k = ps1.executeUpdate();
		System.out.println(k);
		
		return k;
	}
}
