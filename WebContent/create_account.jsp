<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=#eb984e>
	<h1>Please register into your account.</h1>

	<form action="Customer_register" method="post">
		<pre>
  
    FirstName:<input type="text"
					placeholder="enter your Firstname" name="First_name">
	LastName:<input type="text" placeholder="enter your Lastname"
					name="Last_name">
    PhoneNumber:<input type="text"
					placeholder="enter your Phonenumber " name="Phone_num">
	Address:<input type="text" placeholder="enter your Address "
					name="Address">
	UserName:<input type="text" placeholder="enter your username"
					name="User_name">
	Password:<input type="password"
					placeholder="password max 10 characters" name="Password">
  
 
		
		<button type="submit">Login</button>
	</pre>
	</form>

</body>
</html>