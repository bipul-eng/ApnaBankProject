package com.bipul.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.bipul.model.DepositDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deposit")
public class deposit extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int k=0;
		
		long accNo = Long.parseLong(req.getParameter("ano"));
		String name = req.getParameter("uname");
		String password = req.getParameter("pass");
		long amount = Long.parseLong(req.getParameter("amount"));
		
		DepositDao dd=new DepositDao();
		
		try {
			
			k = dd.depositAmount(accNo,name,password,amount);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		System.out.println(k);
		if(k>0)
		{
			req.setAttribute("amount", amount);
			req.getRequestDispatcher("depositSuccess.jsp").forward(req, res);
		}
		else
		{
			req.getRequestDispatcher("depositFail.jsp").forward(req, res);
		}
	}
}
