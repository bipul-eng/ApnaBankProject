<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="register.css">
</head>
<body>

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
			<h2>WITHDRAW FORM</h2>
			<h3>Please Provide Correct UserName and Password</h3>
			
			<form action="transfer" method="post">
			
			ACCOUNT NO :
			<input type="number" name="ano" required>
			<br>
			<br>
			
			USER NAME :
			<input type="text" name="uname" required="required">
			<br>
			<br>
			
			PASSWORD :
			<input type="text" name="pass" required="required">
			<br>
			<br>
			
			TARGET ACCOUNT NUMBER :
			<input type="number" name="taccno" required="required">
			<br>
			<br>
			
			AMOUNT :
			<input type="number" name="amount" required="required">
			<br>
			<br>
			
			<input type="submit" value="Submit">
			<input type="reset" value="Reset">
			
			</form>
		</div>

		<div>
			<h2>Welcome</h2>
			<img width="350px" height="150px" src="welcome.jpg">
			
			<p>A bank is a financial institution that accepts deposits from the
			public and creates a demand deposit while simultaneously making
			loans.[1] Lending activities can be directly performed by the bank or
			indirectly through capital markets.[2]</p>
		</div>

	</div>


</body>
</html>