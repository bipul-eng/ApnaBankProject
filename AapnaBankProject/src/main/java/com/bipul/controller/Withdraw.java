package com.bipul.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.bipul.model.WithdrawDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int k=0;
		
		long accno = Long.parseLong(req.getParameter("ano"));
		String name = req.getParameter(req.getParameter("uname"));
		String password = req.getParameter("pass");
		long amount = Long.parseLong(req.getParameter("amount"));
		
		WithdrawDao wd=new WithdrawDao();
		
		try {
			k = wd.withdrawAmount(accno,name,password,amount);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		if(k<0)
		{
			req.getRequestDispatcher("withdrawFail.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("amount", amount);
			req.getRequestDispatcher("withdrawSuccess.jsp").forward(req, res);
		}
	}
}
