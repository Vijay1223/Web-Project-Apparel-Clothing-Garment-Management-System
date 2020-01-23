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
	<form action="Upcloth" method="post">
		<%
try
{
	Class.forName(driverName);
	Connection con = DriverManager.getConnection(url, user, paassword);
	String queryString1 = "SELECT * FROM Cloth";
	String queryString2 = "SELECT * FROM Brand";
	String queryString3 = "SELECT * FROM Material_type";


PreparedStatement ps1 = con.prepareStatement(queryString1);
PreparedStatement ps2 = con.prepareStatement(queryString2);
PreparedStatement ps3 = con.prepareStatement(queryString3);
ResultSet rs = ps1.executeQuery();
ResultSet rss = ps2.executeQuery();
ResultSet rsss = ps3.executeQuery();
%>
		<p>
			Select CLOTH ID : <select name="attribute">

				<%  while(rs.next()){ %>
				<option><%= rs.getString(1)%></option>
				<% } %>
			</select>

		</p>
		<p>
			Select Brand name : <select name="Brand_namee">

				<%  while(rss.next()){ %>
				<option><%= rss.getString(1)%></option>
				<% } %>
			</select>

		</p>
		<p>
			Select Material ID : <select name="Material_typeidd">

				<%  while(rsss.next()){ %>
				<option><%= rsss.getString(1)%></option>
				<% } %>
			</select>

		</p>
		<%
}
catch (ClassNotFoundException | SQLException e) {

	e.printStackTrace();
}
%>




		<p>
			TypeName:- <input type="text" placeholder="Enter the type name"
				name="Type_namee">
		</p>
		<p>
			Colour:- <input type="text" placeholder="Enter the color"
				name="Colorr">
		</p>
		<p>
			Size:- <input type="text" placeholder="Enter the size" name="Sizee">
		</p>
		<p>
			<button type="submit">Update</button>
		</p>

	</form>

</body>
</html>