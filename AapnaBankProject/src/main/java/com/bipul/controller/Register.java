package com.bipul.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.bipul.model.RegisterDao;
import com.bipul.model.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet{

	UserBean ub=new UserBean();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserBean ub=new UserBean();
		
		ub.setUserName(req.getParameter("uname"));
		ub.setPassword(req.getParameter("pass1"));
		ub.setAmount(Double.parseDouble(req.getParameter("amount")));
		ub.setAddress(req.getParameter("address"));
		ub.setPhone(Long.parseLong(req.getParameter("phone")));
		
		RegisterDao rd=new RegisterDao();
		
		try {
			
			ub=rd.registerUser(ub);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(ub!=null)
		{
			req.setAttribute("customer", ub);
			req.getRequestDispatcher("regSuccess.jsp").forward(req, res);
		}
		else
		{
			req.getRequestDispatcher("regFail.jsp").forward(req, res);
		}
	}
	
}
