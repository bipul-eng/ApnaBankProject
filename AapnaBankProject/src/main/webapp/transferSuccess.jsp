<%@page import="com.bipul.model.TransferDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="register.css">
<title>Insert title here</title>
</head>
<body>

<%
Long accno=(Long)request.getAttribute("accno");
Long taccno=(Long)request.getAttribute("taccno");

TransferDao td=new TransferDao();
Double amount1=td.amountBalance(accno);
Double amount2=td.amountBalance(taccno);



%>

<div class="main">

		<div>
			<img width="450px" src="APANA BANK.jpg">
		</div>

		<div>
			<h1>APANA - BANK</h1>
			<span>ExtraOrdinary Service</span>
		</div>

	</div>

	<div class="nav">
		<ul>
			<li><a href="register.html">NEW ACCOUNT</a></li>
			<li><a href="balance.html">BALANCE</a></li>
			<li><a href="deposit.html">DEPOSIT</a></li>
			<li><a href="withdraw.html">WITHDRAW</a></li>
			<li><a href="transfer.html">TRANSFER</a></li>
			<li><a>CLOSE A/C</a></li>
			<li><a>ABOUT US</a></li>
		</ul>
	</div>
	
<div class="section">

		<div>
			<h2>Services</h2>
			<h3>www.javatpoint.com</h3>
			<h3>www.javatpoint.com</h3>
			<h3>www.javatpoint.com</h3>
		</div>

		<div>
		
	
		<table>
		
		<tr>
		<th>Target account balance <%=amount1 %></th>
		<th>Source account balance <%=amount2 %></th>
		</tr>
		
	
		
		</table>
		
		</div>
	

	</div>
</body>
</html>