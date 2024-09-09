package com.bipul.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.bipul.model.TransferDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transfer")
public class Transfer extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int k=0;
		long accno = Long.parseLong(req.getParameter("ano"));
		String name = req.getParameter("uname");
		String password = req.getParameter("pass");
		long taccno = Long.parseLong(req.getParameter("taccno"));
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		TransferDao td=new TransferDao();
		
		try {
			k = td.transferAmount(accno,name,password,taccno,amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(k<0)
		{
			req.getRequestDispatcher("transferFail.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("accno", accno);
			req.setAttribute("taccno", taccno);
			req.getRequestDispatcher("transferSuccess.jsp").forward(req, res);
		}
	}
}
