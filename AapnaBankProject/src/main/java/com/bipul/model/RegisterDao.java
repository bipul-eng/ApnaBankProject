package com.bipul.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

public class RegisterDao {

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
	
	public UserBean registerUser(UserBean ub) throws SQLException
	{
		PreparedStatement ps1 = con.prepareStatement("insert into bankcustomer values(sq1.nextval,?,?,?,?,?)");
		ps1.setString(1, ub.getUserName());
		ps1.setString(2, ub.getPassword());
		ps1.setDouble(3, ub.getAmount());
		System.out.println(ub.getAddress());
		ps1.setString(4, ub.getAddress());
		ps1.setLong(5, ub.getPhone());
		
		int k=ps1.executeUpdate();
		
		if(k>0)
		{
			PreparedStatement ps2 = con.prepareStatement("select * from bankcustomer where username=? and password=?");
			ps2.setString(1, ub.getUserName());
			ps2.setString(2, ub.getPassword());
			
			ResultSet rs = ps2.executeQuery();
			
			rs.next();
			UserBean ub2=new UserBean();
			
			ub2.setUserAccount(rs.getLong(1));
			ub2.setUserName(rs.getString(2));
			ub2.setPassword(rs.getString(3));
			ub2.setAmount(rs.getDouble(4));
			
			ub2.setAddress(rs.getString(5));
			ub2.setPhone(rs.getLong(6));
			
			
			return ub2;
			
		}
		
		else
		{
		    return null;
		}
	}
}
