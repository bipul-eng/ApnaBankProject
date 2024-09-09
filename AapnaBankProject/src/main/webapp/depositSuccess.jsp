<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="regSuccess.css">

<style>
td
{
text-align: center;
}
table
{
border-spacing: 20px;
}
</style>

</head>
<body>

<%
Long amount=Long.parseLong(request.getParameter("amount"));
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
			<li><a>WITHDRAW</a></li>
			<li><a>TRANSFER</a></li>
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
		<th>Your amount has increased by <%=amount %></th>
		</tr>
		
	
		
		</table>
		
		</div>
	

		

	</div>
	
</body>
</html>