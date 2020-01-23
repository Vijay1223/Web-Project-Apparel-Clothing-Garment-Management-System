<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=#eb984e>
	<%@ page import="java.io.*"%>
	<%@ page import="java.sql.*"%>

	<%! String driverName = "com.mysql.jdbc.Driver";%>
	<%!String url = "jdbc:mysql://localhost:3306/apparel_management";%>
	<%!String user = "root";%>
	<%!String paassword = "root";%>
	<form action="DelCust" method="post">
		<%
try
{
	Class.forName(driverName);
	Connection con = DriverManager.getConnection(url, user, paassword);
	String queryString1 = "SELECT * FROM Customer";
	


PreparedStatement ps1 = con.prepareStatement(queryString1);

ResultSet rs = ps1.executeQuery();

%>
		<p>
			Select CLOTH ID : <select name="User">

				<%  while(rs.next()){ %>
				<option><%= rs.getString(5)%></option>
				<% } %>
			</select>
		<p>
			<button type="submit">Delete record</button>
		<p></p>

		<%
}
catch (ClassNotFoundException | SQLException e) {

	e.printStackTrace();
}
%>
	</form>
</body>
</html>