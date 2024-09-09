package com.bipul.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

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
	
	public UserBean loginDao(String accno,String userName,String password) throws SQLException
	{
		UserBean ub=null;
		PreparedStatement ps1 = con.prepareStatement("select * from bankcustomer where acc_no=? and username=? and password=?");
		ps1.setString(1, accno);
		ps1.setString(2, userName);
		ps1.setString(3, password);
		
		ResultSet rs = ps1.executeQuery();
		
		while(rs.next())
		{
			ub=new UserBean();
			ub.setUserAccount(Long.parseLong(rs.getString(1)));
			ub.setUserName(rs.getString(2));
			ub.setPassword(rs.getString(3));
			ub.setAmount(Double.parseDouble(rs.getString(4)));
			ub.setAddress(rs.getString(5));
			ub.setPhone(Long.parseLong(rs.getString(6)));
			
			return ub;
		}
		return ub;
	}
}
