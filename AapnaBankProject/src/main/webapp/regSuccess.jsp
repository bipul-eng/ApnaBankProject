<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bipul.model.UserBean" %>
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
UserBean ub=(UserBean)request.getAttribute("customer");
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
			<li><a>BALANCE</a></li>
			<li><a>DEPOSIT</a></li>
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
		<th>ACCOUNT NUMBER</th>
		<th>USER NAME</th>
		<th>PASSWORD</th>
		<th>AMOUNT</th>
		<th>ADDRESS</th>
		<th>PHONE</th>
		</tr>
		
		<tr>
		<td><%=ub.getUserAccount() %></td>
		<td><%=ub.getUserName() %></td>
		<td><%=ub.getPassword() %></td>
		<td><%=ub.getAmount() %></td>
		<td><%=ub.getAddress() %></td>
		<td><%=ub.getPhone() %></td>
		</tr>
		
		</table>
		
		</div>
	

		

	</div>
	
</body>
</html>